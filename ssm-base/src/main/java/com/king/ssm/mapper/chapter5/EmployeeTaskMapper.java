package com.king.ssm.mapper.chapter5;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.king.ssm.pojo.EmployeeTask;

@Repository
public interface EmployeeTaskMapper {
	
	public List<EmployeeTask> getEmployeeTask(Long empId);

}
