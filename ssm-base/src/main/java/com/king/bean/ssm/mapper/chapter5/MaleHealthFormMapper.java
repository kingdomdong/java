package com.king.bean.ssm.mapper.chapter5;

import java.util.List;

import com.king.bean.ssm.pojo.MaleHealthForm;
import org.springframework.stereotype.Repository;

@Repository
public interface MaleHealthFormMapper {
	
	public List<MaleHealthForm> getMaleHealthForm(Long empId);

}
