package com.king.bean.ssm.mapper.chapter5;

import java.util.List;

import com.king.bean.ssm.pojo.WorkCard;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkCardMapper {

	List<WorkCard> getWorkCard(Long empId);
	
}
