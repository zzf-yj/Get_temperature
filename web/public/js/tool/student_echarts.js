// JavaScript Document
$(function(){
	
    var worldcount = echarts.init(document.getElementById('main'));
	worldcount.setOption({
		    title: {
		        text: '班级学生体温',
		        subtext: '数据来自网络',
		        textStyle:{
					color:'#000',
					fontSize:16,
					fontWeight:'normal',
				},
		    },
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {
		            type: 'shadow'
		        }
		    },
		    dataZoom: [
		               
		               {
		                   type: 'slider',
		                   yAxisIndex: 0,
		                   filterMode: 'empty'
		               },
		               
		               {
		                   type: 'inside',
		                   yAxisIndex: 0,
		                   filterMode: 'empty'
		               }
		    ],
		    legend: {
		        data: ['确诊'],
		        textStyle:{
	               color:"#000",
	               fontSize:'13'
	            },
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis: {
		        type: 'value',
		        boundaryGap: [0, 0.01],
		        splitLine:{
	                show:true,
	                lineStyle:{
	                    color: '#000'
	                }
	            },
		        axisLabel:{
		        	textStyle:{
	                    color:"#000"
	                },
	                alignWithLabel: false,
	            }
		    },
		    yAxis: {
		        type: 'category',
		        data: [],
		        splitLine:{
	                show:false,
	                lineStyle:{
	                    color: '#459895'
	                }
	            },
	            axisLabel:{
		        	textStyle:{
	                    color:"#000"
	                },
	            }
		    },
		    series: [
		        {
		            name: '确诊',
		            type: 'bar',
		            data: []
		        },
		    ]
	    });
	    worldcount.showLoading();
	    
		var a=GetRequest();
        var id = a['id'];
		var i = Number(id);
		console.log(id);
		var student_name = [];
		var student_temp = [];
		$.ajax({
		   	    url:"http://265905b8a5.wicp.vip/health/getclass"
		   	    ,data: {'class_id':i}
		   	    ,type:'post'
		        ,cache:false
		   	    ,dataType: "JSON"
		        ,success:function (data){  
		          	    jsonData = JSON.stringify(data);// 转成JSON格式
		                var data1 = eval('(' + jsonData + ')');
		          	    for(var i=0;i<data1.length;i++){
		          	    	student_name.push(data1[i]['student_name']); 
		             	    student_temp.push(data1[i]['student_temp'])
		              }
		          	  worldcount.hideLoading();    //隐藏加载动画
		          	  worldcount.setOption({       //加载数据图表
		               	yAxis: {
		                       data: student_name
		                   },
		               	series: [
		      	                  {
		      	                    // 根据名字对应到相应的系列
		      	                    name: '体温',
		      	                    data: student_temp,
		      	                   },
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
})