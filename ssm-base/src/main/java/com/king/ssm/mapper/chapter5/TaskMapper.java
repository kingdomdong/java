package com.king.ssm.mapper.chapter5;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.king.ssm.pojo.Task;

@Repository
public interface TaskMapper {

	public List<Task> getTask(Long id);
	
}
