package com.king.ssm.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.king.ssm.chapter3.utils.SqlSessionFactoryUtils;
import com.king.ssm.mapper.chapter4.UserMapper;
import com.king.ssm.pojo.User;

public class Chapter4Main {

	private static final Logger log = LoggerFactory.getLogger(Chapter4Main.class);

	public static void main(String[] args) {
		SqlSession sqlSession = SqlSessionFactoryUtils.genFactoryByXML().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// sex.value = 0
			// sex.name = "FEMALE"
			// sex.ordinal= 1
			List<User> users = userMapper.getUser(1L);
			for (User elem : users) {
				log.info("name:" + elem.getSex().getName() + " ordinal:" + elem.getSex().ordinal());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

}
