<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<body>
<p>get parameter방식</p>
<form action="test.formtest" method="get">
아이디 : <input type="text" name="id"/><br/>
비밀번호 : <input type="text" name="pwd"><br/>
<input type="submit" value="전송"/>
</form>

<p>POST JSON방식</p>
<form action="test.formtest" method="post">
아이디 : <input type="text" id="id" name="id"/><br/>
비밀번호 : <input type="text" id="pwd" name="pwd"><br/>
<input type="button" value="전송" onclick="clickBtn()"/>
</form>
<script>
function clickBtn()
{
	var params = {};
	params["id"] = $("#id").val();
	params["pwd"] = $("#pwd").val();
	params = JSON.stringify(params);
	$.ajax(
	{
		type     : "POST"
    ,   url      : "/test.formtest"
    ,   dataType : "json" 
    ,   beforeSend	: function(xhr)
    	{
    		xhr.setRequestHeader("Accept", "application/json");
    	   	xhr.setRequestHeader("Content-Type", "application/json");
    	}
    ,   data     : params
    ,   success : function(result)
    	{
    		alert(result.id);
    		alert(result.pwd);
    	}
   	,   error : function(xhr, status, e)
   		{
    		alert("에러 : " + e);
    	}
   	,
    	done : function(e) 
    	{
    	}
    });
}
</script>
</body>
</html>