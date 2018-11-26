<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/* //1. 사용자가 전달한 id 값을 읽어온다. 이거를 mvc 패턴으로 바꾼당
	//int id = rs.getInt("id");
	int id = Integer.parseInt(request.getParameter("id"));

	String sql = "SELECT * FROM NOTICE WHERE ID = " + id;
	
	String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection(url,"c##sist","dclass"); 
	Statement st = con.createStatement();

	ResultSet rs =st.executeQuery(sql);
	
	rs.next();
	
	//2. 데이터 베이스에서 id=?인 레코드를 얻어오는 JDBC 코드를 작성한다.
	String title = rs.getString("title");
	String content = rs.getString("content");
	String writerId = rs.getString("writer_id");
	String regdate = rs.getString("regdate");
	int hit = rs.getInt("hit");
	
	rs.close();
	st.close();
	con.close(); */
	Notice n = (Notice)request.getAttribute("n");
	request.setAttribute("n", n);
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="../../css/customer.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<!-- header 영역 -->
		<jsp:include page="../../inc/header.jsp" />
		
		<div id="visual" class="customer">
			<div class="top-wrapper">
				
			</div>
		</div>
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<h2>공지사항</h2>
					<h3 class="hidden">방문페이지위치</h3>
					<ul id="breadscrumb" class="block_hlist">
						<li id="home">
							<a href="">HOME</a>
						</li>
						<li>
							<a href="">고객센터</a>
						</li>
						<li>
							<a href="">공지사항</a>
						</li>
					</ul>
					<div id="notice-article-detail" class="article-detail margin-large" >						
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								제목
							</dt>
							<dd class="article-detail-data">
								<%-- <%=request.getAttribute("title") %> --%>
								${n.title }
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								작성일
							</dt>
							<dd class="article-detail-data">
								<%-- <%=request.getAttribute("regdate") %> --%>
								${n.regDate }
							</dd>
						</dl>
						<dl class="article-detail-row half-row">
							<dt class="article-detail-title">
								작성자
							</dt>
							<dd class="article-detail-data half-data" >
								<%-- <%=request.getAttribute("writer_id") %> --%>
								${n.writerId }
							</dd>
						</dl>
						<dl class="article-detail-row half-row">
							<dt class="article-detail-title">
								조회수
							</dt>
							<dd class="article-detail-data half-data">
								<%-- <%=request.getAttribute("hit") %> --%>
								${n.hit }
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								첨부파일
							</dt>
							<dd class="article-detail-data">
								<a href="../../upload/aa.jpg" download>aa.jpg</a>
							</dd>
						</dl>

						<div class="article-content" >
							<img src="http://sstatic.naver.net/keypage/outside/info/2011031017145546407.jpg" /><br />
								<%-- <%=request.getAttribute("content") %> --%>
								${n.content }
								<img src="../../upload/aa.jpg" alt="싁빵" />
						</div>
					</div>
					<p class="article-comment margin-small">
						<a class="btn-list button" href="list">목록</a>						
						<a class="btn-edit button" href="edit.jsp">수정</a>
						<a class="btn-del button" href="noticeDel.jsp">삭제</a>
					</p>
					<div class="margin-small" style="border-top: 1px solid #dfdfdf;">
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								▲ 다음글
							</dt>
							<dd class="article-detail-data">
								다음 글이 없습니다.
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">g
								▼ 이전글
							</dt>
							<dd class="article-detail-data">
								제 12회 창업스쿨
							</dd>
						</dl>
					</div>					
				</div>				
				<!-- 에이사이드 영역 -->
				<jsp:include page="../inc/aside.jsp" />
							
			</div>
		</div>
		<!-- footer 영역 -->
		<jsp:include page="../../inc/footer.jsp" />
	</body>
</html>
