package servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.collections.CaseInsensitiveKeyMap;

import dao.ChoiceDao;
import dao.ChoiceViewDao;
import dao.InvestDao;
import dao.QuestionDao;
import entity.ChoiceView;
import entity.Invest;
import entity.Question;

@WebServlet("/EditInvest")
public class EditInvestServlet extends HttpServlet {
	int q_id;
	Question que;
	String q_content;
	Enumeration<String> paras;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//中文处理
		//request.setCharacterEncoding("utf-8");
		if(request.getParameter("q_id")!=null) {
			q_id=Integer.valueOf(request.getParameter("q_id"));
		}
		if(request.getParameter("q_content")!=null) {
			q_content=request.getParameter("q_content").toString();
		}
		Invest inv=(Invest)request.getSession().getAttribute("inv");		
		String opt=request.getParameter("opt");
		InvestDao invdao=new InvestDao();
		QuestionDao qdao=new QuestionDao();
		ChoiceViewDao cvdao=new ChoiceViewDao();
		ChoiceDao cdao=new ChoiceDao();
		switch (opt) {
		case "queryAll":
			//在InvestServlet中已经设置了Attribute:inv
			//还需要qlist和cvlist来显示问题和选项
			List<Question> qlist=qdao.queryQuestionByI_id(inv.getId());
			List<ChoiceView> cvlist=cvdao.queryChoiceViewsByinv_id(inv.getId());
			request.getSession().setAttribute("inv", invdao.queryInvestByInv_id(inv.getId()));
			request.getSession().setAttribute("qlist", qlist);
			request.getSession().setAttribute("cvlist", cvlist);
			response.sendRedirect("edit_invest.jsp");
			break;
		case "editInv":
			String ntitle=request.getParameter("title");
			String ncontent=request.getParameter("inv_content");
			if(ntitle!=null&&!ntitle.equals("")&&!ntitle.equals(inv.getTitle())) {
				invdao.updateTitle(inv.getId(), ntitle);
			}
			if(ncontent!=null&&!ncontent.equals("")&&!ncontent.equals(inv.getContent())) {
				invdao.updateContent(inv.getId(), ncontent);
			}
			response.sendRedirect("EditInvest?opt=queryAll");
			break;
		case "createQue":
			//在数据库新建问题并转到选项编辑页面
			int type=Integer.valueOf(request.getParameter("type"));
			int cnum=Integer.valueOf(request.getParameter("cnum"));
			qdao.addQuestion(q_content, inv.getId(), type);
			//填空题没有选项，直接创建成功
			if(type==0) {
				cnum=0;
				response.sendRedirect("EditInvest?opt=queryAll");
				return;
			}
			request.getSession().setAttribute("cnum", cnum);
			que=new Question(qdao.getLastQuestion_id(), q_content, inv.getId(), type);
			request.getSession().setAttribute("que", que);
			response.sendRedirect("createChoice.jsp");
			break;
		case "createChoice":
			paras=request.getParameterNames();			
			while(paras.hasMoreElements()) {
				String ps=paras.nextElement().toString();
				if(ps.startsWith("c_")) {
					cdao.addChoice(request.getParameter(ps), q_id);
				}
			}
			response.sendRedirect("EditInvest?opt=queryAll");
			break;
		case "deleteQuestion":
			qdao.deleteQueByQ_id(q_id);
			response.sendRedirect("EditInvest?opt=queryAll");
			break;
		case "editQuestion":
			que=qdao.getQuestionByQ_id(q_id);
			request.getSession().setAttribute("que", que);
			request.getSession().setAttribute("clist", cvdao.queryChoiceViewsByQ_id(q_id));
			response.sendRedirect("editQuestion.jsp");
			break;
		case "update":
			//修改q和c的内容
			qdao.updateQ_content(q_content, q_id);
			paras=request.getParameterNames();			
			while(paras.hasMoreElements()) {
				String ps=paras.nextElement().toString();
				if(ps.startsWith("c_")) {
					cdao.updateC_content(request.getParameter(ps).toString(), Integer.valueOf(ps.substring(2)));
				}
			}
			response.sendRedirect("EditInvest?opt=queryAll");
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
