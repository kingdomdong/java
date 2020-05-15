package com.king.reflect.oracle.tutorial.classes;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;
import static java.util.Arrays.stream;

/**
 * docs.oracle.com/javase/tutorial/reflect/class/classModifiers.html
 *
 * <p>
 * java.security.Identity
 * Class:
 * java.security.Identity
 * <p>
 * Modifiers:
 * public abstract
 * <p>
 * Type parameters:
 * -- No Type Parameters --
 * <p>
 * Implemented interfaces:
 * interface java.security.Principal
 * interface java.io.Serializable
 * <p>
 * <p>
 * Inheritance Path:
 * java.lang.Object
 * <p>
 * Annotations:
 * "@java.lang.Deprecated()"
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-05-14 14:05:24
 */
public class ClassDeclarationSpy {

    public static void main(String[] args) {
        try {
            // input:
            // java.util.concurrent.ConcurrentNavigableMap
            Scanner scanner = new Scanner(System.in);
            Class<?> aClass = Class.forName(scanner.nextLine());
            printCanonicalName(aClass);
            printModifiers(aClass);
            printTypeParameters(aClass);
            printImplementedInterfaces(aClass);

            printAncestor(aClass, new ArrayList<>());
            printAnnotations(aClass);

            // production code should handle this exception more gracefully
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void printAnnotations(Class<?> aClass) {
        out.format("Annotations:%n");
        Annotation[] annotations = aClass.getAnnotations();
        if (annotations.length != 0) {
            stream(annotations).forEach(annotation -> out.format(" %s%n", annotation.toString()));
            out.format("%n");
        } else {
            out.format(" -- No Annotations --%n%n");
        }
    }

    private static void printAncestor(Class<?> aClass, List<Class<?>> classes) {
        Class<?> ancestor = aClass.getSuperclass();
        if (ancestor != null) {
            classes.add(ancestor);
            printAncestor(ancestor, classes);
            return;
        }
        out.format("Inheritance Path:%n");
        if (classes.size() != 0) {
            classes.forEach(elem -> out.format(" %s%n", elem.getCanonicalName()));
            out.format("%n");
        } else {
            out.format(" -- No Super Classes --%n%n");
        }
    }

    /**
     * possible values:
     * public protected private abstract static final transient volatile synchronized native strictfp interface
     * <p>
     * output:
     * public abstract interface
     *
     * @param aClass
     */
    private static void printModifiers(Class<?> aClass) {
        // getModifiers() - Return a string describing the access modifier flags in the specified modifier.
        int modifiers = aClass.getModifiers();
        out.format("Modifiers:%n %s%n%n", Modifier.toString(modifiers));
    }

    private static void printCanonicalName(Class<?> aClass) {
        // a local or anonymous class or an array whose component type does not have a canonical name, so returns null
        out.format("Class:%n %s%n%n", aClass.getCanonicalName());
    }

    private static void printTypeParameters(Class<?> aClass) {
        out.format("Type parameters:%n");
        TypeVariable<?>[] typeVariables = aClass.getTypeParameters();
        if (typeVariables.length != 0) {
            out.format(" ");
            stream(typeVariables).forEach(typeVariable -> out.format("%s ", typeVariable.getName()));
            out.format("%n%n");
        } else {
            out.format(" -- No Type Parameters --%n%n");
        }
    }

    /**
     * [Type]
     * Type is the common superinterface for all types in the Java programming language.
     * These include raw types, parameterized types, array types, type variables and primitive types.
     * <p>
     * [java.lang.Class<T> public reflect.Type[] getGenericInterfaces()]
     * Returns the Types representing the interfaces directly implemented by the class or interface represented by this object.
     */
    private static void printImplementedInterfaces(Class<?> aClass) {
        out.format("Implemented interfaces:%n");
        Type[] genericInterfaces = aClass.getGenericInterfaces();
        if (genericInterfaces.length != 0) {
            stream(genericInterfaces).forEach(genericType -> out.format(" %s%n", genericType.toString()));
            out.format("%n%n");
        } else {
            out.format(" -- No implemented Interfaces --%n%n");
        }
    }

}
