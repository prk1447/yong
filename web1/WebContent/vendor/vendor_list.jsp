<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<div class="container">
	<div class="container" style="text-align: center; padding-top: 20px;padding-bottom: 20px;"> 
		<label>회사이름 : </label> <input type="text" id="giName" /> 
		<input type="button" id="searchGoods" value="검색" />
	</div>
	<table id="table" data-height="460"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th data-field="viNum" class="text-center">회사번호</th>
				<th data-field="viName" class="text-center">회사이름</th>
				<th data-field="viDesc" class="text-center">회사설명</th>
				<th data-field="viAddress" class="text-center">회사주소</th>
				<th data-field="viPhone" class="text-center">회사전화번호</th>
			</tr>
		</thead>
		<tbody id="result_tbody">
		</tbody>
	</table>
	<button id="btnInsert" class="btn btn-primary"  type="button">상품등록</button>
</div>
<div class="jb-center" style="text-align: center">
	<ul class="pagination" id="page">
	</ul>
</div>
<script>
$("#btnInsert").click(function()
{
	location.href="/goods/goods_insert.jsp";	
})

$("#searchGoods").click(function()
{
	var viName = $("#viName").val().trim();
	if(viName == "")
	{
		alert("회사 선택이나 제품명을 입력해주세요");
		return;
	}
	var params = {};
	params["command"] = "list";
	params["viName"] = viName;
	movePageWithAjax(params, "/list.goods", callback);
})

function callback(results)
{
	var goodsList = results.list;
	pageInfo = results.page;
	var vendorList = results.vendor;
	var search = results.search;
	var selStr = "<option value=''>회사선택</option>";
	for(var i = 0, max = vendorList.length; i < max; i++)
	{
		var vendor = vendorList[i];
		var selectStr = "";
		if(search.viNum == vendor.viNum)
		{
			selectStr = "selected";
		}
		selStr += "<option value='" + vendor.viNum + "'" + selectStr + ">" + vendor.viName	+ "</option>";
	}
	$("#v_vendor").html(selStr);
	var params = {};
	if(search.viNum != 0)
	{
		params["viNum"] = search.viNum;
	}
	if(search.giName)
	{
		params["giName"] = search.giName;
	}
	makePagination(pageInfo,"page");
	setEvent(pageInfo,params , "/list.goods");
	$('#table').bootstrapTable('destroy');
	var resultStr = "";
	for(var i=0, max=goodsList.length;i<max;i++)
	{
		var goods = goodsList[i];
		resultStr += "<tr data-view='" + goods.giNum + "'>";
		resultStr +="<td class='text-center'>" + goods.giNum + "</td>";
		resultStr +="<td class='text-center'>" + goods.giName + "</td>";
		resultStr +="<td class='text-center'>" + goods.giDesc + "</td>";
		resultStr +="<td class='text-center'>" + goods.viNum + "</td>";
		resultStr +="<td class='text-center'>" + goods.viName + "</td>";
		resultStr +="</tr>";
	}
	$('#result_tbody').html(resultStr);
	$("tbody[id='result_tbody']>tr[data-view]").click(function()
	{
		var params = {};
		params["giNum"] = this.getAttribute("data-view");
		params["command"] = "view";
		var page = {};
		page["nowPage"] = pageInfo.nowPage;
		params["page"] = page;
		movePageWithAjax(params, "/list.goods", callBackView);
	});
}
</script>
</body>
</html>