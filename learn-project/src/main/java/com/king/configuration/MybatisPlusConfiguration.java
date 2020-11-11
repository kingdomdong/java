package com.king.configuration;

import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

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
        paginationInterceptor.setSqlParserList(Collections.singletonList(dynamicTableNameParser));
        return paginationInterceptor;
    }

}
