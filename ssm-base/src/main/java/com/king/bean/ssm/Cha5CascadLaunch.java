package com.king.bean.ssm;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.king.bean.ssm.mapper.chapter5.EmployeeMapper;
import com.king.bean.ssm.pojo.Employee;
import com.king.bean.ssm.utils.SqlSessionFactoryUtils;

public class Cha5CascadLaunch {
	
	private static final Logger log = LoggerFactory.getLogger(Cha5CascadLaunch.class);
	
	public static void main(String[] args) {
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession =  SqlSessionFactoryUtils.genFactoryByXML().openSession();
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			List<Employee> employees = employeeMapper.getEmployee(1L);
			for (Employee employee : employees) {
				log.info(employee.getBirthday().toString());
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}

}
