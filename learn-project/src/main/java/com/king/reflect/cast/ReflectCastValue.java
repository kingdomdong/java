package com.king.reflect.cast;

import java.lang.reflect.Field;

public class ReflectCastValue {

    public static void main(String[] args) {
        Field[] fields = createFields(new Categories()); // Initialize the fields array with all variable names and values
        try {
            for (Field field : fields) {
                System.out.println("Field name = " + field.getName()); // debug output
                System.out.println("Field type = " + field.getType().getName()); // debug output
                switch (field.getType().getName()) {
                    case "java.lang.Integer": { // Will not get called
                        Integer instance = 0;
                        Integer i = (Integer)field.getInt(instance);
                        System.out.println("Integer " + i);
                        break;
                    }
                    case "java.lang.Long": { // Will not get called
                        long instance = 0L;
                        Long l = (Long)field.getLong(instance);
                        System.out.println("Long " + l);
                        break;
                    }
                    case "java.lang.String": {
//                        String instance = "";
//                        Object o = field.get(instance); // This is what causes the error in: "Object o = field.get(instance);" - why ?
                        System.out.println("String " + field.get(new Categories()));
                        break;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + field.getType().getName());
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Field[] createFields(Object object) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Number of fields = " + fields.length);
        for (Field field : fields) {
            System.out.println("Field name = " + field.getName());
            System.out.println("Field type = " + field.getType().getName());
        }
        return fields;
    }

}
