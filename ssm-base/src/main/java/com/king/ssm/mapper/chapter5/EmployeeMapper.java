package com.king.ssm.mapper.chapter5;

import java.util.List;

import com.king.ssm.pojo.Employee;

public interface EmployeeMapper {

	public List<Employee> getEmployee(Long id);
	
}
