package lazy;

import conditional.MyConditionalConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author kingdomdong
 * @since 2020-04-12 20:52:25
 * @version 1.0
 */
public class MyLazyTest {

    @Test
    void testLazy() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConditionalConfig.class);
        System.out.println("Ioc容器创建完成");



    }

}
