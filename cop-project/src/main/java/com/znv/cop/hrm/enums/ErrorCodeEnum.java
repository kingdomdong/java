
package com.znv.cop.hrm.enums;

/**
 * 错误码定义-枚举类
 * 
 * @author xubin
 *
 */
public enum ErrorCodeEnum {

	SUCCESS("0000", "成功")
	// 1***--自定义异常-接收参数异常
	, ACCEPT_PARAM_EXCEPTION("1001", "接收参数异常")
	// 1***--自定义异常-系统异常
	, SESSION_TIME_OUT("1002", "SESSION 超期")
	, RESPONSE_TIME_OUT("1003", "响应超时")
	, UNDIFINITION("1004", "系统内部异常")
	, FUTURE_WAIT_ERROR("1005", "future多线程等待失败")
	, UNKONW_ERROR("1006", "系统未知错误")
	, PARAM_ILLEGAL("1007", "请求入参不合法")
	, PARAM_NULL("1008", "调用方法入参空指针")
	, CONNECT_TIME_OUT("1009","请求URL超时异常")
	, NO_CONNECT("1010","请求URL无法连接")
	, ILLEGAL_ARGUMENT_EXCEPTION("1011","非法参数异常")
	, CREATE_CLEAN_FAIL("1012","创建和消除告警失败")
	, UNKNOW_EXCEPTION("1999","系统未知异常")
	
	// 2***--运行时异常和非运行时异常
	, ARITHMETIC_EXECPTION("2001", "算术异常类")
	, NULLPOINTER_EXCEPTION("2002","空指针异常类")
	, CLASS_CAST_EXCEPTION("2003", "类型强制转换异常")
	, NEGATIVE_ARRAY_EXCEPTION("2004", "数组负下标异常")
	, ARRAY_INDEXOUTOF_EXCEPTION("2005", "数组下标越界异常")
	, SECTURITY_EXCEPTION("2006", "违背安全原则异常")
	, EOF_EXCEPTION("2007", "文件已结束异常")
	, FILE_NOT_FOUND_EXCEPTION("2008", "文件未找到异常")
	, NUMBER_FORMAT_EXCEPTION("2009", "字符串转换为数字异常")
	, SQL_EXCEPTION("2010", "操作数据库异常")
	, IO_EXCEPTION("2011", "输入输出异常")
	, ABSTRACT_METHOD_ERROR("2012", "抽象方法错误")
	, ASSERTION_ERROR("2013", "断言错")
	, CLASS_CIRCULARITY_ERROR("2014", "类循环依赖错误")
	, CLASS_FORMAT_ERROR("2015", "类格式错误")
	, EXCEPTION_ININITIALIZER_ERROR("2016", "初始化程序错误")
	, ILLEGAL_ACCESS_ERROR("2017", "违法访问错误")
	, INCOMPATIBLE_CLASS_CHANGE_ERROR("2018", "不兼容的类变化错误")
	, INSTANTIATION_ERROR("2019", "实例化错误")
	, INTERNAL_ERROR("2020", "内部错误")
	, LINKAGE_ERROR("2021", "链接错误")
	, NO_CLASS_DEFFOUND_ERROR("2022", "未找到类定义错误")
	, NO_SUCH_FIELD_ERROR("2023", "域不存在错误")
	, NO_SUCH_METHOD_ERROR("2024", "方法不存在错误")
	, OUT_OF_MEMORY_ERROR("2025", "内存不足错误")
	, STACK_OVER_FLOW_ERROR("2026", "堆栈溢出错误")
	, THREAD_DEATH("2027", "线程结束")
	, UNKNOWN_ERROR("2028", "未知错误")
	, UNSATISFIED_LINK_ERROR("2029", "未满足的链接错误")
	, UNSUPPORTED_CLASS_VERSION_ERROR("2030", "不支持的类版本错误")
	, VERIFY_ERROR("2031", "验证错误")
	, VIRTUAL_MACHINE_ERROR("2032", "虚拟机错误")
	, ARRAY_STORE_EXCEPTION("2033", "数组存储异常")
	, CLASS_NOT_FOUND_EXCEPTION("2034", "找不到类异常")
	, CLONE_NOT_SUPPORTED_EXCEPTION("2035", "不支持克隆异常")
	, ENUM_CONSTANT_NOT_PRESENT_EXCEPTION("2036", "枚举常量不存在异常")
	, ILLEGAL_ACCESS_EXCEPTION("2037", "违法的访问异常")
	, ILLEGAL_MONITOR_STATE_EXCEPTION("2038", "违法的监控状态异常")
	, ILLEGAL_STATE_EXCEPTION("2039", "违法的状态异常")
	, ILLEGAL_THREAD_STATE_EXCEPTION("2040", "违法的线程状态异常")
	, INSTANTIATION_EXCEPTION("2041", "实例化异常")
	, INTERRUPTED_EXCEPTION("2042", "被中止异常")
	, NEGATIVE_ARRAY_SIZE_EXCEPTION("2043", "数组大小为负值异常")
	, NOSUCH_FIELD_EXCEPTION("2044", "属性不存在异常")
	, NOSUCH_METHOD_EXCEPTION("2045", "方法不存在异常")
	, SECURITY_EXCEPTION("2046", "安全异常")
	, STRING_INDEXOUTOF_BOUNDS_EXCEPTION("2047","字符串索引越界异常")
	, TYPE_NOT_PRESENT_EXCEPTION("2048", "类型不存在异常")
	, UN_SUPPORTED_OPERATION_EXCEPTION("2049", "不支持的方法异常")
	, DATA_ACCESS_EXCEPTION("2050", "数据访问异常");

	private String code;

	private String message;

	private ErrorCodeEnum(String code, String msg) {
		this.code = code;
		this.message = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
