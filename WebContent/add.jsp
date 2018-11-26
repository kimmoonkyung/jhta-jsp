<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%-- <%!
private int add(int x, int y){
	return x + y;
}
%> --%>


<%
int x = 3;
int y = 4;

int sum = x + y;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>holly shitttt</title>
</head>
<body>
	<form action="add" method="post">
			<div>
				<label>값 입력 하시오</label>
			</div>
			<div>
				<input type="text" placeholder="x값 입력" name ="x" />
			</div>
			<div>
				<input type="text" placeholder="y값 입력" name ="y" />
			</div>
			<div>
				<input type="submit" name="cmd" value="+"/>
				<input type="submit" name="cmd" value="application"/>
				<input type="submit" name="cmd" value="session"/>
				<input type="submit" name="cmd" value="cookie"/>
			</div>
			<div>
			<label>sum : ${sum } - ${param.s }
			<input type="hidden" name="sum" value="x+y = ${sum }"/> 
			<%-- <% out.print(sum); %>
			<%= sum %> --%>
			</label>
			<span></span>
			</div>
	</form>
	<a href="mypage.jsp">마이페이지</a>
</body>
</html>