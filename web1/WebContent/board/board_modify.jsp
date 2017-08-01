<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%@ page import="com.test.dto.BoardInfo" %>
<body>
<%
int pBinum = Integer.parseInt(request.getParameter("binum"));
String pBiPwd = request.getParameter("bipwd");
Connection con = null;
PreparedStatement ps = null;
int binum = 0;
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
	ps.setInt(1,pBinum);
	ResultSet rs = ps.executeQuery();
	rs.last();
	int rowCnt = rs.getRow();
	if(rowCnt==0)
	{
%>
<script>
	alert("<%=pBinum%>번 게시물은 이미 지워졌습니다.");
	history.back();
</script>
<%
	}
	rs.beforeFirst();
	while(rs.next())
	{
		binum = rs.getInt("binum");
		bititle = rs.getString("bititle");
		bicontent = rs.getString("bicontent");
		creusr = rs.getString("creusr");
		credat = rs.getString("credat");
		bipwd = rs.getString("bipwd");
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
%>
	<jsp:param value="<%=login%>" name="login"></jsp:param>
</jsp:include>
<div class="container">
	<div class="starter-template">
	<form method="get" action="<%=rootPath%>/board/board_modify_ok.jsp" >
		<table border="1" class="table table-bordered table-hover">
		<tr align="center">
			<td>제목</td>
			<td><input type="text" name="bititle" id="bititle" value="<%=bititle%>"/></td>
		</tr>
		<tr align="center">
			<td>내용</td>
			<td><textarea name="bicontent" id="bicontent"><%=bicontent%></textarea></td>
		</tr>
		<tr align="center">
			<td>글쓴이</td>
			<td><input type="text" name="creusr" id="creusr" value="<%=creusr%>"/></td>
		</tr>
		<tr align="center">
			<td>비밀번호</td>
			<td><input type="password" name="bipwd" id="bipwd" value="<%=bipwd%>"/></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="수정하기"/>
			<input type="hidden" value="<%=binum%>" name="binum"/></td>
		</tr>
		</table>
	</form>
	</div>
</div>
</body>
</html>