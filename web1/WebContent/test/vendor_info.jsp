<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn2"%>
<%@ page import="com.google.gson.*"%>
<%@ page import="java.util.*"%>

<%
int rowCnt = 10;
int nowPage = 0;
int blockCnt = 10;
int totalPageCnt = 0;
int totalBlockCnt = 0;
int totalCnt = 0;

Gson g = new Gson();
HashMap<String, String> hm = g.fromJson(request.getReader(), HashMap.class);
if(hm != null && hm.get("nowPage") != null)
{
	nowPage = Integer.parseInt(hm.get("nowPage"));
}
Connection con = null;
PreparedStatement ps = null;
ArrayList<Map<String, String>> vendorList = new ArrayList<Map<String, String>>();
ArrayList<Map<String, String>>goodsList = new ArrayList<Map<String, String>>();
try
{
	con = DBConn2.getCon();
	String sql = "select vinum, viname from vendor_info";
	ps = con.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
		Map<String, String> vhm = new HashMap<String, String>();
		vhm.put("vinum", rs.getString("vinum"));
		vhm.put("viname", rs.getString("viname"));
		vendorList.add(vhm);
	}
	sql = "select count(1) from goods_info as gi, vendor_info as vi where gi.vinum=vi.vinum";
	ps = con.prepareStatement(sql);
	rs = ps.executeQuery();
	while(rs.next())
	{
		totalCnt = rs.getInt(1);
	}
	if(totalCnt != 0)
	{
		int mod = totalCnt % rowCnt;
		totalPageCnt = totalCnt/rowCnt;
		if(mod != 0)
		{
			totalPageCnt += 1;
		}
	}
	
	if(totalPageCnt != 0)
	{
		int mod = totalPageCnt % blockCnt;
		totalBlockCnt = totalPageCnt/blockCnt;
		if(mod != 0)
		{
			totalBlockCnt += 1;
		}
	}
	System.out.println(totalCnt);
	System.out.println(totalPageCnt);
	System.out.println(totalBlockCnt);
	sql = "select gi.ginum, gi.giname, gi.gidesc,vi.viname,vi.videsc,vi.viaddress,vi.viphone,vi.vicredat,vi.vicretim";
	sql += " from goods_info as gi, vendor_info as vi where gi.vinum = vi.vinum";
	sql += " order by gi.ginum";
	sql += " limit ?,?";
	ps = con.prepareStatement(sql);
	ps.setInt(1, (nowPage-1)*rowCnt);
	ps.setInt(2, rowCnt);
	rs = ps.executeQuery();
	while(rs.next()){
		Map<String, String>rhm = new HashMap<String, String>();
		rhm.put("ginum", rs.getString("gi.ginum"));
		rhm.put("giname", rs.getString("gi.giname"));
		rhm.put("gidesc", rs.getString("gi.gidesc"));
		rhm.put("viname", rs.getString("vi.viname"));
		rhm.put("videsc", rs.getString("vi.videsc"));
		rhm.put("viaddress", rs.getString("vi.viaddress"));
		rhm.put("viphone", rs.getString("vi.viphone"));
		rhm.put("vicredat", rs.getString("vi.vicredat"));
		rhm.put("vicretim", rs.getString("vi.vicretim"));
		goodsList.add(rhm);
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
HashMap<String, Integer> pageHm = new HashMap<String, Integer>();
pageHm.put("nowPage", nowPage);
pageHm.put("totalPageCnt", totalPageCnt);
pageHm.put("totalBlockCnt", totalBlockCnt);
pageHm.put("blockCnt", blockCnt);
pageHm.put("totalCnt", totalCnt);
HashMap resultHm = new HashMap();
resultHm.put("vendorList", vendorList);
resultHm.put("goodsList", goodsList);
resultHm.put("pageInfo", pageHm);

String json = g.toJson(resultHm);
//System.out.println(json);
out.print(json);
%>