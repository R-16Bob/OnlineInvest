package servlet;
 
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionDao;
import dao.StatisticDao;
import entity.Question;
import entity.StatisticView;
import util.ExcelWriter;
 
 
@WebServlet("/DownLoad") 
public class DownLoadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int inv_id=Integer.valueOf(request.getParameter("inv_id").toString());	
	QuestionDao qdao=new QuestionDao();
	List<Question> qlist=qdao.queryQuestionByI_id(inv_id);
	StatisticDao sdao=new StatisticDao();
	List<StatisticView> slist=sdao.getStatisticViewsByI_id(inv_id);
	String filename = request.getParameter("filename");	
	String filepath="E:\\tomcat9\\apache-tomcat-9.0.39\\webapps\\OnlineInvest\\output\\"+filename;
	ExcelWriter writer=new ExcelWriter();
	writer.write(filepath, qlist, slist);
	response.addHeader("content-Type", "application/octet-stream");
	
	String agent = request.getHeader("User-Agent");
	
	 if(agent.toLowerCase().indexOf("chrome")>0)
	{
		response.addHeader("content-Disposition", "attachment;filename="+new String(filename.getBytes("UTF-8"), "ISO8859-1"));
	}
	else
	{
		response.addHeader("content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "UTF-8"));
	}
	InputStream in = getServletContext().getResourceAsStream("/output/"+filename);
	ServletOutputStream out = response.getOutputStream();
	byte[] bs=new byte[1024];
	int len=-1;
	while((len=in.read(bs))!=-1)
	{
		out.write(bs,0,len);
	}
	out.close();
	in.close();
	}
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
 


}
