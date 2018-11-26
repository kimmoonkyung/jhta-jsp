/*import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/add")
public class Add extends HttpServlet {
	
    서블릿
    자바프로그램 + 웹 출력/입력
    출력 : response->스트림, 콘텐츠 종류, 인코딩
    입력 : 요청할 때 입력->요청 GET, POST
    GET 요청일 때 전달하는 값의 성절 : 달라는 것에 대한 옵션
    POST 요청일 때 전달하는 값의 성질 : 계산, 등록, 어떤 처리를 요구하는 데이터

    POST 요청일 때는 GET을 수반한다.
     반대로 말하면->GET 요청일 때는 옵션 POST를 수반할 수도 있다.
             즉, 원하는 내용을 입력대장(Form)을 통해서 원하는 내용을 "제출(POST)"받을 수 있다.
	 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		int x = 0;
		int y = 0;
		int sum = 0;
		
		String sum_ = request.getParameter("s");
		if(sum_ != null)
			sum = Integer.parseInt(sum_);

		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title> 뭐야 이게tq </title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"add\" method=\"post\">");
		out.write("			<div>");
		out.write("				<td>값 입력 하시5</td>");
		out.write("			</div>");
		out.write("			<div>");
		out.write("				<div>");
		out.write("					<input type=\"text\" placeholder=\"x값 입력 : \" name =\"x\" value=\""+ x +"\" />");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<input type=\"text\" placeholder=\"y값 입력 : \" name =\"y\" value=\""+ y +"\" />");
		out.write("					<input type=\"submit\" value=\"9ood\"/>");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<label>x : "+ x + "</label>");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<label>y : "+ y + "</label>");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<label>sum : "+ sum + "</label>");
		out.write("				</div>");
		out.write("			</div>");
		out.write("	</form>");
		out.write(" <a href=\"\"> 마이페이지</a>");
		out.write("</body>");
		out.write("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		int x = 0;
		int y = 0;
		int sum = 0;

		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");

		if(x_ != null) 
			x = Integer.parseInt(x_);
		if(y_ != null) 
			y = Integer.parseInt(y_);

		sum = x + y;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/add");
		request.setAttribute("sum", sum);
		dispatcher.forward(request, response);
		// post 처리 forward -> 다시 post를 요청하게 된다. //GET을 요청할 수 없다 // 자기 자신을 계속 부름, 무한뤂
		
		response.sendRedirect("sum"+sum); // GET 요청만 가능
		
		
		// 현재 서블릿에서 다른 서블릿을 요청하는 방법 두 가지
		Redirect -> 지금까지 처리한 내용과 상고나없이 완전히 새로운 서블릿을 요청할 때
				 -> 지금 서블릿과 요청될 서블릿이 공유해야 할 것이 없는 경우.
		Forward	-> 지금 서블릿이 새로운 서블릿에게 처리한 것을 받아서 이어가야 할 때
		
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title> 뭐야 이게tq </title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"add\" method=\"post\">");
		out.write("			<div>");
		out.write("				<td>값 입력 하시5</td>");
		out.write("			</div>");
		out.write("			<div>");
		out.write("				<div>");
		out.write("					<input type=\"text\" placeholder=\"x값 입력 : \" name =\"x\" value=\""+ x +"\" />");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<input type=\"text\" placeholder=\"y값 입력 : \" name =\"y\" value=\""+ y +"\" />");
		out.write("					<input type=\"submit\" value=\"9ood\"/>");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<label>x : "+ x + "</label>");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<label>y : "+ y + "</label>");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<label>sum : "+ sum + "</label>");
		out.write("				</div>");
		out.write("			</div>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");

	}

	public void service(HttpServletRequest request
			, HttpServletResponse response) throws IOException, ServletException {

		//Writter
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		int x = 0;
		int y = 0;
		int sum = 0;

		if(request.getMethod().equals("POST")) { // POST일때만
			String x_ = request.getParameter("x");
			String y_ = request.getParameter("y");

			if(x_ != null && !x_.equals("")) 
				x = Integer.parseInt(x_);

			if(y_ != null && !y_.equals("")) 
				y = Integer.parseInt(y_);

			sum = x + y;
		}

		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title> 뭐야 이게tq </title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"add\" method=\"post\">");
		out.write("			<div>");
		out.write("				<td>값 입력 하시5</td>");
		out.write("			</div>");
		out.write("			<div>");
		out.write("				<div>");
		out.write("					<input type=\"text\" placeholder=\"x값 입력 : \" name =\"x\" value=\""+ x +"\" />");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<input type=\"text\" placeholder=\"y값 입력 : \" name =\"y\" value=\""+ y +"\" />");
		out.write("					<input type=\"submit\" value=\"9ood\"/>");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<label>x : "+ x + "</label>");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<label>y : "+ y + "</label>");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<label>sum : "+ sum + "</label>");
		out.write("				</div>");
		out.write("			</div>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");
	}
}
*/