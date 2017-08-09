<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<title>Insert title here</title>
</head>
<body>
<script>
var testParam = {};
testParam["giNum"] = "1";
testParam["giName"] = "상품";
testParam["giDesc"] = "상품설명";
testParam["viNum"] = "1";
testParam["viName"] = "회사명";
testParam["viList"] = [{str1:"1"},{str2:"2"}];
var testParam2 = {};
testParam2["giNum"] = "2";
testParam2["giName"] = "2상품";
testParam2["giDesc"] = "2상품설명";
testParam2["viNum"] = "2";
testParam2["viName"] = "2회사명";
testParam2["viList"] = [{str1:"1"},{str2:"2"}];
function callback(results)
{	
	for(var i = 0, max = results.length; i < max; i++)
	{
		var result = results[i];
		alert(result.giDesc);
	}
}
goPage([testParam,testParam2], "/test.goods", callback)
</script>
</body>
</html>