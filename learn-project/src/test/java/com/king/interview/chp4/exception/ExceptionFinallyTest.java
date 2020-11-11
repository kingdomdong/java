package com.king.interview.chp4.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Finally sequence in exception
 *
 * @author Yum
 * @version 1.0
 * @since 2020-09-13 14:48:21
 */
class ExceptionFinallyTest {

    public static int testPrimitiveVariableFinally() {
        int result;
        try {
            result = 2;
            return result;
        } catch (Exception e) {
            return 0;
        } finally {
            result = 3; // the value 3 to 'result' is never used
            System.out.println("execute primitive variable in finally test");
        }

    }

    private static StringBuffer testReferencedVariableFinally() {
        StringBuffer stringBuffer = new StringBuffer("Hello");
        try {
            return stringBuffer;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stringBuffer.append(" World");
            System.out.println("execute referenced variable in finally test");
        }
        return stringBuffer;
    }

    @Test
    void should_primitive_type_changed_in_finally_block() {
        assertEquals(testPrimitiveVariableFinally(), 2);
    }

    @Test
    void should_referenced_variable_changed_in_finally_block() {
        assertEquals(testReferencedVariableFinally().toString(), "Hello World");
    }

}
