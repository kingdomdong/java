package imports;

import org.springframework.beans.factory.FactoryBean;
import project.entity.Monkey;

public class MyImportFactoryBean implements FactoryBean<Monkey> {

    public Monkey getObject() throws Exception {
        return null;
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return true;
    }

}
