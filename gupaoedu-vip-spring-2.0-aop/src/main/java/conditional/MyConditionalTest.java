package conditional;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyConditionalTest {


    @Test
    void testLazy() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConditionalConfig.class);
        System.out.println("Ioc容器创建完成");



    }

}
