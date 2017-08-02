<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%
Gson g = new Gson();
HashMap<String, String> hm = g.fromJson(request.getReader(), HashMap.class);
String numStr1 = hm.get("num1");
String numStr2 = hm.get("num2");
int num1 = Integer.parseInt(numStr1);
int num2 = Integer.parseInt(numStr2);
String op = hm.get("op");

int result = 0;
if(op.equals("+"))
{
	result = (num1 + num2);
}
else if(op.equals("-"))
{
	result = (num1 - num2);
}
else if(op.equals("*"))
{
	result = (num1 * num2);
}
else if(op.equals("/"))
{
	result = (num1 / num2);
}
int insertResult = 0;
PreparedStatement ps = null;
Connection con = null;
try
{
	con = DBConn2.getCon();
	String sql = "insert into cal(num1, op, num2, result)";
	sql += " values(?,?,?,?)";
	ps = con.prepareStatement(sql); 
	ps.setInt(1, num1);
	ps.setString(2, op);
	ps.setInt(3, num2);
	ps.setInt(4, result);
	insertResult = ps.executeUpdate();
	if(insertResult == 1)
	{
		con.commit();
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
	ps.close();
	DBConn2.closeCon();
}
HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
resultMap.put("resultnum", result);
resultMap.put("insert", insertResult);
String json = new Gson().toJson(resultMap);
out.write(json);
%>