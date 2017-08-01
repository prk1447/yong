<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.dto.UserInfo" %>
<link rel="stylesheet" href="<%=rootPath%>/ui/signin.css"/>
<body>
<div class="container">
	<center><img src="https://ncache.ilbe.com/files/attach/new/20160807/377678/73009766/8553454912/91a0d2537595b1f86f1c79e153e34522.jpeg" style="width:304px;height:250px"/></center>
	<form class="form-signin" action="<%=rootPath%>/user/login_ok.jsp">
		<h2 class="form-signin-heading" align="center">로그인</h2>
		<label for="inputEmail" class="sr-only">아이디</label>
		<input type="text" id="userid" name="userid" class="form-control" placeholder="아이디" required autofocus>
		<label for="inputPassword" class="sr-only">비밀번호</label>
		<input type="password" id="userpwd" name="userpwd" class="form-control" placeholder="비밀번호" required>
		<button class="btn btn-lg btn-primary btn-block" type="button">Log In</button>
	</form>
</div>
<script>
$("button.btn").click(function()
{
	var id = $("#userid").val();
	var pwd = $("#userpwd").val();
	var param = {};
	param["userid"] = id;
	param["userpwd"] = pwd;
	param = JSON.stringify(param);
	$.ajax(
	{
		type	: "POST"
	,	url		: "/user/login_ok.jsp"
	,	dataType	: "json"
	,	beforeSend	: function(xhr)
		{
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		}
	,	data	: param
	,	success	: function(result)
		{
			alert(result.msg);
			alert(result.login);
			location.href="<%=rootPath%>/main.jsp";
		}
	,	error	: function(xhr, status, e)
		{
			alert("에러 : " + e);
		}
	,	done	: function(e)
		{
			
		}
	});
});
</script>
</body> 
</html>