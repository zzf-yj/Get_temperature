// JavaScript Document

$(function() {
	var html = [];
	var ID;
	var student_id;
	var class_id;
	$.ajax( {  
	        url: 'http://265905b8a5.wicp.vip/health/class/get/leaver',
            data: $('#form').serialize(),
            type: 'get',
            cache: false,
            dataType: "JSON",
		    success: function(data) {
			    jsonData = JSON.stringify(data);// 转成JSON格式
	            var data1 = eval('(' + jsonData + ')');
				
	            for(var i=0;i<data1.length;i++){
					ID = data1[i]['id'];
					student_id = data1[i]['student_id'];
	                var s = Number(student_id);
	            	html.push("<tr><th>"+data1[i]['student_name']+"</th>"); 
	            	html.push("<th>"+data1[i]['student_id']+"</th>"); 	
					html.push("<th>"+data1[i]['student_sex']+"</th>"); 	
					html.push("<th>"+data1[i]['student_temp']+"</th>"); 	
					html.push("<th>"+data1[i]['class_id']+"</th>"); 	
					html.push("<th>"+data1[i]['reason']+"</th>"); 	
					html.push("<th>"+data1[i]['date']+"</th>");
					html.push("<th>"
					          +"<button class='button button-glow button-rounded button-royal' onclick='update_y("+s+")'>同意</button>"
					          +"&nbsp;&nbsp;&nbsp;"
							  +"<button class='button button-glow button-rounded button-caution' onclick='update_n("+s+")'>拒绝</button>"
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

function update_y(student_id){
	var authorize = '同意';
	$.ajax( {  
	        url: 'http://265905b8a5.wicp.vip/health/getclass/leaver',
            data: {'student_id':student_id,'authorize':authorize},
            type: 'get',
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

function update_n(student_id){
	var authorize = '拒绝';
	$.ajax( {  
	        url: 'http://265905b8a5.wicp.vip/health/getclass/leaver',
            data: {'student_id':student_id,'authorize':authorize},
            type: 'get',
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
