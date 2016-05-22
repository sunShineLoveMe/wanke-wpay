$(document).ready(function(){
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	$.baseUrl = projectName;//初始化项目根路径
	//初始化万科活动列表
	initWankeActivity();
	
	function initWankeActivity(){
		$.ajax({
			type : "post",
			url : $.baseUrl+'/actitypayconfigController/queryByStatus.do',
			dataType : "json",
			success : function(result) {
				if(result.code == 200){
					// sdsd
					list =result.list;
					/*var appendHtml ="";*/
					var appendOptions ="";
					for(var i=0;i<list.length;i++){
						var activityId =list[i].activityid;
						var activityName =list[i].activityname;
						appendOptions +="<option value="+activityId+">"+activityName+"</option>";
						/*appendHtml.append(appendOptions);*/
					}
					$(".jselect").append(appendOptions);
				}
			},
			error : function() {
				parent.layer.alert("出错了:(");
			}
		});
	}
	
	$("#activityList").change(function(){
		
	});
	
	if(typeof WeixinJSBridge == "undefined"){
		  if( document.addEventListener ){
		       document.addEventListener('WeixinJSBridgeReady', jsApiCall, false);
		   }else if (document.attachEvent){
		       document.attachEvent('WeixinJSBridgeReady', jsApiCall); 
		       document.attachEvent('onWeixinJSBridgeReady', jsApiCall);
		   }
	}
	if (typeof WeixinJSBridge == "undefined"){
		   if( document.addEventListener ){
		       document.addEventListener('WeixinJSBridgeReady', jsApiCall, false);
		   }else if (document.attachEvent){
		       document.attachEvent('WeixinJSBridgeReady', jsApiCall); 
		       document.attachEvent('onWeixinJSBridgeReady', jsApiCall);
		   }
	}else{
			jsApiCall();
	}
	
	function jsApiCall() {
	    WeixinJSBridge.invoke(
	        'getBrandWCPayRequest', {
	            "appId" : "${info.appid}",    //公众号名称，由商户传入
	            "nonceStr" : "${info.nonceStr}", //随机串
	            "package" : "${info.packages}",
	            "paySign" : "${info.paySign}", //微信签名
	            "signType" : "${info.signType}" ,        //微信签名方式:
	            "timeStamp":"${info.timeStamp}"          //时间戳，自 1970 年以来的秒数
	        },  function(res){
	            WeixinJSBridge.log(res.err_msg);
	            if(res.err_msg == "get_brand_wcpay_request:ok" ) {
	                window.location.href="";
	            }else{
	                window.history.go(-1)
	            }
	        }
	    );
	}
	
	$(".jselect").jSelect();
	$(".btn").click(function(){
		layer.open({
			  content: '测试回调'
			  ,btn: ['确认', '取消']
			  ,yes: function(index, layero){
			    alert("点了确定");
			    layer.close(index);
			  },btn2: function(index, layero){
				  alert("点了取消");
			  },cancel: function(){ 
			   
			  }
		 });
	});
});