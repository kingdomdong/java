package com.king.ssm.mapper.chapter3;

import java.util.List;

import com.king.ssm.chapter3.pojo.Role;

public interface RoleMapper {
	
	public int insertRole(Role role);
	public int deleteRole(Role role);
	public int updateRole(Role role);
	public Role getRole(Long id);
	public List<Role> findRoles(String roleName);

}
