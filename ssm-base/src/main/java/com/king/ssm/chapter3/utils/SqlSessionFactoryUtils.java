package com.king.ssm.chapter3.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.king.ssm.chapter3.pojo.Role;
import com.king.ssm.mapper.chapter3.RoleMapper;

public class SqlSessionFactoryUtils {

	private final static Class<SqlSessionFactoryUtils> LOCK_CLASS = SqlSessionFactoryUtils.class;

	private static SqlSessionFactory sqlSessionFactory = null;

	public SqlSessionFactoryUtils() {
	};

	public static SqlSessionFactory genFactoryByXML() {
		synchronized (LOCK_CLASS) {
			if (sqlSessionFactory == null) {
				String resource = "mybatis-config.xml";
				try (InputStream inputStream = Resources.getResourceAsStream(resource);) {
					sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sqlSessionFactory;
	}

	public static SqlSessionFactory genFactoryByCode() {

		synchronized (LOCK_CLASS) {
			if (sqlSessionFactory == null) {
				// user mybatis JDBC transaction
				TransactionFactory transactionFactory = new JdbcTransactionFactory();
				// dataSource config
				PooledDataSource dataSource = new PooledDataSource();
				dataSource.setDriver("com.mysql.jdbc.Driver");
				dataSource.setUsername("root");
				dataSource.setPassword("123456");
				dataSource.setUrl("jdbc:mysql://localhost:3306/ssm");
				dataSource.setDefaultAutoCommit(false);
				Environment environment = new Environment("develop", transactionFactory, dataSource);
				// create Configuration
				Configuration configuration = new Configuration(environment);
				// register a mybatis context alias
				configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
				// add a mapper
				configuration.addMapper(RoleMapper.class);
				// build sql session factory by SqlSessionFactoryBuilder
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
			}
		}

		return sqlSessionFactory;
	}

}
