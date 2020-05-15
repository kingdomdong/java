package com.king.reflect.oracle.tutorial.classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Scanner;

import static java.lang.System.out;
import static java.util.Arrays.stream;

/**
 * class members
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-05-14 16:52:50
 */
public class ClassSpy {

    public static void main(String[] args) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                Class<?> aClass = Class.forName(scanner.next());
                out.format("Canonical Name:%n\t%s%n%n", aClass.getCanonicalName());

                Package aClassPackage = aClass.getPackage();
                out.format("Package:%n\t%s%n%n", aClassPackage != null ? aClassPackage.getName() : "\t-- No Package --");

                while (scanner.hasNext()) {
                    switch (ClassMember.valueOf(scanner.next())) {
                        case CONSTRUCTOR:
                            printMembers(aClass.getConstructors(), "Constructor");
                            break;
                        case FIELD:
                            printMembers(aClass.getFields(), "Fields");
                            break;
                        case METHOD:
                            printMembers(aClass.getMethods(), "Methods");
                            break;
                        case CLASS:
                            printClasses(aClass);
                            break;
                        case ALL:
                            printMembers(aClass.getConstructors(), "Constructors");
                            printMembers(aClass.getMethods(), "Methods");
                            printMembers(aClass.getFields(), "Fields");
                            printClasses(aClass);
                            break;
                        default:
                            assert false;
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printClasses(Class<?> aClass) {
        out.format("Classes:%n");
        Class<?>[] classes = aClass.getClasses();
        stream(classes).forEach(clazz -> out.format("\t%s%n", clazz.getCanonicalName()));
        if (classes.length == 0) {
            out.format("\t-- No member interfaces, classes, or enums %n");
        }
        out.format("%n");
    }

    private static void printMembers(Member[] members, String s) {
        out.format("%s:%n", s);
        stream(members).forEach(member -> {
            if (member instanceof Field) {
                out.format("\t%s%n", member.toString());
            } else if (member instanceof Constructor) {
                out.format("\t%s%n", ((Constructor<?>) member).toGenericString());
            } else if (member instanceof Method) {
                out.format("\t%s%n", ((Method) member).toGenericString());
            }
        });
    }
}

enum ClassMember {
    CONSTRUCTOR, FIELD, METHOD, CLASS, ALL
}
