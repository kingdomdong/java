package com.king.junit;

import com.king.LearnApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test annotations
 * refer to spring test website
 * @author Yum
 * @since 2020-11-10 16:49:29
 * @version 1.0
 */
@ActiveProfiles("debug")
//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = LearnApplication.class)
//@ContextConfiguration
class TestAnnotationTest {

    @Value("${spring.datasource.password}")
    String dbPassword;


    @Test
    void isPropertiesFromDebugFile() {
        assertThat(dbPassword).isEqualTo("123456");
    }

}
