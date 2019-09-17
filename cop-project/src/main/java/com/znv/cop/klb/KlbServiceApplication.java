package com.znv.cop.klb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.PageHelper;
import com.znv.cop.klb.util.Logger;

/**
 * KLB服务启动类
 * @author 
 * @version V0.0.1
 * @since 2018-06-21
 */
@Configuration("com.znv.cop")
@EntityScan("com.znv.cop")
@MapperScan("com.znv.cop")
@ComponentScan("com.znv.cop")
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableFeignClients
public class KlbServiceApplication {

    public static void main(String[] args) {
        String env = "";
        if (args.length > 0) {
            String[] sp = args[0].split("=");
            if (sp.length > 1) {
                env = sp[1];
            }
        }
        Properties po = new Properties();
        InputStream in = null;
        Logger.i("启动环境： " + env + "   ##################################################################");
        switch (env) {
            case "dev":
                in = KlbServiceApplication.class.getResourceAsStream("/config/dev/application.properties");
                break;
            case "test":
                in = KlbServiceApplication.class.getResourceAsStream("/config/test/application.properties");
                break;
            case "prd":
                in = KlbServiceApplication.class.getResourceAsStream("/config/prd/application.properties");
                break;
            default:
                Logger.i("启动环境： 输入参数错误！启用默认环境 ！######################################################");
                in = KlbServiceApplication.class.getResourceAsStream("/config/dev/application.properties");
                break;
        }
        try {
            po.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SpringApplication app = new SpringApplication(KlbServiceApplication.class);
        app.setDefaultProperties(po);
        app.run(args);
        Logger.i("启动成功！！！######################################################");
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        //设置超时时间
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(10000);
        httpRequestFactory.setConnectTimeout(10000);
        return new RestTemplate(httpRequestFactory);
    }

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect", "mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
