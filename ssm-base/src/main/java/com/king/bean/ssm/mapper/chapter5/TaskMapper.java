package com.king.bean.ssm.mapper.chapter5;

import java.util.List;

import com.king.bean.ssm.pojo.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskMapper {

	List<Task> getTask(Long id);
	
}
