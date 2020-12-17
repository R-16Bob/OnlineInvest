package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InvestDao;
import entity.Invest;


@WebServlet("/Invest")
public class InvestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.valueOf(request.getSession().getAttribute("user_id").toString());		
		String opt=request.getParameter("opt");
		InvestDao investDao = new InvestDao();
		switch(opt) {
		case "queryAll":
			request.getSession().setAttribute("invlist", investDao.queryAllInvestsByUser_id(id));
			response.sendRedirect("index.jsp");
			break;
		case "delete":
			int invest_id=Integer.valueOf(request.getParameter("invest_id"));
			investDao.deleteInvestById(invest_id);
			response.sendRedirect("Invest?opt=queryAll");
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
