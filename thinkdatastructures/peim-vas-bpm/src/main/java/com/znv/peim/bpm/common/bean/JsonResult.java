/**
 * <pre>
 * 标  题: JsonResult.java.
 * 版权所有: 版权所有(C)2001-2016
 * 公   司: 深圳中兴力维技术有限公司
 * 内容摘要: // 简要描述本文件的内容，包括主要模块、函数及其功能的说明
 * 其他说明: // 其它内容的说明
 * 完成日期: 2016年6月14日
 * </pre>
 * <pre>
 * 修改记录1:
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * @version 1.0
 * @author ChenFei
 */

package com.znv.peim.bpm.common.bean;


/**
 * @author ChenFei。
 */
public class JsonResult {
    private int code = -1;
    private String msg;
    private Object info;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_ERROR = -1;
    public static final int CODE_NOT_LOGIN = -2;

    public int getCode() {
        return code;
    }

    public JsonResult setCode(int codeParam) {
        this.code = codeParam;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public JsonResult setMsg(String msgParam) {
        this.msg = msgParam;
        return this;
    }

    public Object getInfo() {
        return info;
    }

    public JsonResult setInfo(Object infoParam) {
        this.info = infoParam;
        return this;
    }

    public JsonResult success() {
        this.code = CODE_SUCCESS;
        return this;
    }

    public JsonResult success(String infoParam) {
        this.code = CODE_SUCCESS;
        this.info = infoParam;
        return this;
    }

    public JsonResult success(Object infoParam) {
        this.code = CODE_SUCCESS;
        this.info = infoParam;
        return this;
    }

    public JsonResult success(String msgParam, Object infoParam) {
        this.code = CODE_SUCCESS;
        this.msg = msgParam;
        this.info = infoParam;
        return this;
    }

    public JsonResult error(String msgParam) {
        if (this.code == CODE_SUCCESS) {
            this.code = CODE_ERROR;
        }
        this.msg = msgParam;
        return this;
    }

    public JsonResult error(int codeParam, String msgParam) {
        this.code = codeParam;
        this.msg = msgParam;
        return this;
    }

    public boolean isSuccess() {
        return CODE_SUCCESS == this.code;
    }

}
