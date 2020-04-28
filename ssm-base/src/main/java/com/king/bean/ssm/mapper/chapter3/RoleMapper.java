package com.king.bean.ssm.mapper.chapter3;

import java.util.List;

import com.king.bean.ssm.pojo.Role;

public interface RoleMapper {
	
	int insertRole(Role role);
	int deleteRole(Role role);
	int updateRole(Role role);
	Role getRole(Long id);
	List<Role> findRoles(String roleName);
	List<Role> findRoles2(String note);

}
