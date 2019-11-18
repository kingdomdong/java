package com.king.request;//package com.znv.cop.ods.inf.service;
//
//import java.net.URI;
//import java.util.Map;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//
//import com.znv.cop.ods.result.vo.XCResponse;
//
//import feign.RequestLine;
//
//@FeignClient(name = "xcsspFeignClient")
//public interface XCFeignClient {
//    
//    // Sign Check
//    @RequestLine("POST")
//    XCResponse signCheck(URI signCheckURI, Map<String, Object> map);
//    
//    // SSP
//    @RequestLine("GET")
//    XCResponse queryDeviceDetail(URI deviceURI);
//    
//    @RequestLine("GET")
//    XCResponse queryDeviceList(URI dvListURI);
//    
//    @RequestLine("GET")
//    XCResponse queryItems(URI itemsURI);
//    
//    @RequestLine("GET")
//    XCResponse queryDeviceScheme(URI dvSchemeURI);
//    
//    @RequestLine("GET")
//    XCResponse woNotify(URI woNotifyURI);
//    
//    // CRM
//    @RequestLine("GET")
//    XCResponse queryDeveloper(URI developer);    
//    
//}
