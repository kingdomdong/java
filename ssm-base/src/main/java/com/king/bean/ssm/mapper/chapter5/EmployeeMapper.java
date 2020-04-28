package com.king.bean.ssm.mapper.chapter5;

import java.util.List;

import com.king.bean.ssm.pojo.Employee;

public interface EmployeeMapper {

	List<Employee> getEmployee(Long id);
	
}
