<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%@ page import="com.test.dto.BoardInfo" %>
<body>
<%
int pBinum = Integer.parseInt(request.getParameter("binum"));
Connection con = null;
PreparedStatement ps = null;
int biNum = 0;
String bititle = "";
String bicontent = "";
String bipwd = "";
String creusr = "";
String credat = "";
try
{
	con = DBConn2.getCon();
	String sql = "select binum, bititle, bicontent, bipwd, creusr, credat from board_info where binum=?";
	ps = con.prepareStatement(sql);
	ps.setInt(1, pBinum);
	ResultSet rs = ps.executeQuery();
	rs.last();
	int rowCnt = rs.getRow();
	if(rowCnt == 0)
	{
		%>
		<script>
			alert("<%=pBinum%>번 게시물은 이미 지워져있습니다.");
			history.back();
		</script>
		<%
	}
	rs.beforeFirst();
	while(rs.next())
	{
		biNum = rs.getInt("binum");
		bititle = rs.getString("bititle");
		bicontent = rs.getString("bicontent");
		creusr = rs.getString("creusr");
		credat = rs.getString("credat");
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
				<td colspan="2" align="center"> === 게시글 정보 ===</td>
			</tr>
			<tr align="center">
				<td>게시글 번호</td>
				<td><%=biNum%></td>
			</tr>
			<tr align="center">
				<td>제목</td>
				<td><%=bititle%></td>
			</tr>
			<tr align="center">
				<td>내용</td>
				<td><%=bicontent%></td>
			</tr>
			<tr align="center">
				<td>글쓴이</td>
				<td><%=creusr%></td>
			</tr>
			<tr align="center">
				<td>생성일자</td>
				<td><%=credat%></td>
			</tr>
			<tr align="center">
				<td>비밀번호</td>
				<td><input type="password" name="bipwd" id="bipwd"/></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="button" value="수정" onclick="modifyBoard()"/>
				<input type="button" value="삭제" onclick="deleteBoard()"/></td>
			</tr>
		</table>
	</div>
</div>
<script>
function modifyBoard()
{
	var bipwd = document.getElementById("bipwd").value;
	location.href = "<%=rootPath%>/board/board_modify.jsp?binum=<%=biNum%>&bipwd=" + bipwd;
}
function deleteBoard()
{
	var bipwd = document.getElementById("bipwd").value;
	location.href= "<%=rootPath%>/board/board_delete.jsp?binum=<%=biNum%>&bipwd=" + bipwd; 
}
</script>
</body>
</html>