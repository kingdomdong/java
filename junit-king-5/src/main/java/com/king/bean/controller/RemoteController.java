package com.king.bean.controller;

import com.king.bean.enumeration.SexEnum;
import com.king.bean.pojo.Role;
import com.king.bean.remote.WgsFeignService;
import com.king.bean.req.WOListReqDto;
import com.king.bean.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.king.bean.base.Response;

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
	
	@GetMapping(value = "/")
	public Response testEnum() {
		Role role = new Role();
		role.setId(1);
		role.setSex(SexEnum.FEMALE);
		return new Response(role);
	}

}
