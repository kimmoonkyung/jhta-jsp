package com.newlecture.web.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/customer/notice/detail")
public class NoticeDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. 사용자가 전달한 id 값을 읽어온다. 이거를 mvc 패턴으로 바꾼당
		//int id = rs.getInt("id");
		
		int id = Integer.parseInt(request.getParameter("id"));

		String sql = "SELECT * FROM NOTICE WHERE ID = " + id;
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"c##sist","dclass"); 
			Statement st = con.createStatement();

			ResultSet rs =st.executeQuery(sql);
			
			rs.next();
			
			/*//2. 데이터 베이스에서 id=?인 레코드를 얻어오는 JDBC 코드를 작성한다.
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writerId = rs.getString("writer_id");
			String regdate = rs.getString("regdate");
			int hit = rs.getInt("hit");*/
			
			Notice n = new Notice(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getString("writer_id"),
					rs.getDate("regdate"),
					rs.getInt("hit")
					);
			
			rs.close();
			st.close();
			con.close();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/notice/detail.jsp");
			/*request.setAttribute("title", title);
			request.setAttribute("content", content);
			request.setAttribute("writer_id", writerId);
			request.setAttribute("regdate", regdate);
			request.setAttribute("hit", hit);*/
			request.setAttribute("n", n);
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
