function showProductMessageByCategory(){
	var url="index.do?categoryId="+document.getElementById("selectID").options[document.getElementById("selectID").selectedIndex].value+"&categoryText="+document.getElementById("selectID").options[document.getElementById("selectID").selectedIndex].text;
	//window.open(url);
	window.location = url;
	
}

/**自动将页面滚动到指定位置*/
function scrol(){
    //window.location.hash = "#title";
	var scroll_y = parseInt(1000);
	window.scrollBy(0, scroll_y);
}

/**根据关键字查询商品*/
function searchProduct(){
	if(document.keywordform.keyword.value == "请输入您所要查找的商品名称")  {  
		alert("请输入关键字!");
		document.keywordform.keyword.focus();
		return  false;
	}
	return true;
}

/**登陆表单验证*/
function  CheckLoginForm()
{  
	
	if  (document.loginForm.username.value.length  ==  0)  {  
		alert("请输入用户名!");
		document.loginForm.username.focus();
		return  false;
	}
	
	if  (document.loginForm.password.value.length  ==  0)  {  
		alert("请输入密码!");
		document.loginForm.password.focus();
		return  false;
	}
	
		return  true;
}
/**登陆表单验证*/
function  CheckLoginForm1()
{  
	
	if  (document.loginForm1.username.value.length  ==  0)  {  
		alert("请输入用户名!");
		document.loginForm1.username.focus();
		return  false;
	}
	
	if  (document.loginForm1.password.value.length  ==  0)  {  
		alert("请输入密码!");
		document.loginForm1.password.focus();
		return  false;
	}
	
		return  true;
}
/**查询关键字*/
function checkKeyword(){
	if(document.keywordform.keyword.value =="请输入您所要查找的商品名称"){
		alert("请输入关键字!");
		document.keywordform.keyword.focus();
		return  false;
	}
}



