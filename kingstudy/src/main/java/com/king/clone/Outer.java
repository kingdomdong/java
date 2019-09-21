package com.king.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Outer implements Serializable {

    private static final long serialVersionUID = 369285298572941L;  //最好是显式声明ID

    private Inner inner; //Description:[深度复制方法,需要对象及对象所有的对象属性都实现序列化]

    public Outer(Inner inner) {
        this.inner = inner;
    }

    public Outer myclone() {
        Outer outer = null;
        try {
            // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            // 将流序列化成对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            outer = (Outer) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return outer;
    }

    @Override
    public String toString() {
        return "[Inner.name:" + inner.getName() + " Inner.Id:" + Inner.getId() + "]";
    }

    public Inner getInner() {
        return inner;
    }

    public void setInner(Inner inner) {
        this.inner = inner;
    }

}