<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%@ page import="com.test.dto.UserInfo" %>
<jsp:include page="/common/top.jsp" flush="false">
	<jsp:param value="<%=login%>" name="login"></jsp:param>
</jsp:include>
<body>
<script>
function doSearchData()
{
	var searchTarget = document.getElementById("searchTarget").value;
	var searchStr = document.getElementById("searchStr").value;
	location.href = "<%=rootPath%>/user/user_info.jsp?searchTarget=" + searchTarget + "&searchStr=" + searchStr;
}
</script>
<div class="container">
	<div class="starter-template">
<%
Connection con = null;
PreparedStatement ps = null;
String searchTarget = request.getParameter("searchTarget");
String searchStr = request.getParameter("searchStr");
UserInfo ui = new UserInfo();
boolean existData = false;
try
{
	con = DBConn2.getCon();
	String sql = "select usernum, userid, userpwd, username, age, address, hp1, hp2, hp3 from user_info where 1=1";
	if(searchTarget != null)
	{
		if(searchTarget.equals("userid"))
		{
			sql += " and userid like ?";
		}
		else if(searchTarget.equals("age"))
		{
			sql += " and age like ?";
		}
		else if(searchTarget.equals("address"))
		{
			sql += " and address like ?";
		}
	}
	con = DBConn2.getCon();
	ps = con.prepareStatement(sql);
	if(searchTarget != null)
	{
		ps.setString(1, "%" + searchStr + "%");
	}
	ResultSet rs = ps.executeQuery();
	String tableStr = "<table class='table table-bordered table-hover'>";
	tableStr += "<thead>";
	tableStr += "<tr align='center'>";
	tableStr += "<td>UserNUM</td>";
	tableStr += "<td>UserID</td>";
	tableStr += "<td>UserPWD</td>";
	tableStr += "<td>UserNAME</td>";
	tableStr += "<td>UserAGE</td>";
	tableStr += "<td>UserADDRESS</td>";
	tableStr += "<td>UserPHONENUM</td>";
	tableStr += "</tr>";
	tableStr += "</thead>";
	while(rs.next())
	{
		tableStr += "<tr align='center'>";
		tableStr += "<td>" + rs.getInt("usernum") + "</td>";
		tableStr += "<td>" + rs.getString("userid") + "</td>";
		tableStr += "<td>" + rs.getString("userpwd") + "</td>";
		tableStr += "<td>" + rs.getString("username") + "</td>";
		tableStr += "<td>" + rs.getInt("age") + "</td>";
		tableStr += "<td>" + rs.getString("address") + "</td>";
		tableStr += "<td>" + rs.getString("hp1") + "-" + rs.getString("hp2") + "-" + rs.getString("hp3") + "</td>";
		tableStr += "</tr>";
		existData = true;
	}
	if(!existData)
	{
		tableStr += "<tr>";
		tableStr += "<td colspan='7' align='center'>데이터가 존재하지 않습니다</td>";
		tableStr += "</tr>";
	}
	else
	{
		tableStr += "<tr>";
		tableStr += "<td colspan='7' align='center'>";
		tableStr += "<select name='searchTarget' id='searchTarget'>";
		tableStr += "<option value='userid'>아이디</option>";
		tableStr += "<option value='age'>나이</option>";
		tableStr += "<option value='address'>주소</option>";
		tableStr += "</select>";
		tableStr += "<input type='text' name='searchStr' id='searchStr'/>";
		tableStr += "<a href='#' class='btn btn-default' onclick='doSearchData()'>검색</a>";
		tableStr += "</td>";
		tableStr += "</tr>";
	}
	tableStr += "</table>";
	out.println(tableStr);
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
%>
	</div>
</div>
</body>
</html>