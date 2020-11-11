package com.znv.peim.bpm.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ResultCodeEnum
 *
 * @author Yum
 * @version 1.0
 * @since 2020-09-14 17:17:48
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {

    NORMAL(200, "正常"),
    SYSTEM_ERROR(500, "系统异常"),
    PARAMETER_ERROR(1, "参数异常"),
    OTHERERROR(2, "其他错误"),
    UNKNOWNERROR(3, "未知错误"),
    INTERFACEUNAVAILABLE(4, "接口不可用"),
    NODATA(5, "缺少数据"),
    ;

    private int code;
    private String name;

}
