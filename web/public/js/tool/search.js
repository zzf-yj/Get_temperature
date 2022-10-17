// JavaScript Document

function search(){
	//ajax提交  
	var options=$("#column option:selected");
	var value = options.val();
	var getdata = $("#updata").val();
	var html = [];
	var data;
	var url;
	if(value=='0')
	{
		url='http://265905b8a5.wicp.vip/health/getclass';
		var d = Number(getdata);
		console.log(d);
		data = {'class_id':d};
	}
	else if(value=='1')
	{
		url='http://265905b8a5.wicp.vip/health/getclass/getone';
		var d = Number(getdata);
		data = {'student_id':d};
	}
	else if(value=='2')
	{
		url='http://265905b8a5.wicp.vip/health/getclass/getSex';
		data = {'student_sex':getdata};
	}
	$.ajax( {  
	        url: url,
            data: data,
            type: 'post',
            cache: false,
            dataType: "JSON",
		    success: function(data) {
			    jsonData = JSON.stringify(data);// 转成JSON格式
	            var data1 = eval('(' + jsonData + ')');
	            for(var i=0;i<data1.length;i++){
	            	html.push("<tr><th>"+data1[i]['student_name']+"</th>"); 
	            	html.push("<th>"+data1[i]['student_id']+"</th>"); 	 	
					html.push("<th>"+data1[i]['student_sex']+"</th>"); 	
					html.push("<th>"+data1[i]['class_id']+"</th>"); 	
					html.push("<th>"+data1[i]['student_temp']+"</th>"); 	
					html.push("<th>"+data1[i]['student_data']+"</th></tr>");
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
	 
}
