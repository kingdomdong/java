package com.king.bean.ssm.mapper.chapter3;

import org.apache.ibatis.annotations.Select;

import com.king.bean.ssm.pojo.Role;

public interface RoleMapper2 {
	
	@Select("select id, role_name as roleName, note from t_role where id = #{id}")
    Role getRole(Long id);

}
