package com.king.bean.remote;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.king.bean.base.Response;
@FeignClient(name = "junit-remote", url = "http://localhost:9035", decode404 = true)
public interface WgsFeignService {
	
	@GetMapping(value = "/wgs/tc/workorder/query/list")
	Response queryWOList(@RequestParam Map<String, Object> reqDto);
//	Response queryWOList(WOListReqDto reqDto);
	
}
