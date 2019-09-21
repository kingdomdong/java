package com.king.ssm.mapper.chapter4;

import java.util.List;

import com.king.ssm.pojo.User;

public interface UserMapper {

	public List<User> getUser(Long id);
	
}
