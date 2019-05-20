package com.znv.cop.hrm.result.vo;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 返回给前台的json结果
 * @author nieguigui
 */
public class JsonResult {

    /**
     * 构造函数
     */
    public JsonResult() {
        this.code = JsonResultType.ERROR.getValue();
    }

    /**
     * 构造函数
     * @param type 结果类型
     */
    public JsonResult(JsonResultType type) {
        this.code = type.getValue();
    }

    /**
     * 设置结果类型
     * @param type
     */
    public void setType(JsonResultType type) {
        this.code = type.getValue();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 增加传出的结果
     * @param key
     * @param value
     */
    public void add(String key, Object value) {
        if (this.items.containsKey(key)) {
            this.items.remove(key);
            this.items.put(key, value);
        } else {
            this.items.put(key, value);
        }
    }

    /**
     * 移除传出的结果
     * @param key
     */
    public void remove(String key) {
        this.items.remove(key);
    }

    /**
     * 输出JSON
     * @return
     */
    public String toJSON() {
        this.items.put(TAGCODE, this.getCode());
        if (this.getCode() == 0) {
            this.items.put(TAGSUCCESS, true);
            this.items.put(TAGMSG, "OK");
        } else {
            this.items.put(TAGSUCCESS, false);
            this.items.put(TAGMSG, this.getMessage());
        }

        JSONObject json = new JSONObject();
        json.putAll(this.items);
        return JSONObject.toJSONString(json, SerializerFeature.WriteNullStringAsEmpty);
    }

    /**
     * 结果类型
     */
    private int code;
    private String message;
    private Map<String, Object> items = new HashMap<String, Object>();
    private static final String TAGSUCCESS = "success";
    private static final String TAGCODE = "errCode";
    private static final String TAGMSG = "msg";
}
