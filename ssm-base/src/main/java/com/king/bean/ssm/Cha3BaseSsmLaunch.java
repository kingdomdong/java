package com.king.bean.ssm;

import java.util.List;

import com.king.bean.ssm.mapper.chapter3.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.king.bean.ssm.pojo.Role;
import com.king.bean.ssm.utils.SqlSessionFactoryUtils;

public class Cha3BaseSsmLaunch {

	private static Logger logger = LoggerFactory.getLogger(Cha3BaseSsmLaunch.class);

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
