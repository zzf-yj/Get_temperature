// JavaScript Document
// JavaScript Document
function student(){
	//ajax提交  
	var student_card = $("#student_card").val();
	var class_id = $("#class_id").val();
	var student_id = $("#student_id").val();
	var student_name = $("#student_name").val();
	var student_sex = $("#student_sex").val();
	var student_age = $("#student_age").val();
	var c = Number(class_id);
	var s = Number(student_id);
	var age = Number(student_age);
	console.log(student_card);
	console.log(class_id);
	console.log(student_id);
	console.log(student_name);
	console.log(student_sex);
	console.log(student_age);
	
	$.ajax( {  
	        url: 'http://265905b8a5.wicp.vip/health/add/stu',
            data: {'student_card':student_card,'class_id':c,'student_id':s,'student_name':student_name,
			       'student_sex':student_sex,'student_age':age},
            type: 'post',
            cache: false,
            dataType: "JSON",
		    success: function(data) {
			    jsonData = JSON.stringify(data);// 转成JSON格式
				alert(data.msg);
				window.location.href="student.html";
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

function teacher(){
	//ajax提交  
	var teacher_name = $("#teacher_name").val();
	var class_id = $("#class_id").val();
	var teacher_id = $("#teacher_id").val();
	var teacher_sex = $("#teacher_sex").val();
	var teacher_age = $("#teacher_age").val();
	var teacher_position = $("#teacher_position").val();
	var c = Number(class_id);
	var t = Number(teacher_id);
	var age = Number(teacher_age);
	console.log(class_id);
	console.log(teacher_id);
	console.log(teacher_name);
	console.log(teacher_sex);
	console.log(teacher_age);
	console.log(teacher_position);
	
	$.ajax( {  
	        url: 'http://265905b8a5.wicp.vip/health/add/teacher',
            data: {'teacher_name':teacher,'class_id':c,'teacher_id':t,'teacher_name':teacher_name,
			       'teacher_sex':teacher_sex,'teacher_age':age,'teacher_position':teacher_position},
            type: 'post',
            cache: false,
            dataType: "JSON",
		    success: function(data) {
			    jsonData = JSON.stringify(data);// 转成JSON格式
				alert(data.msg);
				window.location.href="teacher.html";
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

function update_class(){
	//ajax提交  
	var class_id = $("#class_id").val();
	var teacher_id = $("#teacher_id").val();
	var class_name = $("#class_name").val();
	var class_num = $("#class_num").val();
	var c = Number(class_id);
	var s = Number(teacher_id);
	var n = Number(class_num);
	console.log(class_id);
	console.log(teacher_id);
	console.log(class_name);
	console.log(class_num);
	
	$.ajax( {  
	        url: 'http://265905b8a5.wicp.vip/health/add/class',
            data: {'class_id':c,'teacher_id':s,'class_name':class_name,'class_num':n},
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
