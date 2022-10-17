// JavaScript Document
// JavaScript Document

function register(){
	//ajax提交  
	var account = $("#account").val();
	var password = $("#password").val();
	var identity = $("#identity").val();
	var class_id = $("#class_id").val();
	var student_id = $("#student_id").val();
	var c = Number(class_id);
	var s = Number(student_id);
	if(!c){ // "",null,undefined,NaN
        c = 0;
    }
	if(!s){ // "",null,undefined,NaN
        s = 0;
    }
	$.ajax( {  
	        url: 'http://265905b8a5.wicp.vip/health/add/user',
            data: {'account':account,'password':password,'identity':identity,'class_id':c,'student_id':s},
            type: 'post',
            cache: false,
            dataType: "JSON",
		    success: function(data) {
			    jsonData = JSON.stringify(data);// 转成JSON格式
				if(data.msg=="成功")
				{
					alert(data.msg);
					window.location.href="../index.html";
				}
				else
				{
					window.location.href="register.html";
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
