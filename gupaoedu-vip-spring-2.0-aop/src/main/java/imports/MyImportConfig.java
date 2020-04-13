package imports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import project.entity.Cat;
import project.entity.Person;

/**
 *
 * @author kingdomdong
 * @since 2020-04-12 21:04:25
 * @version 1.0
 */
@Configuration
@Import(value = {Cat.class, MyImportBeanDefinitionRegisgter.class})
public class MyImportConfig {

    // 给IoC容器注册Bean的方式
    // 1. @Bean 直接导入单个类
    // 2. @ComponentScan 默认扫描 (@Controller, @Service, @Repository, @Component)
    // 3. Import 快速给容器导入Bean的方式
    // a.@Import 直接参数导入
    // b.实现ImportSelector 自定义规则实现
    // c.实现ImportBeanDefinitionRegister，获得BeanDefinitionRegistry可以手动直接往IoC容器中塞东西
    // 4.FactoryBean 把需要注册的对象封装为FactoryBean
    // a.FactoryBean 负责将Bean注册到IoC的Bean
    // b.BeanFactory 从IoC容器中获得Bean对象
    @Bean
    public Person person() {
        System.out.println("将对象添加到IoC容器中");
        return new Person("Tom", 18);
    }

    @Bean
    public MyImportFactoryBean monkey() {
        return new MyImportFactoryBean();
    }

}
