<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%@ page import="com.test.dto.UserInfo" %>
<body>
<%
int pUnum = Integer.parseInt(request.getParameter("usernum"));
Connection con = null;
PreparedStatement ps = null;
int uNum = 0;
String uId = "";
String uName = "";
int uAge = 0;
String uAddress = "";
String uHp1 = "";
String uHp2 = "";
String uHp3 = "";
try
{
	con = DBConn2.getCon();
	String sql = "select usernum, userid, userpwd, username, age, address, hp1, hp2, hp3 from user_info";
	sql += " where usernum=?";
	ps = con.prepareStatement(sql);
	ps.setInt(1, pUnum);
	ResultSet rs = ps.executeQuery();
	rs.last();
	int rowCnt = rs.getRow();
	if(rowCnt == 0)
	{
		%>
		<script>
			alert("<%=pUnum%>번 회원은 이미 탈퇴했습니다.");
			history.back();
		</script>
		<%
	}
	rs.beforeFirst();
	while(rs.next())
	{
		uNum = rs.getInt("usernum");
		uId = rs.getString("userid");
		uName = rs.getString("username");
		uAge = rs.getInt("age");
		uAddress = rs.getString("address");
		uHp1 = rs.getString("hp1");
		uHp2 = rs.getString("hp2");
		uHp3 = rs.getString("hp3");
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
	if(ps!=null){
		ps.close();
		ps = null;
	}
	DBConn2.closeCon();
}
%>
<div class="container">
	<div class="starter-template">
		<table border="1" class='table table-bordered table-hover'>
			<tr>
				<td colspan="2" align="center"> === 유저 정보 ===</td>
			</tr>
			<tr align="center">
				<td>UserNum</td>
				<td><%=uNum%></td>
			</tr>
			<tr align="center">
				<td>UserID</td>
				<td><%=uId%></td>
			</tr>
			<tr align="center">
				<td>UserNAME</td>
				<td><%=uName%></td>
			</tr>
			<tr align="center">
				<td>UserAddress</td>
				<td><%=uAddress%></td>
			</tr>
			<tr align="center">
				<td>UserPhoneNum</td>
				<td><%=uHp1%> - <%=uHp2%> - <%=uHp3%></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="button" value="수정" onclick="modifyBoard()"/>
				<input type="button" value="삭제" onclick="deleteBoard()"/></td>
			</tr>
		</table>
	</div>
</div>
<script>
</body>
</html>