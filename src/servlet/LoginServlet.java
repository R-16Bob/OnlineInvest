package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		UserDao userdao=new UserDao();
		if(!uname.equals("")&&!pwd.equals("")){
			List<User> users=userdao.queryAllUsers();
			for(User u:users) {
				if(uname.equals(u.getUser_name())) {
					if(pwd.equals(u.getPwd())) {
						//登录成功
						request.getSession().setAttribute("uname", uname);
						//设置session属性user_id
						setId(uname, request);
						request.getSession().removeAttribute("error");
						response.sendRedirect("Invest?opt=queryAll");
						return;
					}
					else {
						//用户名或密码不正确
						//可以在session存放错误信息
						request.getSession().setAttribute("error", "登录失败：用户名或密码不正确!");
						response.sendRedirect("login.jsp");
						return;
					}
				}
			}
			//数据库中没有对应的用户名，自动注册
			userdao.addUser(uname, pwd);
			request.getSession().setAttribute("uname", uname);
			setId(uname, request);
			request.getSession().removeAttribute("error");
			response.sendRedirect("Invest?opt=queryAll");
		}
		else{
			//用户名或密码没填,登录不成功
			response.sendRedirect("login.jsp");
			//可以在session存放错误信息
			request.getSession().setAttribute("error", "登录失败：用户名或密码为空!");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void setId(String uname,HttpServletRequest request) {
		UserDao dao=new UserDao();
		int id=dao.getIdByUname(uname);
		request.getSession().setAttribute("user_id", id);
	}
}
