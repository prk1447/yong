<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%@ page import="com.test.dto.BoardInfo" %>
<body>
<%
Connection con = null;
PreparedStatement ps = null;
BoardInfo bi = new BoardInfo();
String biNum = request.getParameter("binum");
String biPwd = request.getParameter("bipwd");
bi.setBiNum(Integer.parseInt(biNum));
bi.setBiPwd(biPwd);
String result = "";
try
{
	con = DBConn2.getCon();
	String sql = "delete from board_info where binum=? and bipwd=?";
	ps = con.prepareStatement(sql);
	ps.setInt(1, bi.getBiNum());
	ps.setString(2, bi.getBiPwd());
	int resultNum = ps.executeUpdate();
	if(resultNum > 0)
	{
		result = bi.getBiNum() + "지우기성공";
		con.commit();
	}
	else
	{
		result = bi.getBiNum() + "이란 값이 없습니다.";
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
%>
<script>
alert("<%=result%>");
location.href="/board/board_select.jsp";
</script>
</body>
</html>