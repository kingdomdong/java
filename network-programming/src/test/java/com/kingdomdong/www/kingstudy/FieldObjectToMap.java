package com.kingdomdong.www.kingstudy;

import java.lang.reflect.Field;

public class FieldObjectToMap {

    public void printMap() {
        FieldObjectToMap objectUtils = new FieldObjectToMap();
        FieldTest fieldTest = objectUtils.new FieldTest("XiaoXinXin", 20, "007", Double.valueOf(100.0));
        Class<?> clazz = fieldTest.getClass();
        
        /* Output:
         * class java.lang.Double | 1 | mathScore | 100.0
         * class com.kingdomdong.www.kingstudy.ObjectToMap | 4112 | this$0 | com.kingdomdong.www.kingstudy.ObjectToMap@70dea4e
         * class java.lang.String | 2 | name | XiaoXinXin
         * class java.lang.Integer | 4 | age | 20
         * class java.lang.String | 1 | id | 007
         * class com.kingdomdong.www.kingstudy.ObjectToMap | 4112 | this$0 | com.kingdomdong.www.kingstudy.ObjectToMap@70dea4e
         */
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field elem : fields) {
                elem.setAccessible(true);
                try {
                    System.out.println(elem.getGenericType() + " | " + elem.getModifiers() + " | "
                            + elem.getName() + " | " + elem.get(fieldTest));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            clazz = clazz.getSuperclass();
        }
    }

    public class SuperFieldTest {
        private String name;
        protected Integer age;
        public String id;
        public SuperFieldTest(String name, Integer age, String id) {
            super();
            this.name = name;
            this.age = age;
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Integer getAge() {
            return age;
        }
        public void setAge(Integer age) {
            this.age = age;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
    }

    public class FieldTest extends SuperFieldTest {
        public Double mathScore;

        public FieldTest(String name, Integer age, String id, Double mathScore) {
            super(name, age, id);
            this.mathScore = mathScore;
        }

        public Double getMathScore() {
            return mathScore;
        }

        public void setMathScore(Double mathScore) {
            this.mathScore = mathScore;
        }
    }
    
    public static void main(String[] args) {
        java.util.Date date = new java.util.Date();
        System.out.println(date.getTime());
    }
    
    
}
