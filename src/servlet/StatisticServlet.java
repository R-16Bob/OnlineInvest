package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnswerDao;
import dao.ChoiceDao;
import dao.InvestDao;
import dao.QuestionDao;
import dao.StatisticDao;
import entity.Answer;
import entity.Choice;
import entity.Question;
import entity.Statistic;


@WebServlet("/Statistic")
public class StatisticServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opt=request.getParameter("opt");
		int invest_id=Integer.valueOf(request.getParameter("invest_id").toString());
		StatisticDao sdao=new StatisticDao();
		InvestDao idao=new InvestDao();
		request.getSession().setAttribute("statistics", sdao.getResult(invest_id));
		request.getSession().setAttribute("inv", idao.queryInvestByInv_id(invest_id));
		if(sdao.getStatisticViewsByI_id(invest_id).size()==0) {
			request.getSession().setAttribute("message", "该问卷还没有被填写过，无法统计");
			response.sendRedirect("message.jsp");
			return;
		}
		switch (opt) {
		case "show":
			//重定向
			response.sendRedirect("statistic.jsp");
			return;
		case "download":
			response.sendRedirect("downloadStatistic.jsp");
			return;
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
