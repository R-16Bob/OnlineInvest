package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InvestDao;
import dao.UserDao;
import util.ExcelReader;


@WebServlet("/Excel")
public class ExcelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String opt=request.getParameter("opt");
		if(opt.equals("read")) {
			String filePath=request.getParameter("filePath");
			ExcelReader er=new ExcelReader();
			InvestDao investDao =new InvestDao();
			//需要文件名和user_id{
			if(request.getAttribute("user_id")==null)
				System.out.println("user_id是null");
			int id=Integer.valueOf(request.getAttribute("user_id").toString());
			if(!er.read(filePath, id)) {
				//创建问卷失败，删除问卷
				investDao.deleteInvestById(investDao.getLastInvest_id());
				request.setAttribute("message", "导入问卷失败，请检查文件格式");
			}
			else request.setAttribute("message", "问卷导入成功！");
			   // 跳转到 message.jsp
	        getServletContext().getRequestDispatcher("/message.jsp").forward(
	                request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
