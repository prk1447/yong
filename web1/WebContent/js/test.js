/**
 * 
 */

function checkValue(fObj)
{
	
	var resultStr = "";
	for(var i = 0; i < fObj.elements.length; i++)
	{
		var eObj = fObj.elements[i];
		var result = new Number(eObj.value);
		if(i%2==1 && isNaN(result))
		{
			alert(i + "번째에 정수만 입력해 주세요");
			eObj.focus();
			return false;
		}
		if(eObj.value != "전송")
		{
			resultStr += eObj.value;
		}
		if(i == fObj.elements.length - 1)
		{
			eObj.value = resultStr;
		}
	}
	return false;
}
