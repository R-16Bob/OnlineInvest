package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChoiceViewDao;
import dao.InvestDao;
import dao.QuestionDao;
import entity.ChoiceView;
import entity.Invest;
import entity.Question;


@WebServlet("/ShowInvest")
public class ShowInvestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int invest_id=Integer.valueOf(request.getParameter("invest_id").toString());
		InvestDao invdao=new InvestDao();
		QuestionDao qdao=new QuestionDao();
		ChoiceViewDao cvdao=new ChoiceViewDao();
		Invest inv=invdao.queryInvestByInv_id(invest_id);
		List<Question> qlist=qdao.queryQuestionByI_id(invest_id);
		List<ChoiceView> cvlist=cvdao.queryChoiceViewsByinv_id(invest_id);
		request.getSession().setAttribute("inv", inv);
		request.getSession().setAttribute("qlist", qlist);
		request.getSession().setAttribute("cvlist", cvlist);
		response.sendRedirect("showInvest.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
