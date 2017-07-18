/**
 * 
 */
var AjaxUtil = function(url, allParams, method, aSync)
{
	this.fAction = url;
	this.fMethod = method ? mtehod : "get";
	var params = "?action=LOGIN&id=" + encodeURIComponent(userid);
	this.fAsync = aSync ? aSync : true;
	xmlHttpObj.onreadystatechange = function()
	{
		if(xmlHttpObj.readyState == 4 && xmlHttpObj.status == 200)
		{
			var result = docodeURIComponent(xmlHttpObj.responseText);
			if(result == "success")
			{
				location.href = "../user/welcome.jsp";
			}
			else
			{
				alert(result);
			}
		}
	}
	xmlHttpObj.open(method, url + params, sync);
	if(method == "post")
	{
		xmlHttpObj.setRequesHeader("Content-type", "application/x-www-form-urlencoded");
	}
	xmlHttpObj.send(params);
}