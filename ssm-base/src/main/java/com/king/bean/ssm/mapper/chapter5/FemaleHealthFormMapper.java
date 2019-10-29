package com.king.bean.ssm.mapper.chapter5;

import java.util.List;

import com.king.bean.ssm.pojo.FemaleHealthForm;
import org.springframework.stereotype.Repository;

@Repository
public interface FemaleHealthFormMapper {
	
	public List<FemaleHealthForm> getFemaleHealthForm(Long empId);

}
