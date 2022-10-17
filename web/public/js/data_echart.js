// JavaScript Document
$(function(){
	 var graduatenum = echarts.init(document.getElementById('main'));

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
		var data_date = [];
		var data_diagnose = [];

		$.ajax({
			 url:"http://265905b8a5.wicp.vip/health/getclass/Temp"
			 ,data: $('#form').serialize()
			 ,type:'post'
		     ,cache:false
			 ,dataType: "JSON"
		     ,success:function (data){  
		       	    jsonData = JSON.stringify(data);// 转成JSON格式
		            var data1 = eval('(' + jsonData + ')');
		            for(var i=0;i<data1.length;i++){
		            	data_date.push(data1[i]['student_name']); 
		            	data_diagnose.push(data1[i]['student_temp']); 	
		            }
		            graduatenum.hideLoading();    //隐藏加载动画
		            graduatenum.setOption({        //加载数据图表
		                xAxis: {
		                    data: data_date
		                },
		                series: [{
		                  data: data_diagnose
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
});