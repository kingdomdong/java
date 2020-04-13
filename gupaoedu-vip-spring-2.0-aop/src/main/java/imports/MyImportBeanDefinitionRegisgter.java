package imports;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegisgter implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //包里如果声明了Company和Member这两个类，才将User对象注册到IoC容器
        boolean company = registry.containsBeanDefinition("project.entity.Company");

        boolean member = registry.containsBeanDefinition("project.entity.Member");
        if (company && member) {
            BeanDefinition beanDefinition = new RootBeanDefinition();

        }
    }
}
