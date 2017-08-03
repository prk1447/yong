<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%
Gson g = new Gson();
HashMap<String, String> hm = g.fromJson(request.getReader(), HashMap.class);
String numStr = "";
int jtnum = 0;
if(hm != null)
{
	numStr = hm.get("search");
	if(!numStr.equals(""))
	{
		jtnum = Integer.parseInt(numStr);
	}
}
Connection con = null;
PreparedStatement ps = null;
ArrayList<Map<String, String>> jtList = new ArrayList<Map<String, String>>();
try
{
	con = DBConn2.getCon();
	String sql = "select jtnum, jttext from json_test";
	if(!numStr.equals("") && numStr != null)
	{
		sql += " where jtnum=?";
	}
	ps = con.prepareStatement(sql);
	if(!numStr.equals("") && numStr != null)
	{
		ps.setInt(1, jtnum);
	}
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
		Map<String, String> jthm = new HashMap<String, String>();
		jthm.put("jtnum", rs.getString("jtnum"));
		jthm.put("jttext", rs.getString("jttext"));
		jtList.add(jthm);
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
	if(ps!=null)
	{
		ps.close();
		ps = null;
	}
	DBConn2.closeCon();
}
String json = g.toJson(jtList);
System.out.println(json);
out.print(json);
%>