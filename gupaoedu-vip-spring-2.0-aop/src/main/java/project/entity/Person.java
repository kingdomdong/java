package project.entity;

/**
 * person entity
 * @author kingdomdong
 * @since 2020-04-12 20:49:24
 * @version 1.0
 */
public class Person {

    private String name;
    private Integer age;

    public Person(String name, Integer i) {
        this.name = name;
        this.age = i;
    }

    public Person() {

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
