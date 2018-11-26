package com.newlecture.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSplitPaneUI;

@WebServlet("/calcu")
public class Calcu extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int resultNum = 0;
		String cmd = request.getParameter("cmd");
		String opp = request.getParameter("opp");
		String sumStr = request.getParameter("sumStr");
		if(sumStr == null || sumStr.equals("null")) {
			sumStr = "";
		}
		String result = request.getParameter("result");
		
		if(cmd != null) {
			sumStr += cmd;
		}else if(cmd == null && result == null) {
			request.setAttribute("opp", opp);
			sumStr += opp;
		}
		
		if(result != null) {
			
			//char oppChar = opp.charAt(0);
			String opp_ = opp;
			String[] strArr;
			
			switch (opp_) {
			case "+":
				strArr = sumStr.split("\\+");
				resultNum = Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[1]);
				break;
			case "-":
				strArr = sumStr.split("\\-");
				resultNum = Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[1]);
				break;
			case "¡¿":
				strArr = sumStr.split("\\¡¿");
				resultNum = Integer.parseInt(strArr[0]) * Integer.parseInt(strArr[1]);	
				break;
			case "¡À":
				strArr = sumStr.split("\\¡À");
				resultNum = Integer.parseInt(strArr[0]) / Integer.parseInt(strArr[1]);
				break;
			case "C":
				strArr = sumStr.split("\\C");
				strArr[0]=null; strArr[1]=null;
				resultNum = 0;
			}
		}
			
		System.out.println("sumStr:"+sumStr);
		System.out.println("oppChar"+opp);
		RequestDispatcher dispatcher = request.getRequestDispatcher("calcu.jsp");
		request.setAttribute("opp", opp);
		request.setAttribute("sumStr", sumStr);
		request.setAttribute("resultNum", resultNum);
		dispatcher.forward(request, response);
		dispatcher = request.getRequestDispatcher("calcu.jsp");

	}

}
