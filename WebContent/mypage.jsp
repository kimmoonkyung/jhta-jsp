<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>application : ${applicationScope.sum }</li>
		<li>session : ${sessionScope.sum }</li> <!-- %= session.getAttribute("sum") %> -->
		<li>cookie : </li>
	</ul>
	<div>
		<a href="add">덧셈하기</a>
	</div>
</body>
