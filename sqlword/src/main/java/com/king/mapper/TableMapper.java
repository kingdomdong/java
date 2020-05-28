package com.king.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TableMapper {

    @Select("SELECT TABLE_NAME, TABLE_COMMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = #{tableSchema}")
    List<Map<String, Object>> getAllTableName(@Param("tableSchema") String tableSchema);

    @Select("SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = #{tableName} AND TABLE_SCHEMA = #{schema}")
    List<Map<String, Object>> getTableDetail(String tableName, String schema);

}
