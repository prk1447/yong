<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container>">
	<table id="table" class="table table-bordered table-hover">
		<thead>
			<tr>
				<th data-field="jtnum" class="text-center">번호</th>
				<th data-field="jttext" class="text-center">문자</th>
			</tr>
		</thead>
		<tbody id="result_tbody">
	</table>
</div>
JTNUM : <input type="text" id="search"/>
<input type="button" id="getJt" value="jt리스트 호출"/>
<div id="jt_div" class="container"></div>
<script>
$("#getJt").click(function()
{
	var search = $("#search").val();
	var param = {};
	param["search"] = search;
	param = JSON.stringify(param);
	var a = 
	{
		type	:	"POST"
	,	url		:	"/test/json_select.jsp"
	,	dataType	:	"json"
	,	beforeSend	:	function(xhr)
		{
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		}
	,	data	:	param
	,	success	:	function(result)
		{
			$("#table").bootstrapTable(
			{
	            data: result
	        });
		}
	,	error	:	function(xhr, status, e)
		{
			alert("에러 : " + e);
		}
	,	done	:	function(e)
		{
			
		}
	};
	$.ajax(a);
});
</script>