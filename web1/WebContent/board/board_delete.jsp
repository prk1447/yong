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
String sql = "delete from board_info where binum=? and bipwd=?";
String result = "";
int resultNum = 0;
try
{
	con = DBConn2.getCon();
	ps = con.prepareStatement(sql);
	ps.setString(1, biNum);
	ps.setString(2, biPwd);
	resultNum = ps.executeUpdate();
	if(resultNum > 0)
	{
		result = biNum + "지우기성공";
		con.commit();
	}
	else
	{
		result = "비밀번호를 제대로 입력해주세요";
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
<script>
alert("<%=result%>");
if(<%=resultNum%> == 1)
{
	location.href = "<%=rootPath%>/board/board_select.jsp";
}
else
{
	history.back();	
}
</script>
</body>
</html>