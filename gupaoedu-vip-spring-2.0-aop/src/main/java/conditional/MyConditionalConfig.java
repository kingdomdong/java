package conditional;

import javafx.util.converter.PercentageStringConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.entity.Person;

@Configuration
public class MyConditionalConfig {

    @Bean
    public Person person() {
        System.out.println("将对象添加到IoC容器中");
        return new Person("Tom", 18);
    }

}
