// JavaScript Document

function login(){
	//ajax提交  
	var account = $("#account").val();
	var password = $("#password").val();
	var identity = $("#identity").val();
	$.ajax( {  
	        url: 'http://265905b8a5.wicp.vip/health/user',
            data: {'account':account,'password':password,'identity':identity},
            type: 'post',
            cache: false,
            dataType: "JSON",
		    success: function(data) {
			    jsonData = JSON.stringify(data);// 转成JSON格式
				alert(data.msg);
				if(data.msg=="登录成功")
				{
					window.location.href="view/frame/main.html";
				}
				else
				{
					window.location.href="index.html";
				}
		    },
		    error: function(XMLHttpRequest, textStatus, errorThrown) {
			      // 状态码
			      console.log(XMLHttpRequest.status);
			      // 状态
			      console.log(XMLHttpRequest.readyState);
			      // 错误信息
			      console.log(textStatus);
		    }
    });
	 
}
