package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnswerDao;
import dao.StatisticDao;
import entity.Question;


@WebServlet("/SubmitInvest")
public class SubmitInvestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnswerDao adao=new AnswerDao();
		StatisticDao sdao=new StatisticDao();
		//获取ip地址
		String ip=request.getRemoteAddr();
		List<Question> qlist=(List<Question>)request.getSession().getAttribute("qlist");
		//按照qlist顺序把answer和statistic插入数据库
		for(Question q:qlist) {
			String content;
			if(q.getType()==2) {
				//多选题
				String[] values=request.getParameterValues("q"+q.getQ_id());
				StringBuffer value=new StringBuffer(values[0]);
				for(int i=1;i<values.length;i++) {
					value.append("|"+values[i]);
				}
				content=value.toString();
			}
			else { 
				//单选或填空
				String value=request.getParameter("q"+q.getQ_id());
				content=value;
			}
			adao.addAnswer(content, q.getQ_id());
			sdao.addStatistic(adao.getLastAnswer_id(), ip);
		}
		response.sendRedirect("submitMessage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
