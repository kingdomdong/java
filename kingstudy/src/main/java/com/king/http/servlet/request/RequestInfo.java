package com.king.http.servlet.request;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.king.utils.ObjectUtils;

public class RequestInfo {

    private HttpServletRequest request;

    public RequestInfo(HttpServletRequest request) {
        this.request = request;
    }
    
    public static void main(String[] args) {
    }

    public String obtainPostParams() throws Exception{
        String reqURL = request.getRequestURL().toString();
        String ip = request.getRemoteHost();

        InputStream is = request.getInputStream();
        StringBuilder responseStrBuilder = new StringBuilder();
        BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null)
            responseStrBuilder.append(inputStr);
        //       System.out.println("请求参数: " + responseStrBuilder.toString ());
        String parmeter = responseStrBuilder.toString();

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        StringBuilder sb = new StringBuilder(1000);
        //请求方式  post\put\get 等等
        sb.append("RequestMethod    : ").append(request.getMethod()).append("\n");
        //所有的请求参数
        sb.append("Params    : ").append(parmeter).append("\n");
        //部分请求链接
        sb.append("URI       : ").append(request.getRequestURI()).append("\n");
        //完整的请求链接
        sb.append("AllURI    : ").append(reqURL).append("\n");
        sb.append("IP    : ").append(ip).append("\n");

        return sb.toString();
    }
    
    private String obtainToken(HttpServletRequest request) throws Exception {
        String accessToken = null;
        try (InputStream reqStream = request.getInputStream()) {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(reqStream, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);
            Map<String, Object> queryMap = ObjectUtils.toParamMap(responseStrBuilder.toString());
            accessToken = queryMap.get("accessToken").toString();
        } catch (Exception e) {
            throw e;
        }

        return accessToken;
    }

}
