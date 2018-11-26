<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<style>
			input{
				width:50px;
				height: 50px;
				margin: 5px;
				/* margin-bottom: 5px;
				margin-right: 5px; */
			}
			.zero{
				width: 180px;
			}
			#result{
				width: 245px;
			}
			#num, #plus, #minus, #division, #multiply {
				width : 100px;
				height: 25px;
				margin-bottom: 5px;
			}
	</style>
<body>
	<form action="cal" method="post">
				<div>
					<input type="submit" value="CE" />
					<input type="submit" value="C" name="cmd"/>
					<input type="submit" value="≪" />
					<input type="submit" value="÷" name="cmd" />
				</div>
				<div>
					<input type="submit" value="7" name="cmd" />
					<input type="submit" value="8" name="cmd"/>
					<input type="submit" value="9" name="cmd"/>
					<input type="submit" value="×" name="cmd"/>
				</div>
				<div>
					<input type="submit" value="4" name="cmd"/>
					<input type="submit" value="5" name="cmd"/>
					<input type="submit" value="6" name="cmd"/>
					<input type="submit" value="-" name="cmd" />
				</div>
				<div>
					<input type="submit" value="1" name="cmd"/>
					<input type="submit" value="2" name="cmd"/>
					<input type="submit" value="3" name="cmd"/>
					<input type="submit" value="+" name="cmd" />
				</div>
				
				
				<div>
					<!-- <input type="button" value="±" /> -->
					<input class="zero" type="submit" value="0" name="cmd" />
					<!-- <input type="button" style="font-weight: bold;" value="." /> -->
					<input type="submit" value="=" name="cmd"/>
				</div>
				<input type="text" value="${num}" name="num"/>
	</form>
		
</body>
</html>