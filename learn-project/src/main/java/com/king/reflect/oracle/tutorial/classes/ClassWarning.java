package com.king.reflect.oracle.tutorial.classes;

import java.lang.reflect.Method;

/**
 * typical errors which may be encountered when reflecting on classes
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-05-15 10:45:20
 */
public class ClassWarning {

    void m() {
        Class<ClassWarning> warningClass = ClassWarning.class;
        try {
            Method method = warningClass.getMethod("m"); // warning
            // production code should handle this exception more gracefully
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
