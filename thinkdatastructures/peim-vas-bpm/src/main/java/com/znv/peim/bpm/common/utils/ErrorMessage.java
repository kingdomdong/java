package com.znv.peim.bpm.common.utils;

import java.io.File;
import java.io.IOException;


import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author Administrator
 */
public class ErrorMessage {
    private static final JSONObject ERROR_JSON = new JSONObject();

    private static Logger logger = LoggerFactory.getLogger(ErrorMessage.class);

    /**
     * 获取错误号对应的错误信息
     *
     * @param code 错误号
     * @return
     */
    public static String getErrorMessage(String code) {
        if (ERROR_JSON.size() == 0) {
            Document doc = null;
            try {
//                Resource resource = new ClassPathResource("system_message.xml");
//                if (resource.exists()) {
//                    doc = Jsoup.parse(resource.getFile(), "UTF-8");
//                } else {
                    String path = System.getProperty("user.dir") + File.separator + "config" + File.separator + "system_message.xml";
                    doc = Jsoup.parse(new File(path), "UTF-8");
//                }

                // String path = ErrorMessage.class.getClassLoader().getResource("system_message.xml").getPath();

                Elements eles = doc.select("error");
                for (Element e : eles) {
                    // ERROR_JSON.put(e.attr("code"), String.format("%s - %s", e.attr("zh_info"), e.attr("en_info")));
                    ERROR_JSON.put(e.attr("code"), e.attr("zh_info"));
                }
            } catch (IOException e) {


                int i = 0;
            }
            ERROR_JSON.put("0", "OK");
        }

        if (ERROR_JSON.containsKey(code)) {
            return ERROR_JSON.getString(code);
        } else {
            return code;
        }
    }

}
