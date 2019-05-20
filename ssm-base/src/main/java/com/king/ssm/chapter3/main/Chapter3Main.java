package com.king.ssm.chapter3.main;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.king.ssm.chapter3.pojo.Role;
import com.king.ssm.chapter3.utils.SqlSessionFactoryUtils;
import com.king.ssm.mapper.chapter3.RoleMapper;

public class Chapter3Main {

	private static Logger logger = LoggerFactory.getLogger(Chapter3Main.class);

	public static void main(String[] args) {

		SqlSession session = null;
		try {
			session = SqlSessionFactoryUtils.genFactoryByXML().openSession();
			logger.info("sqlSession open()");
			RoleMapper roleMapper = session.getMapper(RoleMapper.class);
			Role role = roleMapper.getRole(1L);
			if (role != null) {
				logger.info(role.getRoleName());
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

}
