package com.king.bean.ssm;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.king.bean.ssm.mapper.chapter4.UserMapper;
import com.king.bean.ssm.pojo.User;
import com.king.bean.ssm.utils.SqlSessionFactoryUtils;

public class Cha4EnumIbatisLaunch {

	private static final Logger log = LoggerFactory.getLogger(Cha4EnumIbatisLaunch.class);

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
