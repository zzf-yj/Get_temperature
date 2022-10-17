// JavaScript Document

$(function() {
	var html = [];
	var ID;
	$.ajax( {  
	        url: 'http://265905b8a5.wicp.vip/health/class/getAll',
            data: $('#form').serialize(),
            type: 'get',
            cache: false,
            dataType: "JSON",
		    success: function(data) {
			    jsonData = JSON.stringify(data);// 转成JSON格式
	            var data1 = eval('(' + jsonData + ')');
	            for(var i=0;i<data1.length;i++){
					ID = data1[i]['id'];
	            	html.push("<tr><th>"+data1[i]['class_id']+"</th>"); 
	            	html.push("<th>"+data1[i]['class_name']+"</th>"); 	
					html.push("<th>"+data1[i]['class_num']+"</th>"); 	
					html.push("<th>"+data1[i]['teacher_id']+"</th>"); 		
					html.push("<th>"
					          +"<button class='button button-glow button-rounded button-royal' onclick='delete_c("+ID+")'>删除</button>"
					          +"&nbsp;&nbsp;&nbsp;"
							  +"<button class='button button-glow button-rounded button-caution'><a href='class_update.html?id=" + ID + "'>修改</a></button>"
							  +"</th></tr>");
				    
	            }
				$("#table").append(html.join(""))
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
})
// JavaScript Document

function delete_c(ID){
	//ajax提交  
	$.ajax( {  
	        url: 'http://265905b8a5.wicp.vip/health/delete/class',
            data: {'id':ID},
            type: 'post',
            cache: false,
            dataType: "JSON",
		    success: function(data) {
			    jsonData = JSON.stringify(data);// 转成JSON格式
				alert(data.msg);
				window.location.href="class.html";
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

	