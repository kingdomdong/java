package com.king.ssm.mapper.chapter5;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.king.ssm.pojo.WorkCard;

@Repository
public interface WorkCardMapper {

	public List<WorkCard> getWorkCard(Long empId);
	
}
