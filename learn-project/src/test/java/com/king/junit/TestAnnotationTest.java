package com.king.junit;

import com.king.Main;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
@SpringBootTest(classes = Main.class)
//@ContextConfiguration
class TestAnnotationTest {

    @Value("${spring.datasource.password}")
    String dbPassword;


    @Test
    void isPropertiesFromDebugFile() {
        assertThat(dbPassword).isEqualTo("123456");
    }

}
