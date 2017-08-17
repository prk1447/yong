<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="container-view"> 
		<table id="table"  data-height="460"	class="table table-bordered table-hover">
		<thead> 
			<tr> 
				<th colspan="2" class="text-center"><h5 class="form-signin-heading">회사 등록 페이지</h5></th>
			</tr>
			<tr>
				<td class="col-md-2">회사 고유번호</td>
				<td class="col-md-4"><input type="text" name="viNum" id="viNum"></td>
			</tr>
			<tr>
				<td>회사 이름</td>
				<td><input type="text" name="viName" id="viName"></td>
			</tr>
			<tr>
				<td>회사 설명</td>
				<td><input type="text" name="viDesc" id="viDesc"></td>
			</tr>
			<tr>
				<td>회사 주소</td>
				<td><input type="text" name="viAddress" id="viAddress"></td>
			</tr>
			<tr>
				<td>회사 전화번호</td>
				<td><input type="text" name="viPhone" id="viPhone"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button id="btnInsert" class="btn btn-primary" 	type="button">회사 등록</button>
					<button id="goList" class="btn" 	type="button">취소</button>
				</td>
			</tr>
		</table>
	</div>
	<!-- /container -->
<script>
$("#btnInsert").click(function()
{
	var params = {};
	params["command"] = "insert";
	params["viNum"] = $("#viNum").val();
	params["viName"] = $("#viName").val();
	params["viDesc"] = $("#viDesc").val();
	params["viAddress"] = $("#viAddress").val();
	params["viPhone"] = $("#viPhone").val();
	movePageWithAjax(params, "/insert.vendor", callbackInsert);
});

$(document).ready(function()
{
	var params = {};
	params["command"] = "insert";
	movePageWithAjax(params, "/insert.vendor");
})

function callbackInsert(results)
{
	alert(results.msg);
	location.href = results.url;
}


$("#goList").click(function()
{
	location.href = "/vendor/vendor_list.jsp";	
})
</script>
</body>
</html>