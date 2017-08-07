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
$(document).ready(function()
{
	var params = {};
	params["nowPage"] = "101";
	params = JSON.stringify(params);
	var a = 
	{
		type	:	"POST"
	,	url		:	"/test/vendor_info.jsp"
	,	dataType	:	"json"
	,	beforeSend	:	function(xhr)
		{
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		}
	
	,	data	:	params
	,	success	:	function(results)
		{
			var vendorList = results.vendorList;
    		var goodsList = results.goodsList;
    		var pageInfo = results.pageInfo;
    		var pageStr = "<li><a>≪</a></li>";
    		pageStr += "<li><a>＜</a></li>";
    		var blockCnt = new Number(pageInfo.blockCnt);
    		var nowPage = new Number(pageInfo.nowPage);
    		var startBlock = Math.ceil((nowPage - 1) / blockCnt) * 10 + 1;
    		var endBlock = startBlock + blockCnt - 1;
    		var totalPageCnt = new Number(pageInfo.totalPageCnt);
    		if(endBlock > totalPageCnt)
    		{
    			endBlock = totalPageCnt;
    		}
    		for(var i = startBlock, max = endBlock; i <= max; i++)
    		{
    			if( i == pageInfo.nowPage )
    			{
    				pageStr += "<li class='active'><a>" + i + "</a></li>";
    			}
    			else
    			{
    				pageStr += "<li><a>" + i + "</a></li>";
    			}
    		}
    		pageStr += "<li><a>＞</a></li>";
    		pageStr += "<li><a>≫</a></li>";
    		
    		$("#page").html(pageStr);
			for(var i = 0, max=vendorList.length; i < max; i++)
			{
				$("#join_vendor").append("<option value='" + vendorList[i].viname + "'>" + vendorList[i].viname + "</option>");
			}
			$("#table").bootstrapTable(
			{
		    	data: goodsList
			});
		}
	,	error	:	function(xhr, status, e)
		{
			alert("에러 : " + e);
		}
	,	complete	:	function()
		{
			alert("걍 실행");
		}
	};
	$.ajax(a);
});
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