import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/hello")
public class Nana extends HttpServlet {

	public void service(HttpServletRequest request
					, HttpServletResponse response) throws IOException, ServletException {
	
//		OutputStream os =response.getOutputStream();
//		PrintStream out = new PrintStream(os, true);
//		out.println("�Ϳ�~ ��� ����Servlet");
		
//		System.out.println("Hello Taejin");
		
//		out2.println("hello ������");
//		int x = 3/0;
		
		//Writter
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String cnt_ = request.getParameter("cnt");
		int cnt = 0;
		
		if(cnt_ != null && !cnt_.equals("")) {
			cnt = Integer.parseInt(cnt_);
		} else {
			out.println("�⺻��");
		}
		
		for (int i = 0; i < cnt; i++) 
			out.println("Hello ������ !!<br />");
	}
}
