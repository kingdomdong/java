package com.znv.cop.klb.annotation.logenum;

/**
 * 记录日志类型枚举
 * 
 * @author xubin
 *
 */
public enum LogType {
	InterfaceLog(1), BusinessActionLog(2), SendAlarmLog(3), SysExceptionLog(4);
	private Integer code;

	LogType(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
}
