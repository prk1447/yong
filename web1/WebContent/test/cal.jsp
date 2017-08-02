<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script src="/js/jquery-3.2.1.js"></script>
<body>
<div class="container">
<table border="1">
<tr>
<td><input type="text" id="num1" name="num1"/></td>
	<td>
	<select id="op" name="op">
		<option value="선택">선택</option>
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="*">*</option>
		<option value="/">/</option>
	</select>
	</td>
<td><input type="text" id="num2" name="num2"/></td>
<td><button type="button" id="btn2">계산하기</button></td>
<td><input type="text" id="resultnum" name="resultnum"/></td>
</tr>
<tr align="center">
	<td colspan="5">
	<input type="text" id="searchId" name="searchId"/>
	<button type="button" id="searchBtn">연산자 검색</button>
</td>
</tr>
</table>
</div>
<script>
$("#btn2").click(function()
{
	var num1 = $("#num1").val();
	var num2 = $("#num2").val();
	var op = $("#op").val();
	var param = {};
	param["num1"] = num1;
	param["num2"] = num2;
	param["op"] = op;
	param = JSON.stringify(param);
	$.ajax(
	{
		type	:	"POST"
	,	url		:	"/test/cal_ok.jsp"
	,	dataType	:	"json"
	,	beforeSend	:	function(xhr)
		{
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		}
	,	data	:	param
	,	success	:	function(result)
		{
			$("#resultnum").val(result.resultnum);
		}
	,	error	:	function(xhr, status, e)
		{
			alert("에러 : " + e);
		}
	,	done	:	function(e)
		{
			
		}
	});
});

$("#searchBtn").click(function()
{
	var searchId = $("#searchId").val();
	var param = {};
	param["searchId"] = searchId;
	param = JSON.stringify(param);
	$.ajax(
			{
				type	:	"POST"
			,	url		:	"/test/cal_select.jsp"
			,	dataType	:	"json"
			,	beforeSend	:	function(xhr)
				{
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				}
			,	data	:	param
			,	success	:	function(result)
				{
					result;
				}
			,	error	:	function(xhr, status, e)
				{
					alert("에러 : " + e);
				}
			,	done	:	function(e)
				{
					
				}
			});
});
</script>
</body>
</html>