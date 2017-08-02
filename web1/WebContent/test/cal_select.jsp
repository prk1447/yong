<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%
Connection con = null;
PreparedStatement ps = null;
String searchId = request.getParameter("searchId");
String tableStr = "";
try
{
	con = DBConn2.getCon();
	String sql = "select calnum, num1, op, num2, result from cal";
	if(searchId != null)
	{
		sql += " where op=?";
	}
	ps = con.prepareStatement(sql);
	if(searchId != null)
	{
		ps.setString(1, searchId);
	}
	ResultSet rs = ps.executeQuery();
	tableStr += "<table border='1'>";
	tableStr += "<tr align='center'>";
	tableStr += "<td>번호</td>";
	tableStr += "<td>첫번째 숫자</td>";
	tableStr += "<td>연산자</td>";
	tableStr += "<td>두번째 숫자</td>";
	tableStr += "<td>결과값</td>";
	tableStr += "</tr>";
	while(rs.next())
	{
		tableStr += "<tr align='center'>";
		tableStr += "<td>" + rs.getInt("calnum") + "</td>";
		tableStr += "<td>" + rs.getInt("num1") + "</td>";
		tableStr += "<td>" + rs.getString("op") + "</td>";
		tableStr += "<td>" + rs.getString("num2") + "</td>";
		tableStr += "<td>" + rs.getString("result") + "</td>";
		tableStr += "</tr>";
	}
	tableStr += "</table>";
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
	DBConn2.closeCon();
}
String json = new Gson().toJson(tableStr);
out.write(json);
%>