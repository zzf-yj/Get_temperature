// JavaScript Document

$(function() {
	var html = [];
	var ID;
	$.ajax( {  
	        url: 'http://265905b8a5.wicp.vip/health/stu/getAll',
            data: $('#form').serialize(),
            type: 'get',
            cache: false,
            dataType: "JSON",
		    success: function(data) {
			    jsonData = JSON.stringify(data);// 转成JSON格式
	            var data1 = eval('(' + jsonData + ')');
				
	            for(var i=0;i<data1.length;i++){
					ID = data1[i]['id'];
	            	html.push("<tr><th>"+data1[i]['student_name']+"</th>"); 
	            	html.push("<th>"+data1[i]['student_id']+"</th>"); 	
					html.push("<th>"+data1[i]['student_sex']+"</th>"); 	
					html.push("<th>"+data1[i]['student_age']+"</th>"); 	
					html.push("<th>"+data1[i]['class_id']+"</th>"); 	
					html.push("<th>"+data1[i]['student_card']+"</th>"); 	
					html.push("<th>"
					          +"<button class='button button-glow button-rounded button-royal' onclick='delete_c("+ID+")'>删除</button>"
					          +"&nbsp;&nbsp;&nbsp;"
							  +"<button class='button button-glow button-rounded button-caution'><a href='student_update.html?id=" + ID + "'>修改</a></button>"
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


function delete_c(ID){
	//ajax提交  
	$.ajax( {  
	        url: 'http://265905b8a5.wicp.vip/health/delete/stu',
            data: {'id':ID},
            type: 'post',
            cache: false,
            dataType: "JSON",
		    success: function(data) {
			    jsonData = JSON.stringify(data);// 转成JSON格式
				alert(data.msg);
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

