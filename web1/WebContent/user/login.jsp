<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn" %>
<%@ page import="com.test.dto.UserInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
function doLogOut()
{
	location.href="/user/login_ok.jsp";
}
function doTitle()
{
	location.href="/user/select_user.html";	
}
function doSign()
{
	location.href="/user/sign_in.html";	
}
</script>
<body>
<%
String userId = (String) session.getAttribute("userid");
if(userId != null)
{
	String userName = (String) session.getAttribute("username");
	int age = (int) session.getAttribute("age");
	String address = (String) session.getAttribute("address");
	String hp1 = (String) session.getAttribute("hp1");
	String hp2 = (String) session.getAttribute("hp2");
	String hp3 = (String) session.getAttribute("hp3");
	out.println(userId + "님");
	out.println("<br/>");
	out.println("==" + userId + "님 의 정보");
	out.println("<br/>");
	out.println("성명 : " + userName);
	out.println("<br/>");
	out.println("나이 : " + age);
	out.println("<br/>");
	out.println("주소 : " + address);
	out.println("<br/>");
	out.println("전화번호 : " + hp1 + "-" + hp2 + "-" + hp3);
	out.println("<br/>");
	out.println("<input type='button' value='로그아웃' onclick='doLogOut()'/>");
	out.println("<input type='button' value='게시판보기' onclick='doTitle()'/>");
}
else
{
%>
<form action="/user/login_ok.jsp">
ID : <input type="text" name="id"/><br/>
PWD : <input type="password" name="pwd"/><br/>
<input type="submit" value="LOGIN"/>
<input type="button" value="SIGN" onclick="doSign()"/>
</form>
<%
}
%>
</body>
</html>