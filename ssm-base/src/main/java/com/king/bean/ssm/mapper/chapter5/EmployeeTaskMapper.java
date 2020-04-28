package com.king.bean.ssm.mapper.chapter5;

import java.util.List;

import com.king.bean.ssm.pojo.EmployeeTask;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTaskMapper {
	
	List<EmployeeTask> getEmployeeTask(Long empId);

}
