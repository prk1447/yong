<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="container-view"> 
		<table id="table"  data-height="460"	class="table table-bordered table-hover">
		<thead> 
			<tr> 
				<th colspan="3" class="text-center"><h5 class="form-signin-heading">회사 상세 페이지</h5></th>
			</tr>
			<tr>
				<td class="col-md-2">회사 고유번호</td>
				<td class="col-md-4" colspan="2"><%=request.getParameter("viNum")%></td>
			</tr>
			<tr>
				<td>회사 이름</td>
				<td colspan="2"><%=request.getParameter("viName")%></td>
			</tr>
			<tr>
				<td>회사 설명</td>
				<td colspan="2"><%=request.getParameter("viDesc")%></td>
			</tr>
			<tr>
				<td>회사 주소</td>
				<td colspan="2"><%=request.getParameter("viAddress")%></td>
			</tr>
			<tr>
				<td>회사 전화번호</td>
				<td colspan="2"><%=request.getParameter("viPhone")%></td>
			</tr>
			<tr>
				<td>
					<button id="btnUpdate" class="btn btn-md-2 btn-block" 	type="button">수정</button>
				</td>
				<td>
					<button id="btnDelete" class="btn btn-md-2 btn-block" 	type="button">삭제</button>
				</td>
				<td>
					<button id="btnGoList" class="btn btn-md-2 btn-block" 	type="button">리스트 이동</button>
				</td>
			</tr>
		</table>
	</div>
	<!-- /container -->
<script>
$("#btnUpdate").click(function()
{
	location.href = "/vendor/vendor_update.jsp?viNum=" + <%=request.getParameter("viNum")%>;
});

$("#btnDelete").click(function()
{
	var isDelete = confirm("해당 회사를 삭제하시겠습니까?");
	
	if(isDelete)
	{
		var params = {};
		params["viNum"] = "<%=request.getParameter("viNum")%>";
		params["command"] = "delete";
		movePageWithAjax(params, "/delete.vendor", callbackView);
	}
});

function callbackView(results)
{
	alert(results.msg);
	if(results.url != "")
	{
		location.href = results.url;
	}
}
$("#btnGoList").click(function()
{
	location.href="/vendor/vendor_list.jsp";
});
</script>
</body>
</html>