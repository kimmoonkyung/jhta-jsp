package com.newlecture.web.controller.customer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.entity.Notice;

@WebServlet("/customer/notice/reg")
@MultipartConfig(
		fileSizeThreshold = 1024*1024, //1�ް� ����Ʈ
		maxFileSize = 1024*1024*10, //10�ް�
		maxRequestSize = 1024*1024*10*5 //10�ް� 5������
		)
public class NoticeRegController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/notice/reg.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// /upload��� ���� -> �������� �����ʹ� ��� �ɰ��ΰ�,
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String path = request.getServletContext().getRealPath("/upload");
		System.out.println(path);
		
		String filePath = path + File.separator + "aa.jpg"; //file.seprator �ü�� �� ��θ� ǥ���ϴ� / \ �� �޶� �̰ɷ� ���������� ����
		
		String title = request.getParameter("title"); // ������ �ӽú����� �ƴϴ�  _�Ⱦ���
		String content = request.getParameter("content");
		Part part = request.getPart("file");
		InputStream fis = part.getInputStream();
		OutputStream fos = new FileOutputStream(filePath);
		
		byte [] buf = new byte[1024];
		int size = 1024;
		while((size = fis.read(buf)) >= 0 ) // 1024, 1024, 23, -1, -1, -1, -1
				fos.write(buf, 0, size);
		
		System.out.println(title);
		
		String sql = "insert into notice(ID, TITLE, WRITER_ID, CONTENT) " +
					"VALUES(NOTICE_SEQ.NEXTVAL, ?, ?, ?)";
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"c##sist","dclass"); 
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, "TAEJIN");
			st.setString(3, content);
			
			int affected = st.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		response.sendRedirect("list");
	
	}
	
	/*@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getPart("");
		//req.getParts("");//��������
	}*/
}
