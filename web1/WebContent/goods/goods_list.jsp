<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="container">
	<table id="table" data-height="460" class="table table-bordered table-hover">
		<thead>
		<tr>
			<th data-field="giNum" class="text-center">상품번호</th>
			<th data-field="giName" class="text-center">상품이름</th>
			<th data-field="giDesc" class="text-center">상품설명</th>
			<th data-field="viNum" class="text-center">생산자번호</th>
			<th data-field="viName" class="text-center">생산자이름</th>
		</tr>
		</thead>
	</table>
</div>
<div class="jb-center" style="text-align: center">
	<ul class="pagination" id="page"></ul>
</div>
<select id="goods_vendor">
<option value="">회사선택</option>
</select>
<input type="button" id="getValue" value="검색"/>
<div id="join_div" class="container"></div>
<script>
var thisBlockCnt = 0;
var thisNowPage = 0;
var thisTotalPage = 0;
$(document).ready(function()
{
	var page = {};
	page["nowPage"] = 1;
	var params = {};
	params["page"] = page;
	params["command"] = "list";
	params["vendor"] = $("#goods_vendor").val();
	movePageWithAjax(params, "/list.goods", callback);
});

function callback(results)
{
	var goodsList = results.list;
	var pageInfo = results.page;
	var vendorList = results.vendor;
	
    makePagination(pageInfo, "page");
	
	for(var i = 0, max = vendorList.length; i < max; i++)
	{
		$("#goods_vendor").append("<option value='" + vendorList[i].vinum + "'>"+vendorList[i].viname +"</option>")
	}
    $('#table').bootstrapTable('destroy');
    $('#table').bootstrapTable(
    {
        data: goodsList
    });
	setEvent(pageInfo, "/list.goods");
}

$("#getValue").click(function()
{
	var viselect = $("#goods_vendor").val();
	var param = {};
	param["goods_vendor"] = viselect;
	param = JSON.stringify(param)
	var a = 
	{
		type	:	"POST"
	,	url		:	"/list.goods"
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
				data	:	result
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
</body>
</html>