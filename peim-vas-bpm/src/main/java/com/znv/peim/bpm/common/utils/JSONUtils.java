package com.znv.peim.bpm.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Json 处理类
 *
 * @author Yum
 * @version 1.0
 * @since 2020-08-10 15:15:21
 */
@Slf4j
public class JSONUtils {

    /**
     * 将对象转化成json字符串
     *
     * @param o
     * @return
     */
    public static String jsonString(Object o) {
        return JSON.toJSONString(o, SerializerFeature.WriteNullStringAsEmpty);
    }

    /**
     * 将json字符串转化成对象
     *
     * @param str
     * @return
     */
    public static <T> T jsonStringToObject(String str, Class<T> objClass) {
        return JSON.parseObject(str, objClass);
    }

    /**
     * 将json字符串转化成List对象
     *
     * @param str
     * @return
     */
    public static <T> List<T> jsonToList(String str, Class<T> objClass) {
        return JSON.parseArray(str, objClass);
    }

    public static String toJsonNotNull(Object obj) {
        String json = StringUtils.EMPTY;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(Include.NON_NULL);
            json = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("toJsonNotNull error:", e);
        }
        return json;
    }

    public static JSONObject parseStringToJsonObject(String jsonString) {
        return JSON.parseObject(jsonString);
    }

}
