<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.dto.UserInfo" %>
<link rel="stylesheet" href="<%=rootPath%>/ui/signin.css"/>
<body>
<jsp:include page="/common/top.jsp" flush="false">
	<jsp:param value="<%=login%>" name="login"></jsp:param>
</jsp:include>
<div class="container">
	<center><img src="http://logofury.com/wp-content/uploads/2004/skype-logo.jpg" style="width:304px;height:250px"/></center>
	<form class="form-signin" action="<%=rootPath%>/user/login_ok.jsp">
		<h2 class="form-signin-heading" align="center">로그인</h2>
		<label for="userid" class="sr-only">아이디</label>
		<input type="text" name="userid" class="form-control" placeholder="아이디" required autofocus>
		<label for="userpwd" class="sr-only">비밀번호</label>
		<input type="password" name="userpwd" class="form-control" placeholder="비밀번호" required>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
	</form>
<script>
$("button").click(function()
	{
		alert(1);
	});
$("#btn1").click(function()
		{
			alert(2);
		});
</script>
</div>
</body>
</html>