package configuration;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {

    @Test
    void configTest() {
        // IoC
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("IoC 容器");

        Object bean1 = applicationContext.getBean("person2");
        Object bean2 = applicationContext.getBean("person2");

        System.out.println(bean1 == bean2);

    }


}
