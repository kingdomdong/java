package com.king.ssm.mapper.chapter5;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.king.ssm.pojo.Employee;

@Repository
public interface EmployeeMapper {

	public List<Employee> getEmployee(Long id);
	
}
