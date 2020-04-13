package lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import project.entity.Person;

@Configuration
public class MyLazyConfig {

    @Bean
    @Lazy // 只针对单例Bean
    public Person person() {
        Person person = new Person();
        System.out.println("将对象添加到IoC容器中");
        return person;
    }

}
