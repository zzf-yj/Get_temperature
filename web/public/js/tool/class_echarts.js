// JavaScript Document
// JavaScript Document
var class_id = []
$(function(){
	
	var class_name = [];
    var class_num = [];
	
	$.ajax({
			 url:"http://265905b8a5.wicp.vip/health/class/getAll"
			 ,data: $('#form').serialize()
			 ,type:'get'
		     ,cache:false
			 ,dataType: "JSON"
		     ,success:function (data){  
		       	    jsonData = JSON.stringify(data);// 转成JSON格式
		            var data1 = eval('(' + jsonData + ')');
		            for(var i=0;i<data1.length;i++){
		            	class_name.push(data1[i]['class_name']); 
		            	class_num.push(data1[i]['class_num']);
						class_id.push(data1[i]['class_id']);
		            }
					getclass(class_name,class_num);
		    },
		    error: function (XMLHttpRequest, textStatus, errorThrown) {
		        // 状态码
		        console.log(XMLHttpRequest.status);
		        // 状态
		        console.log(XMLHttpRequest.readyState);
		        // 错误信息   
		        console.log(textStatus);
		    }
		});
	
	
});

function getclass(class_name,class_num){
    
	for(var i=1;i<3;i++)
	{
		document.getElementById("b"+i).innerHTML = class_name[i-1];
		document.getElementById("num"+i).innerHTML = class_num[i-1];
	    graduatenum  = echarts.init(document.getElementById('e1'));

		graduatenum.setOption({
			title: {
		        text: '全校学生体温前十',
		        subtext: '数据真实来源',
		        textStyle:{
					color:'#000',
					fontSize:16,
					fontWeight:'normal',
				},
		    },
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
		            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
			 xAxis: {
			        type: 'category',
			        data: [],
			        axisLabel:{
		                formatter: function (value) {
		                  //x轴的文字改为竖版显示
		                  var str = value.split("");
		                  return str.join("\n");
		                }
		            }, 
			    },
			 yAxis: {
			        type: 'value'
			 },
			 series: [{
			        data: [],
			        type: 'bar',
			        showBackground: true,
			        backgroundStyle: {
			            color: 'rgba(220, 220, 220, 0.8)'
			        }
			 }]
		});
		graduatenum.showLoading();
		var student_name = [];
		var student_temp= [];
		var ovar_1=[];
		var class_id='2017101';
	
	} 
	$.ajax({
			 url:"http://265905b8a5.wicp.vip/health/getclass/Five"
			 ,data: {'class_id':class_id}
			 ,type:'post'
		     ,cache:false
			 ,dataType: "JSON"
		     ,success:function (data){  
		       	    jsonData = JSON.stringify(data);// 转成JSON格式
		            var data1 = eval('(' + jsonData + ')');
		            for(var i=0;i<data1.length;i++){
		            	student_name.push(data1[i]['student_name']); 
		            	student_temp.push(data1[i]['student_temp']); 	
		            }
		            graduatenum.hideLoading();   //隐藏加载动画
		            graduatenum.setOption({        //加载数据图表
		                xAxis: {
		                    data: student_name
		                },
		                series: [{
		                    data: student_temp
		                 }
		                ]
		            });
		    },
		    error: function (XMLHttpRequest, textStatus, errorThrown) {
		        // 状态码
		        console.log(XMLHttpRequest.status);
		        // 状态
		        console.log(XMLHttpRequest.readyState);
		        // 错误信息   
		        console.log(textStatus);
		    }
		});
		
}
function charge(){
	
	 var id = class_id[0];
     window.location.href="../student/student_echars.html?id="+id+"";
}
