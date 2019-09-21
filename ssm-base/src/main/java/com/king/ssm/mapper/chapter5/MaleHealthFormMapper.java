package com.king.ssm.mapper.chapter5;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.king.ssm.pojo.MaleHealthForm;

@Repository
public interface MaleHealthFormMapper {
	
	public List<MaleHealthForm> getMaleHealthForm(Long empId);

}
