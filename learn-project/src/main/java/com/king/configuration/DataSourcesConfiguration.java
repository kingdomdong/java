package com.king.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * multiple data sources in jpa
 *
 * @author Yum
 * @version 1.0
 * @since 2020-08-04 17:23:43
 */
@Configuration
public class DataSourcesConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties usmscDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    @Primary
    public DataSource usmscSchema(DataSourceProperties sourceProperties) {
        return sourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

}

