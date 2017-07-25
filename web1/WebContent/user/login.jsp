<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%@ page import="com.test.dto.UserInfo" %>
<script>
var setObj;
var loopCount = 0;
function doSign()
{
	location.href="/user/sign_in.html";	
}
function doLogOut()
{
	location.href = rootPath + "/user/login_ok.jsp";
}
/*
function doStartTimer()
{
	setObj = setInterval(function()
		{
			if(loopCount == 10)
			{
				clearInterval(setObj);
			}
			else
			{
				loopCount++;
				alert("안녕하세요");
			}
		}
		,1000);	
}
function doStopTimer()
{
	clearInterval(setObj);
}
*/
</script>
<body>
<%
if(login)
{
	out.println("현재시간 : " + toDateStr);
	out.println("<br/>");
	out.println("== " + userId + "님 의 정보 ==");
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
	out.println("<input type='button' value='게시판보기' onclick='doMovePage(\"board\")'/>");
}
else
{
%>
<form action="<%=rootPath%>/user/login_ok.jsp">
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