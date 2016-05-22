$(document).ready(function(){
	var initActivityId ="";
	// 每人支付的金额
	var activityMoney ="";
	// 支付总额
	var totalAmount ="";
	var activityArray =new Array();
	var pathName=window.document.location.pathname;
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	$.baseUrl = projectName;//初始化项目根路径
	//初始化万科活动列表
	initWankeActivity();
	
	$("#activityList").change(function(){
		var activityId = $(this).attr("value");
		applyCountByActivity(activityId);
		getFeeByActivityId(activityId);
	});
	
	$("#applyAcount").change(function(){
		var applyCount = $(this).attr("value");
		totalAmount = parseInt(applyCount)*parseInt(activityMoney);
		$("#payAmount").val(totalAmount);
	});
	
	// 初始化方法
	function initWankeActivity(){
		$.ajax({
			type : "post",
			url : $.baseUrl+'/actitypayconfigController/queryByStatus.do',
			dataType : "json",
			success : function(result) {
				if(result.code == 200){
					list =result.list;
					activityArray =list;
					var appendOptions ="";
					var applyOptions ="";
					initActivityId =list[0].activityid;// 初始化活动id
					activityMoney = list[0].activitymoney;// 活动支付金额
					for(var i=0;i<list.length;i++){
						var activityId =list[i].activityid;
						var activityName =list[i].activityname;
						appendOptions +="<option value="+activityId+">"+activityName+"</option>";
					}
					$("#activityList").append(appendOptions);
					$("#activityList").jSelect();
					
					// 初始化报名人数
					applyCountByActivity(initActivityId);
				}
			},
			error : function() {
				parent.layer.alert("出错了:(");
			}
		});
	}
	
	// 根据活动id查询活动费用
	function getFeeByActivityId(activityId){
		for(var i=0;i<activityArray.length;i++){
			var id = activityArray[i].activityid; 
			if(activityId==id){
				activityMoney =activityArray[i].activitymoney;
				break;
			}
		}
		return activityMoney;
	}
	
	// 根据活动id查询报名人数
	function applyCountByActivity(activityId){
		var initApplyCount ="";
		var applyOptions ="";
		for(var i=0;i<activityArray.length;i++){
			var id = activityArray[i].activityid; 
			if(activityId==id){
				initApplyCount =activityArray[i].personlimit;
				break;
			}
		}
		for(var j=0;j<initApplyCount;j++){
			var applyId =j+1;
			var applyName =j+1;
			applyOptions +="<option value="+applyId+">"+applyName+"</option>";
		}
		$("#applyAcount").append(applyOptions);
		$("#applyAcount").jSelect();
	};
	
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
	
	$(".btn").click(function(){
		// 调微支付接口
		/*layer.open({
			  content: '测试回调'
			  ,btn: ['确认', '取消']
			  ,yes: function(index, layero){
			    alert("点了确定");
			    layer.close(index);
			  },btn2: function(index, layero){
				  alert("点了取消");
			  },cancel: function(){ 
			   
			  }
		 });*/
	});
});