<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
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
	<form action="calcu" method="get">
				<!-- <div>
					<input id="result" type="text" value="결과 출력"/>
				</div>
				<div>
					<input id="result" type="text" placeholder="x값" name="x"/>
				</div>
				<div>
					<input id="result" type="text" placeholder="y값" name="y"/>
				</div> -->
				<div>
					<input type="submit" value="CE" />
					<input type="submit" value="C" />
					<input type="submit" value="≪" />
					<input type="submit" value="÷" name="opp" />
				</div>
				
				<%-- <c:if test ="${!empty testY }"> --%>
				<div>
					<input type="submit" value="7" name="cmd" />
					<input type="submit" value="8" name="cmd"/>
					<input type="submit" value="9" name="cmd"/>
					<input type="submit" value="×" name="opp"/>
				</div>
				<div>
					<input type="submit" value="4" name="cmd"/>
					<input type="submit" value="5" name="cmd"/>
					<input type="submit" value="6" name="cmd"/>
					<input type="submit" value="-" name="opp" />
				</div>
				<div>
					<input type="submit" value="1" name="cmd"/>
					<input type="submit" value="2" name="cmd"/>
					<input type="submit" value="3" name="cmd"/>
					<input type="submit" value="+" name="opp" />
				</div>
				<%-- </c:if> --%>
				
				<%-- <c:if test ="${empty testY }">
				<div>
					<input type="submit" value="7" name="cmd" />
					<input type="submit" value="8" name="cmd"/>
					<input type="submit" value="9" name="cmd"/>
					<input type="submit" value="×" name="opp"/>
				</div>
				<div>
					<input type="submit" value="4" name="cmd"/>
					<input type="submit" value="5" name="cmd"/>
					<input type="submit" value="6" name="cmd"/>
					<input type="submit" value="-" name="opp" />
				</div>
				<div>
					<input type="submit" value="1" name="cmd"/>
					<input type="submit" value="2" name="cmd"/>
					<input type="submit" value="3" name="cmd"/>
					<input type="submit" value="+" name="opp" />
				</div>
				</c:if> --%>
				
				<div>
					<!-- <input type="button" value="±" /> -->
					<input class="zero" type="submit" value="0" name="cmd" />
					<!-- <input type="button" style="font-weight: bold;" value="." /> -->
					<input type="submit" value="=" name="result"/>
				</div>
				
				<input type="hidden" value="${sumStr }" name="sumStr">
				<input type="hidden" value="${opp }" name="opp">
	</form>
	${sumStr }　＝　${resultNum}
	
</body>
</html>