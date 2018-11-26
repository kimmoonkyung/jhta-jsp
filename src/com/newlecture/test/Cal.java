package com.newlecture.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cal")
public class Cal extends HttpServlet {
	
	@Override // TODO 두겟
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//String num = "";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("cal.jsp");
		//request.setAttribute("num", num);
		dispatcher.forward(request, response);
	}
	
	@Override // TODO 두뽀슽
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String num = "";
		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "1":
			num = request.getParameter("num");
			num += "1";
			System.out.println(num);
			System.out.println(cmd);
			break;
		case "2":
			num = request.getParameter("num");
			num += "2";
			break;
		case "3":
			num = request.getParameter("num");
			num += cmd;
			break;
		case "4":
			num = request.getParameter("num");
			num += cmd;
			break;
		case "5":
			num = request.getParameter("num");
			num += cmd;
			break;
		case "6":
			num = request.getParameter("num");
			num += cmd;
			break;
		case "7":
			num = request.getParameter("num");
			num += cmd;
			break;
		case "8":
			num = request.getParameter("num");
			num += cmd;
			break;
		case "9":
			num = request.getParameter("num");
			num += cmd;
			break;
		case "0":
			num = request.getParameter("num");
			num += cmd;
			break;
		case "+":
			num = request.getParameter("num");
			num += "+";
			break;
		case "-":
			num = request.getParameter("num");
			num += "-";
			break;
		case "×":
			num = request.getParameter("num");
			num += "×";
			break;
		case "÷":
			num = request.getParameter("num");
			num += "÷";
			break;
		case "=":
			num = request.getParameter("num");
			if(num.contains("+")) {
				num = (Integer.parseInt(num.split("\\+")[0]) + Integer.parseInt(num.split("\\+")[1]))+"";
			} else if(num.contains("-")) {
				num = (Integer.parseInt(num.split("\\-")[0]) - Integer.parseInt(num.split("\\-")[1]))+"";
			} else if(num.contains("×")) {
				num = (Integer.parseInt(num.split("\\×")[0]) * Integer.parseInt(num.split("\\×")[1]))+"";
			} else if(num.contains("÷")) {
				num = (Integer.parseInt(num.split("\\÷")[0]) / Integer.parseInt(num.split("\\÷")[1]))+"";
			}
			break;
		case "C":
			num = "";
			break;
		}
		
/*		int resultNum = 0; // 연산 값 담을거
		String cmd = request.getParameter("cmd"); // 숫자
		String opp = request.getParameter("opp"); // +, -, /, * 연산자
		String sumStr = request.getParameter("sumStr");
		
		if(sumStr == null) {
			sumStr = "";
		}
		String result = request.getParameter("result"); // = 연산자
		
		if(cmd != null) {
			sumStr += cmd;
		} else if(cmd == null && result == null) {
			request.setAttribute("opp", opp);
			sumStr += opp;
		}
		
		if(result != null) {
			String opp_ = opp;
			String[] strArr = null;
			//1이면 자바에서 total 스트링에 추가,
			switch(opp_) {
			case "+":
				strArr = sumStr.split("\\+");
				resultNum = Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[1]);
				break;
			case "-":
				strArr = sumStr.split("\\-");
				resultNum = Integer.parseInt(strArr[0]) - Integer.parseInt(strArr[1]);
				break;
			case "×":
				strArr = sumStr.split("\\×");
				resultNum = Integer.parseInt(strArr[0]) * Integer.parseInt(strArr[1]);
				break;
			case "÷":
				strArr = sumStr.split("\\÷");
				resultNum = Integer.parseInt(strArr[0]) / Integer.parseInt(strArr[1]);
				break;
			}
		}*/
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("cal.jsp");
		//request.setAttribute("cmd", cmd);
		request.setAttribute("num", num);
		/*request.setAttribute("opp", opp);
		request.setAttribute("sumStr", sumStr);
		request.setAttribute("resultNum", resultNum);*/
		dispatcher.forward(request, response);
		//dispatcher = request.getRequestDispatcher("cal.jsp");
	}

}
 