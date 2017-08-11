<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="container">
	<table id="table" data-height="460" class="table table-bordered table-hover">
		<thead>
		<tr>
			<th data-field="ginum" class="text-center">GINUM</th>
			<th data-field="giname" class="text-center">GINAME</th>
			<th data-field="gidesc" class="text-center">GIDESC</th>
			<th data-field="viname" class="text-center">VINAME</th>
			<th data-field="videsc" class="text-center">VIDESC</th>
			<th data-field="viaddress" class="text-center">VIADDRESS</th>
			<th data-field="viphone" class="text-center">VIPHONE</th>
			<th data-field="vicredat" class="text-center">VICREDAT</th>
			<th data-field="vicretim" class="text-center">VICRETIM</th>
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
	var params = {};
	params["nowPage"] = "1";
	movePageWithAjax(params, "/test/vendor_info.jsp", callback);
});

function callback(results)
{
	var vendorList = results.vendorList;
	var goodsList = results.goodsList;
	var pageInfo = results.pageInfo;
	
	var blockCnt = new Number(pageInfo.blockCnt);
	thisBlockCnt = blockCnt;
	var nowPage= new Number(pageInfo.nowPage);
	thisNowPage = nowPage;
	var startBlock = Math.floor((nowPage-1)/blockCnt) * 10+1;
	var endBlock = startBlock + blockCnt - 1;
	var totalPageCnt = new Number(pageInfo.totalPageCnt);
	thisTotalPage = totalPageCnt;
	if(endBlock>totalPageCnt)
	{
		endBlock = totalPageCnt;
	}
	
	makePagination(startBlock, endBlock, pageInfo.nowPage, totalPageCnt, "page");

	for(var i=0, max=vendorList.length;i<max;i++)
	{
		$("#s_vendor").append("<option value='" + vendorList[i].vinum + "'>"+vendorList[i].viname +"</option>")
	}
    $('#table').bootstrapTable('destroy');
    $('#table').bootstrapTable(
    {
        data: goodsList
    });
    setEvent();
}

function setEvent()
{
	$("ul[class='pagination']>li>a").click(function()
	{
		var goPageNum = new Number(this.innerHTML);
		if(isNaN(goPageNum))
		{
			if(this.innerHTML == "≪")
			{
				thisNowPage = 1;
			}
			else if(this.innerHTML == "＜")
			{
				thisNowPage = Math.floor((thisNowPage - 1) / 10) * 10 - 9; 
			}
			else if(this.innerHTML == "＞")
			{
				thisNowPage = Math.floor((thisNowPage - 1 ) / 10) * 10 + 11;
			}
			else if(this.innerHTML == "≫")
			{
				thisNowPage = thisTotalPage;
			}
			
			if(thisNowPage <= 0)
			{
				thisNowPage = 1;
			}
			else if(thisNowPage > thisTotalPage)
			{
				thisNowPage = thisTotalPage;
			}
			goPageNum = thisNowPage;
		}
		var params = {};
		params["nowPage"] = "" + goPageNum;
		movePageWithAjax(params, "/test/vendor_info.jsp", callback);
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