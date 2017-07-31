<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%@ page import="com.test.dto.BoardInfo" %>
<body>
<jsp:include page="/common/top.jsp" flush="false">
	<jsp:param value="<%=login%>" name="login"></jsp:param>
</jsp:include>
<script>
function goBoard(biNum, param2)
{
	location.href = "<%=rootPath%>/board/board_view.jsp?binum=" + biNum;
}
function doSearchData()
{
	var searchTarget = document.getElementById("searchTarget").value;
	var searchStr = document.getElementById("searchStr").value;
	location.href = "<%=rootPath%>/board/board_select.jsp?searchTarget=" + searchTarget + "&searchStr=" + searchStr;
}
</script>
	<div class="container">
		<div class="starter-template">
<%
String searchTarget = request.getParameter("searchTarget");
String searchStr = request.getParameter("searchStr");
PreparedStatement ps = null;
Connection con = null;
BoardInfo bi = new BoardInfo();
try
{
	con = DBConn2.getCon();
	out.println("== " + userId + " == 님 안녕하세요");
	String sql = "select binum, bititle, bicontent, bipwd, creusr, credat from board_info where 1=1";
	if(searchTarget != null)
	{
		if(searchTarget.equals("bititle"))
		{
			sql += " and bititle like ?";
		}
		else if(searchTarget.equals("bicontent"))
		{
			sql += " and bicontent like ?";
		}
		else if(searchTarget.equals("creusr"))
		{
			sql += " and creusr like ?";
		}
		else if(searchTarget.equals("bicontitle"))
		{
			sql += " and bicontent like ? or bititle like ?";
		}
	}
	ps = con.prepareStatement(sql);
	if(searchTarget != null)
	{
		ps.setString(1, "%" + searchStr + "%");
		if(searchTarget.equals("bicontitle"))
		{
			ps.setString(2, "%" + searchStr + "%");
		}
	}
	ResultSet rs = ps.executeQuery();
	String tableStr = "<table class='table table-bordered table-hover'>";
	tableStr += "<thead>";
	tableStr += "<tr align='center'>";
	tableStr += "<td>게시판번호</td>";
	tableStr += "<td>제목</td>";
	tableStr += "<td>작성자</td>";
	tableStr += "<td>작성일자</td>";
	tableStr += "</tr>";
	tableStr += "</thead>";
	boolean existData = false;
	while(rs.next())
	{
		tableStr += "<tr align='center'>";
		tableStr += "<td>" + rs.getInt("binum") + "</td>";
		tableStr += "<td><a href='#javascript' onclick='goBoard(" + rs.getInt("binum") + ")'>" + rs.getString("bititle") +"</a></td>";
		tableStr += "<td>" + rs.getString("creusr") + "</td>";
		tableStr += "<td>" + rs.getString("credat") + "</td>";
		tableStr += "</tr>";
		existData = true;
	}
	if(!existData)
	{
		tableStr += "<tr>";
		tableStr += "<td colspan='6' align='center'>데이터가 존재하지 않습니다</td>";
		tableStr += "</tr>";
	}
	else
	{
		tableStr += "<tr>";
		tableStr += "<td colspan='6' align='center'>";
		tableStr += "<select name='searchTarget' id='searchTarget'>";
		tableStr += "<option value='bititle'>제목</option>";
		tableStr += "<option value='creusr'>작성자</option>";
		tableStr += "<option value='bicontent'>내용</option>";
		tableStr += "<option value='bicontitle'>제목 + 내용</option>";
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
<input type="button" value="게시글 작성" onclick="doMovePage('insertBoard')"/>
<input type="button" value="메인으로" onclick="doMovePage('main')"/>
	</div>
</div>
</body>
</html>