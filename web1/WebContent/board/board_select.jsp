<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%@ page import="com.test.dto.BoardInfo" %>
<script>
function doInsert()
{
	location.href = rootPath + "/board/board_insert.jsp";	
}
</script>
<body>
<%
PreparedStatement ps = null;
BoardInfo bi = new BoardInfo();
try(final Connection con = DBConn2.getCon())
{
	out.println("== " + userId + " == 님 안녕하세요");
	String sql = "select binum, bititle, bicontent, bipwd, creusr, credat from board_info";
	ps = con.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	String tableStr = "<table border='1'>";
	tableStr += "<tr>";
	tableStr += "<td>게시판번호</td>";
	tableStr += "<td>제목</td>";
	tableStr += "<td>내용</td>";
	tableStr += "<td>작성자</td>";
	tableStr += "<td>작성일자</td>";
	tableStr += "<td>비밀번호</td>";
	tableStr += "<td>삭제</td>";
	tableStr += "</tr>";
	while(rs.next())
	{
		tableStr += "<tr>";
		tableStr += "<td>" + rs.getInt("binum") + "</td>";
		tableStr += "<td>" + rs.getString("bititle") + "</td>";
		tableStr += "<td>" + rs.getString("bicontent") + "</td>";
		tableStr += "<td>" + rs.getString("creusr") + "</td>";
		tableStr += "<td>" + rs.getString("credat") + "</td>";
		tableStr += "<td><input type='text' name='pwdequls' id='pwdequls'/></td>";
		tableStr += "<td><input type='button' value='삭제' onclick='doMovePage(\"delete\"," + rs.getInt("binum") + ",\"pwdequls\")'/></td>";
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
<input type="button" value="게시글 작성" onclick="doInsert()"/>
<input type="button" value="메인으로" onclick="doMovePage('main')"/>
</body>
</html>