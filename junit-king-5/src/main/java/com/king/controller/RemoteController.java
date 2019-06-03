package com.king.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.king.base.Response;
import com.king.remote.WgsFeignService;
import com.king.req.WOListReqDto;
import com.king.utils.ObjectUtils;

@RestController
@RequestMapping(value = "/wgs", produces = {"application/json; charset=UTF-8"})
public class RemoteController {
	
	@Autowired
	WgsFeignService wgsFeignService;
	
	@GetMapping(value = "/wo/list/query")
	public Response queryWOList(WOListReqDto reqDto) {
		return wgsFeignService.queryWOList(ObjectUtils.toParamMap(reqDto));
//		return wgsFeignService.queryWOList(reqDto);
	}

}
