package imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 *
 * @author kingdomdong
 * @since 2020-04-12 21:10:42
 * @version 1.0
 */
public class MyImprotSelector implements ImportSelector {

    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[0];
    }

}
