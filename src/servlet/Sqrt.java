package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sqrt")
public class Sqrt extends HttpServlet {  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=GB2312");
		out.println("<html><body>");
		String number=request.getParameter("num");
		double n=0;
		try {
			n=Double.parseDouble(number);
			out.print("<br>"+Math.sqrt(n));
		} catch (Exception e) {
			out.print("<h1>input number letter please!</h1>");
		}
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
