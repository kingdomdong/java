package com.king.bean.service;

import java.util.Map;

import com.king.bean.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.king.bean.pojo.User;

@Service
public class PropertyService {
	
	@Value("#{${admin}}")
	Map<String, String> userMap;
	
	public User getAdmin() {
		User admin = ObjectUtils.toObject(User.class, userMap);
		return admin;
	}

}
