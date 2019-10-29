package com.king.bean.clone;

import java.io.Serializable;

public class Inner implements Serializable {

    private static final long serialVersionUID = 872390113109L; //最好是显式声明ID

    private String name = "";
    static Integer ID; // not cloned In ObjectOutputSteam

    public Inner(String name, Integer id) {
        this.name = name;
        ID = id;
    }

    public String getName() {
        return name;
    }

    public static Integer getId() {
        return ID;
    }

    @Override
    public String toString() {
        return "Inner的name值为：" + name;
    }

}