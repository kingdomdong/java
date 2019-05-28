package com.king.ssm.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.king.ssm.chapter3.utils.SqlSessionFactoryUtils;
import com.king.ssm.mapper.chapter3.RoleMapper;
import com.king.ssm.pojo.Role;

public class Chapter3Main {

	private static Logger logger = LoggerFactory.getLogger(Chapter3Main.class);

	public static void main(String[] args) {

		SqlSession session = null;
		try {
			session = SqlSessionFactoryUtils.genFactoryByXML().openSession();
			logger.info("sqlSession open()");
			RoleMapper roleMapper = session.getMapper(RoleMapper.class);
			List<Role> role = roleMapper.findRoles2("R");
			if (role != null) {
				for (Role elem : role) {
					logger.info(elem.getNote());
				}
			}

			session.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
			if (session != null) {
				session.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
				logger.info("sqlSession close()");
			}
		}

	}
	
	public static void insertRole(Role role) {
		SqlSession session = null;
		try {
			session = SqlSessionFactoryUtils.genFactoryByXML().openSession();
			logger.info("sqlSession open()");
			RoleMapper roleMapper = session.getMapper(RoleMapper.class);

			Role rolePojo = new Role();
			rolePojo.setNote("tempRole");
			rolePojo.setRoleName("MANAGER");
			roleMapper.insertRole(rolePojo);
			
			session.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
			if (session != null) {
				session.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
				logger.info("sqlSession close()");
			}
		}
	}

}
