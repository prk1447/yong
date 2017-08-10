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
<select id="join_vendor">
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
	goPage(params, "/list.goods", callback);
});

function callback(results)
{
	var goodsList = results.list;
	var pageInfo = results.page;
	setPagination(pageInfo, "page");
	setEvent(pageInfo);
    $('#table').bootstrapTable('destroy');
    $('#table').bootstrapTable(
    {
        data: goodsList
    });
}

function setEvent(pageInfo)
{
	$("ul[class='pagination']>li:not([class='disabled'])>a").click(function()
	{	
		var thisNowPage = pageInfo.nowPage;
		var goPageNum = new Number(this.innerHTML);
		if(isNaN(goPageNum))
		{
			if(this.innerHTML == "≪")
			{
				thisNowPage = 1;
			}
			else if(this.innerHTML == "＜")
			{
				thisNowPage = Math.floor((pageInfo.nowPage - 1) / 10) * 10 - 9; 
			}
			else if(this.innerHTML == "＞")
			{
				thisNowPage = Math.floor((pageInfo.nowPage - 1) / 10) * 10 + 11;
			}
			else if(this.innerHTML == "≫")
			{
				thisNowPage = pageInfo.totalPageCnt;
			}
			
			if(thisNowPage <= 0)
			{
				thisNowPage = 1;
			}
			else if(thisNowPage > pageInfo.thisTotalPage)
			{
				thisNowPage = pageInfo.totalPageCnt;
			}
			goPageNum = thisNowPage;
		}
		var page = {};
		page["nowPage"] = "" + goPageNum;
		var params = {};
		params["page"] = page;
		params["command"] = "list";
		goPage(params, "/list.goods", callback);
	})
}

$("#getValue").click(function()
{
	var viselect = $("#join_vendor").val();
	var param = {};
	param["join_vendor"] = viselect;
	param = JSON.stringify(param)
	var a = 
	{
		type	:	"POST"
	,	url		:	"/test/join_select.jsp"
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