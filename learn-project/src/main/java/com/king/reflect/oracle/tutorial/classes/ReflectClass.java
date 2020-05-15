package com.king.reflect.oracle.tutorial.classes;

import javax.swing.*;

import static java.lang.System.out;
import static java.util.Arrays.stream;

/**
 * java.lang.Class
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-05-14 12:35:36
 */
public class ReflectClass {

    public static void main(String[] args) throws ClassNotFoundException {
        getDoubleClass();
        getJButtonSuperClass();
        getCharacterClasses();
        getCharacterDeclaredClasses();
    }

    private static void getDoubleClass() throws ClassNotFoundException {
        // java.lang.Double
        Class<?> aClass = Class.forName("java.lang.Double");
        Class<Double> doubleClass = Double.class;
        // double.class is identical to Double.TYPE
        // double
        Class<Double> doubleClass1 = double.class;
        Class<Double> doubleClass2 = Double.TYPE;

        out.println(aClass.getName());
        out.println(doubleClass.getName());
        out.println(doubleClass1.getName());
        out.println(doubleClass2.getName());
    }

    /**
     * java.lang.Character$CharacterCache
     * java.lang.Character$UnicodeScript
     * java.lang.Character$UnicodeBlock
     * java.lang.Character$Subset
     */
    private static void getJButtonSuperClass() {
        // Returns the Class representing the superclass of the entity (class, interface, primitive type or void) represented by this Class, or else null
        // If this object represents an array class then the Class object representing the Object class is returned.
        Class<? super JButton> jButtonSuperclass = JButton.class.getSuperclass();
        out.println("JButton's super class name is " + jButtonSuperclass.getName());
    }

    /**
     * java.lang.Character$UnicodeScript
     * java.lang.Character$UnicodeBlock
     * java.lang.Character$Subset
     */
    private static void getCharacterClasses() {
        Class<?>[] classes = Character.class.getClasses();
        out.println("Character's classes names are ");
        stream(classes).map(Class::getName).forEach(out::println);
    }

    private static void getCharacterDeclaredClasses() {
        Class<?>[] declaredClasses = Character.class.getDeclaredClasses();
        out.println("Character's declared classes names are ");
        stream(declaredClasses).map(Class::getName).forEach(out::println);
    }

}
