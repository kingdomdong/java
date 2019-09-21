package com.king.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.king.pojo.User;
import com.king.utils.ObjectUtils;

@Service
public class PropertyService {
	
	@Value("#{${admin}}")
	Map<String, String> userMap;
	
	public User getAdmin() {
		User admin = ObjectUtils.toObject(User.class, userMap);
		return admin;
	}

}
