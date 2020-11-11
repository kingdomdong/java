package com.king.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

/**
 * Mock vs. Spy
 *
 * @author Yum
 * @version 1.0
 * @since 2020-11-10 15:05:01
 */
class MockSpyTest {

    @Mock
    List<String> mockList;

    @Spy
    List<String> spyList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testMockList() {
        // by default, calling the methods of mock object will do nothing
        mockList.add("test");

        verify(mockList).add("test");
        assertEquals(0, mockList.size());
        assertNull(mockList.get(0));
    }

    @Test
    void testSpyList() {
        // by default, calling the real method when not stub
        spyList.add("test");

        verify(spyList).add("test");
        assertThat(spyList.size()).isEqualTo(1);
        assertEquals("test", spyList.get(0));
    }

    @Test
    void testSpyStubbing() {
        spyList.add("test");
        //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
        // when(spyList.get(0)).thenReturn("foo");

        //You have to use doReturn() for stubbing
        doReturn("foo").when(spyList).get(0);

        // impossible: real method List::add is called
        // when(spyList.add("test")).thenReturn(true);

        // You also should use doReturn() for stubbing
        doReturn(true).when(spyList).add(any(String.class));

        assertThat(spyList.size()).isEqualTo(1);
        assertEquals("foo", spyList.get(0));
    }

    @Test
    void testMockWithStub() {
        // try stubbing a method
        String expected = "Mock 100";
        when(mockList.get(0)).thenReturn(expected);

        assertEquals(expected, mockList.get(0));
    }

}
