/*import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/add")
public class Add extends HttpServlet {
	
    ����
    �ڹ����α׷� + �� ���/�Է�
    ��� : response->��Ʈ��, ������ ����, ���ڵ�
    �Է� : ��û�� �� �Է�->��û GET, POST
    GET ��û�� �� �����ϴ� ���� ���� : �޶�� �Ϳ� ���� �ɼ�
    POST ��û�� �� �����ϴ� ���� ���� : ���, ���, � ó���� �䱸�ϴ� ������

    POST ��û�� ���� GET�� �����Ѵ�.
     �ݴ�� ���ϸ�->GET ��û�� ���� �ɼ� POST�� ������ ���� �ִ�.
             ��, ���ϴ� ������ �Է´���(Form)�� ���ؼ� ���ϴ� ������ "����(POST)"���� �� �ִ�.
	 
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
		out.write("<title> ���� �̰�tq </title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"add\" method=\"post\">");
		out.write("			<div>");
		out.write("				<td>�� �Է� �Ͻ�5</td>");
		out.write("			</div>");
		out.write("			<div>");
		out.write("				<div>");
		out.write("					<input type=\"text\" placeholder=\"x�� �Է� : \" name =\"x\" value=\""+ x +"\" />");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<input type=\"text\" placeholder=\"y�� �Է� : \" name =\"y\" value=\""+ y +"\" />");
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
		out.write(" <a href=\"\"> ����������</a>");
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
		// post ó�� forward -> �ٽ� post�� ��û�ϰ� �ȴ�. //GET�� ��û�� �� ���� // �ڱ� �ڽ��� ��� �θ�, ���я�
		
		response.sendRedirect("sum"+sum); // GET ��û�� ����
		
		
		// ���� �������� �ٸ� ������ ��û�ϴ� ��� �� ����
		Redirect -> ���ݱ��� ó���� ����� ������� ������ ���ο� ������ ��û�� ��
				 -> ���� ������ ��û�� ������ �����ؾ� �� ���� ���� ���.
		Forward	-> ���� ������ ���ο� �������� ó���� ���� �޾Ƽ� �̾�� �� ��
		
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title> ���� �̰�tq </title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"add\" method=\"post\">");
		out.write("			<div>");
		out.write("				<td>�� �Է� �Ͻ�5</td>");
		out.write("			</div>");
		out.write("			<div>");
		out.write("				<div>");
		out.write("					<input type=\"text\" placeholder=\"x�� �Է� : \" name =\"x\" value=\""+ x +"\" />");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<input type=\"text\" placeholder=\"y�� �Է� : \" name =\"y\" value=\""+ y +"\" />");
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

		if(request.getMethod().equals("POST")) { // POST�϶���
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
		out.write("<title> ���� �̰�tq </title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"add\" method=\"post\">");
		out.write("			<div>");
		out.write("				<td>�� �Է� �Ͻ�5</td>");
		out.write("			</div>");
		out.write("			<div>");
		out.write("				<div>");
		out.write("					<input type=\"text\" placeholder=\"x�� �Է� : \" name =\"x\" value=\""+ x +"\" />");
		out.write("				</div>");
		out.write("				<div>");
		out.write("					<input type=\"text\" placeholder=\"y�� �Է� : \" name =\"y\" value=\""+ y +"\" />");
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