package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * First way:
 * comment @EnableWebSecurity OR @Configuration
 * in junit, use @WebMvcTest(secure = false)
 *
 * Second way:
 *  use antMatches("/**") in WebSecurityConfigurerAdapter
 */
@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
})
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class);
    }

}
