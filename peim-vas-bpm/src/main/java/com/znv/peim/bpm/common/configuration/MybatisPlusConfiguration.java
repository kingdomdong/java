package com.znv.peim.bpm.common.configuration;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.znv.peim.bpm.common.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import static com.znv.peim.bpm.common.utils.DateUtils.*;

/**
 * MP configuration
 *
 * @author Yum
 * @version 1.0
 * @since 2020-08-17 18:55:54
 */
@Slf4j
@Configuration
@MapperScan("com.znv.**.mapper")
public class MybatisPlusConfiguration {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作，true 调回到首页，false 继续请求，默认false
        paginationInterceptor.setOverflow(false);
        paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化，只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
        HashMap<String, ITableNameHandler> tableNames = new HashMap<>(1);
        tableNames.put("vas.t_his_ems_power_hour_", (metaObject, sql, tableName) -> {
            log.info("meteObject: {}", JSONUtils.jsonString(metaObject));
            return tableName + getTableNameSuffix(metaObject, "record_time");
        });
        dynamicTableNameParser.setTableNameHandlerMap(tableNames);
        paginationInterceptor.setSqlParserList(Collections.singletonList(dynamicTableNameParser));
        return paginationInterceptor;
    }

    private String getTableNameSuffix(MetaObject metaObject, String fieldName) {
        String createTime = getParameterValue(metaObject, fieldName);
        if (StringUtils.isBlank(createTime)) {
            return format(new Date(), YEAR_MONTH_PATTERN);
        }
        return parse(createTime, DATE_TIME_PATTERN, YEAR_MONTH_PATTERN);
    }

    private String getParameterValue(MetaObject metaObject, String key) {
        Object originalObject = metaObject.getOriginalObject();
        String jsonString = JSONUtils.jsonString(originalObject);
        JSONObject jsonObject = JSONUtils.parseStringToJsonObject(jsonString);
        JSONObject param = jsonObject.getJSONObject("boundSql").getJSONObject("parameterObject");
        return (String) param.get(key);
    }

}
