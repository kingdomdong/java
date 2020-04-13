package configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Annotation configure
 * @author kingdomdong
 * @since 2020-04-12 20:42:28
 * @version 1.0
 */
@Configuration
@ComponentScan(value = "src.main.java.project", useDefaultFilters = false)
public class MyConfig {

}
