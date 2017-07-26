<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%@ page import="com.test.dto.UserInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
public void printStr(String str)
{
	System.out.println("asdasd");
}
%>
<%
String id =request.getParameter("id");
String pwd = request.getParameter("pwd");
String result = "";

if(id != null && pwd != null)
{
	Connection con = null;
	PreparedStatement ps = null;
	UserInfo ui = new UserInfo();
	ui.setuserId(id);
	ui.setUserPwd(pwd);
	try
	{
		con = DBConn2.getCon();
		String sql = "select username, userpwd, age, address, hp1, hp2, hp3 from user_info";
		sql += " where userid=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, ui.getuserId());
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			String userName = rs.getString("username");
			String userPwd = rs.getString("userpwd");
			int age = rs.getInt("age");
			String address = rs.getString("address");
			String hp1 = rs.getString("hp1");
			String hp2 = rs.getString("hp2");
			String hp3 = rs.getString("hp3");
			if(userPwd.equals(ui.getUserPwd()))
			{
				result += "로그인성공";
				session.setAttribute("userid", ui.getuserId());
				session.setAttribute("username", userName);
				session.setAttribute("address", address);
				session.setAttribute("age", age);
				session.setAttribute("hp1", hp1);
				session.setAttribute("hp2", hp2);
				session.setAttribute("hp3", hp3);
			}
			else
			{
				result = "비밀번호 틀렸어 임마!";
			}
		}
	}
	catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(ps != null)
		{
			ps.close();
			ps = null;
		}
		if(con != null)
		{
			DBConn2.closeCon();
		}
	}
}
else
{
	session.invalidate();
	result = "로그아웃";
}
%>
<script>
alert("<%=result%>");
location.href="/user/login.jsp";
</script>
</body>
</html>