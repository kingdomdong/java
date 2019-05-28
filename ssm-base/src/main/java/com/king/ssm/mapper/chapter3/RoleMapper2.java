package com.king.ssm.mapper.chapter3;

import org.apache.ibatis.annotations.Select;

import com.king.ssm.pojo.Role;

public interface RoleMapper2 {
	
	@Select("select id, role_name as roleName, note from t_role where id = #{id}")
	public Role getRole(Long id);

}
