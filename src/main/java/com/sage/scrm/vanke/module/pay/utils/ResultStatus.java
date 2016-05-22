package com.sage.scrm.vanke.module.pay.utils;



public class ResultStatus {

	public static final ResultStatus SUCCESS = new ResultStatus("200", "操作成功"); // 操作成功
	public static final ResultStatus SYSTEM_ERROR = new ResultStatus("500", "系统异常"); // 系统错误
	public static final ResultStatus WECHAT_ERROR = new ResultStatus("300", "微信参数Ticket获取不到"); // 系统错误
	public static final ResultStatus COMMON_PARAMS_ERROR = new ResultStatus("400", "参数有误");//参数有误
	public static final ResultStatus TEXT_MESSAGE_ERROR = new ResultStatus("700", "短信发送异常");//短信发送异常

	
	// 会员相关错误 以6001开头
	public static final ResultStatus MEMBER_PHONE_EXIST_ERROR = new ResultStatus("6001001", "注册手机已经存在");
	public static final ResultStatus MEMBER_ACCOUNT_NULL_ERROR = new ResultStatus("6001002", "注册会员OPENID为空");
	public static final ResultStatus MEMBER_ACCOUNT_NOTEXIST_ERROR = new ResultStatus("6001003", "注册会员账号不存在");
	public static final ResultStatus MEMBER_PHONE_NULL_ERROR = new ResultStatus("6001004", "注册手机号为空");
	public static final ResultStatus MEMBER_NOT_EXIST_ERROR = new ResultStatus("6001005", "会员不存在");
	public static final ResultStatus MEMBER_NOT_ACTIVE_ERROR = new ResultStatus("6001006", "会员未激活");
	public static final ResultStatus MEMBER_ACTIVE_ERROR = new ResultStatus("6001007", "您已注册，请不要重复注册");
	public static final ResultStatus MOBILE_NOT_MEMBER_ERROR = new ResultStatus("6001008", "手机号未注册");
	public static final ResultStatus MOBILE_IS_MEMBER_ERROR = new ResultStatus("6001009", "手机号已注册");
	
	public static final ResultStatus MOBILE_BINDING_ACCOUNT_EXIST_ERROR = new ResultStatus("6001010", "会员已存在该类型的账号");
	// 会员账号信息错误 以6002开头

	// 会员积分信息错误 以6003开头
	public static final ResultStatus MEMBER_POINTS_NOT_ENOUGH = new ResultStatus("6003001", "余额不足");

	// 会员等级信息错误以6007开头
	public static final ResultStatus GRADE_NULL_ERROR = new ResultStatus("6007001","该会员没有等级记录");
	// 优惠券相关错误 以6004开头
	public static final ResultStatus COUPONINSTANCE_CODE_NULL_ERROR = new ResultStatus("6004001","优惠券码不存在");
	public static final ResultStatus COUPONINSTANCE_NULL_ERROR = new ResultStatus("6004002", "优惠券不存在");
	
	public static final ResultStatus COUPON_INSTANCE_STATUS_USED_ERROR = new ResultStatus("6004003", "优惠券已使用，不可使用");
	public static final ResultStatus COUPON_INSTANCE_STATUS_DESTROY_ERROR = new ResultStatus("6004004", "优惠券已作废，不可使用");
	public static final ResultStatus COUPON_INSTANCE_STATUS_EXPIRE_ERROR = new ResultStatus("6004005", "优惠券已过期，不可使用");
	public static final ResultStatus COUPON_INSTANCE_STATUS_FREEZE_ERROR = new ResultStatus("6004006", "优惠券已冻结，不可使用");
	public static final ResultStatus COUPON_INSTANCE_STORE_ERROR = new ResultStatus("6004007", "门店编号不能为空");
	public static final ResultStatus COUPON_INSTANCE_NOT_BEGIN_DATE = new ResultStatus("6004008", "优惠券未到开始使用时间，不可使用");
	
	public static final ResultStatus COUPON_CODE_NULL_ERROR = new ResultStatus("6004006","优惠券不存在");
	public static final ResultStatus COUPON_NOT_AVALIABLE = new ResultStatus("6004007", "优惠券已过期");
	public static final ResultStatus COUPON_NOT_ENOUGH = new ResultStatus("6004008", "优惠券可用数量不够");
	public static final ResultStatus COUPON_STORE_ERROR = new ResultStatus("6004009", "优惠券在该门店不可用");
	public static final ResultStatus COUPON_ORG_NULL_ERROR = new ResultStatus("6004010", "优惠券门店不存在");
	public static final ResultStatus COUPON_INSTANCE_STATUS_RECEIVE_ERROR = new ResultStatus("6004011", "优惠券已领取，不可再次领取");
	public static final ResultStatus COUPON_INSTANCE_USE_ERROR = new ResultStatus("6004012", "优惠券不能同享，一次只能使用一个");
	
	public static final ResultStatus COUPON_INSTANCE_REVERSE_CREATE_ERROR = new ResultStatus("6004013", "优惠券状态已创建,不需要反核销");
	public static final ResultStatus COUPON_INSTANCE_REVERSE_UNUSED_ERROR = new ResultStatus("6004014", "优惠券状态未使用,不需要反核销");
	
	public static final ResultStatus COUPONINSTANCE_INVALID = new ResultStatus("6004015", "优惠券非法操作");
	// 会员卡信息错误 以6005开头
	public static final ResultStatus MEMBER_CARD_NOT_EXIST = new ResultStatus("6005000", "会员卡不存在");
	public static final ResultStatus MEMBER_CARD_STATUS_ERROR = new ResultStatus("6005001", "会员卡状态有误不可用");
	
	
	// 订单相关错误 以6006开头
	public static final ResultStatus ORDER_EXIST_ERROR = new ResultStatus("6006001", "订单不存在");
	public static final ResultStatus ORDER_GENERATE_CODE_ERROR = new ResultStatus("600201", "生成订单编码有误");
	public static final ResultStatus ORDER_SYNC_ERROR = new ResultStatus("600202", "订单同步有误");
	public static final ResultStatus ORDER_CODE_EXIST_ERROR = new ResultStatus("600203", "订单编码已经存在");
	public static final ResultStatus ORDER_NO_EXIST_ERROR = new ResultStatus("600204", "订单不存在");
	public static final ResultStatus ORDER_OPT_ERROR = new ResultStatus("600205", "订单操作标示有误");
	public static final ResultStatus ORDER_SYNC_FILE_EMPTY_ERROR = new ResultStatus("600206", "附件为空");
	public static final ResultStatus ORDER_SYNC_FILE_TYPE_ERROR = new ResultStatus("600207", "请上传正确格式的附件");
	public static final ResultStatus ORDER_SYNC_PARSE_ERROR = new ResultStatus("600208", "订单离线上传解析失败");
	public static final ResultStatus ORDER_SYNC_INFO_ERROR = new ResultStatus("600209", "订单信息错误");
	public static final ResultStatus ORDER_SYNC_FILE_MESSING_ERROR = new ResultStatus("600210", "订单操作标示有误");
	public static final ResultStatus ORDER_SYNC_CODE_NOT_MATCH_ERROR = new ResultStatus("600211", "编码文件和订单文件不一致");
	public static final ResultStatus ORDER_SYNC_FILE_IN_UPLOAD_ERROR = new ResultStatus("600212", "订单文件已上传, 不能重复上传订单");
	public static final ResultStatus PAYMENT_TYPE_SYNC_ERROR = new ResultStatus("600213", "支付方式类型同步失败");
	public static final ResultStatus PAYMENT_METHOD_SYNC_ERROR = new ResultStatus("600214", "支付方式同步失败");
	
	
	//验证码相关错误 以6007开头
	public static final ResultStatus COMV_MISMATCH_ERROR = new ResultStatus("6007001", "验证码和手机号不匹配");
	public static final ResultStatus COMV_OVERDUE_ERROR = new ResultStatus("6007002", "验证码已过期");
	public static final ResultStatus TEXT_NUM_ERROR = new ResultStatus("6007003", "已达每日发送上限(3条)");
	
	//抽奖相关错误 6008开头
	public static final ResultStatus NO_QUALIFICATION = new ResultStatus("6008001", "抽奖次数用完");

	public static final ResultStatus ACTIVITY_END = new ResultStatus("6008002", "活动已结束");
	private String code;
	private String msg;

	public ResultStatus(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
