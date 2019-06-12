package com.king.ssm.mapper.chapter5;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.king.ssm.pojo.FemaleHealthForm;

@Repository
public interface FemaleHealthFormMapper {
	
	public List<FemaleHealthForm> getFemaleHealthForm(Long empId);

}
