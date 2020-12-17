package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InvestDao;

@WebServlet("/Create_invest")
public class Create_investServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
		//根据传入的title,content,User_id创建invest
		int user_id=Integer.valueOf(request.getSession().getAttribute("user_id").toString());
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		InvestDao investDao=new InvestDao();
		investDao.addInvest(title, content, user_id);
		response.sendRedirect("Invest?opt=edit&invest_id="+investDao.getLastInvest_id());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
