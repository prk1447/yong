<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%@ page import="com.google.gson.*" %>
<%@ page import="com.test.common.DBConn2" %>

<%
Gson g = new Gson();
HashMap<String, String> hm = g.fromJson(request.getReader(), HashMap.class);
String vendor = "";
if(hm != null)
{
	vendor = hm.get("join_vendor");
}
Connection con = null;
PreparedStatement ps = null;
ArrayList<Map<String, String>> joinList = new ArrayList<Map<String, String>>();
try
{
	con = DBConn2.getCon();
	String sql = "select gi.ginum, gi.giname, gi.gidesc,vi.viname,vi.videsc,vi.viaddress,vi.viphone,vi.vicredat,vi.vicretim";
	sql += " from goods_info gi, vendor_info vi where gi.vinum = vi.vinum";
	if(vendor !=null && !vendor.equals(""))
	{
		sql += " and viname=?";
	}
	ps = con.prepareStatement(sql);
	if(vendor !=null && !vendor.equals(""))
	{
		ps.setString(1, vendor);
	}
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
		Map<String, String> jhm = new HashMap<String, String>();
		jhm.put("ginum", rs.getString("gi.ginum"));
		jhm.put("giname", rs.getString("gi.giname"));
		jhm.put("gidesc", rs.getString("gi.gidesc"));
		jhm.put("viname", rs.getString("vi.viname"));
		jhm.put("videsc", rs.getString("vi.videsc"));
		jhm.put("viaddress", rs.getString("vi.viaddress"));
		jhm.put("viphone", rs.getString("vi.viphone"));
		jhm.put("vicredat", rs.getString("vi.vicredat"));
		jhm.put("vicretim", rs.getString("vi.vicretim"));
		joinList.add(jhm);
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
String json = g.toJson(joinList);
System.out.println(json);
out.print(json);
%>