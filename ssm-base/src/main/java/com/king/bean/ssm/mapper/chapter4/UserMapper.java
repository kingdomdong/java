package com.king.bean.ssm.mapper.chapter4;

import java.util.List;

import com.king.bean.ssm.pojo.User;

public interface UserMapper {

	List<User> getUser(Long id);
	
}
