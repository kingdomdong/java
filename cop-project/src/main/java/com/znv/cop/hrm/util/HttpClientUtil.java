package com.znv.cop.hrm.util;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Http请求发送工具类，用于远程调用接口
 * @author nieguigui
 * @since 2018-06-29
 * @version V0.0.1
 */
public class HttpClientUtil {

    public static String post(String url, String params) {

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse result = null;
        String resData = null;
        try {
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000) //设置连接超时时间
                    .setConnectionRequestTimeout(10000) //设置请求超时时间
                    .setSocketTimeout(10000) //默认允许自动重定向
                    .build();
            httpClient = HttpClients.createDefault();
            HttpPost method = new HttpPost(url);
            StringEntity entity = new StringEntity(params, "utf-8"); //解决中文乱码问题
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/x-www-form-urlencoded");
            method.setEntity(entity);
            method.setConfig(requestConfig);
            result = httpClient.execute(method);

            int statusCode = result.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                //请求结束，返回结果
                resData = EntityUtils.toString(result.getEntity());
            } else {
                Logger.e(statusCode);
            }
        } catch (Exception ex) {
            Logger.e(ex);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return resData;
    }
}
