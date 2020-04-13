package imports;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 *
 * @author kingdomdong
 * @since 2020-04-12 21:05:20
 * @version 1.0
 */
public class MyImportTest {

    @Test
    void importTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyImportConfig.class);
        System.out.println("IoC容器创建完成");

        System.out.println(applicationContext.);

        String[] beanNames = applicationContext.getBeanDefinitionNames();

        Object monkey1 = applicationContext.getBean("monkey");
        Object monkey2 = applicationContext.getBean("monkey");

        System.out.println(Arrays.toString(beanNames)
        .replaceAll("\\[|\\]","")
        .replaceAll("", ""));

    }

}
