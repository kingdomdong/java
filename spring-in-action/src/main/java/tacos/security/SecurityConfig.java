package tacos.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * chapter 4 security configuration
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-01-14
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * filter h2 browser request
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/h2-console/**");
    }

}


