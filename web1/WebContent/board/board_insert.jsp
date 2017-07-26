<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%@ page import="com.test.dto.BoardInfo" %>
<script>
function doMain()
{
	location.href = rootPath + "/board/board_select.jsp";
}
</script>
<body>
<%
Connection con = null;
PreparedStatement ps = null;
BoardInfo bi = new BoardInfo();
String title = request.getParameter("bititle");
String content = request.getParameter("bicontent");
String pwd = request.getParameter("bipwd");

bi.setBiTitle(title);
bi.setBiContent(content);
bi.setBiPwd(pwd);
if(title != null && content != null && pwd != null)
{
	try
	{
		con = DBConn2.getCon();	
		String sql = "insert into board_info(bititle, bicontent, bipwd, creusr, credat)";
		sql += " values(?,?,?,?,now())";
		ps = con.prepareStatement(sql);
		ps.setString(1, bi.getBiTitle());
		ps.setString(2, bi.getBiContent());
		ps.setString(3, bi.getBiPwd());
		ps.setString(4, userId);
		int result = ps.executeUpdate();
		if(result == 1)
		{
			con.commit();
			out.println("작성 성공");
		}
		else
		{
			out.println("작성 실패");
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
%>
<form action="<%=rootPath%>/board/board_insert.jsp">
<table border="1">
	<tr>
		<td colspan="2"><p align="center"> = 게시글작성 = </p></td>
	</tr>
	<tr>
		<td align="center">제목</td>
		<td><input type="text" name="bititle"/></td>
	</tr>
	<tr>
		<td align="center">내용</td>
		<td><textarea name="bicontent"></textarea></td>
	</tr>
	<tr>
		<td align="center">비밀번호</td>
		<td><input type='password' name="bipwd"/></td>
	</tr>
	<tr>
		<td align="center"><input type="submit" value ="작성하기"/></td>
		<td align="center"><input type="button" value="게시판으로" onclick="doMain()"/></td>
	</tr>
</table>
</form>
</body>
</html>