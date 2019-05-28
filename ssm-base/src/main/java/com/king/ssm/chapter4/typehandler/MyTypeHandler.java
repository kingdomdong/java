package com.king.ssm.chapter4.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * simulate StringTypeHandler
 */
//@MappedTypes(String.class)
//@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyTypeHandler implements TypeHandler<String> {

	private static final Logger logger = LoggerFactory.getLogger(MyTypeHandler.class);

	@Override
	public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
		logger.info("set up string parameters ¡¾" + parameter +"¡¿");
		ps.setString(i, parameter);
	}

	@Override
	public String getResult(ResultSet rs, String columnName) throws SQLException {
		String result = rs.getString(columnName);
		logger.info("get string parameter_one ¡¾" + result + "¡¿");
		return result;
	}

	@Override
	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		String result = rs.getString(columnIndex);
		logger.info("get string parameter_two ¡¾" + result + "¡¿");
		return result;
	}

	@Override
	public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
		String result = cs.getString(columnIndex);
		logger.info("get string parameter_three ¡¾" + result + "¡¿");
		return result;
	}

}
