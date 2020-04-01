package com.king.ch6.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeSortTest {

    Employee[] staff = new Employee[3];
    Employee[] staffOrdered = new Employee[3];

    @BeforeEach
    void setUp() {
//        MockitoAnnotations.initMocks(this);
        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);

        staffOrdered[0] = staff[0];
        staffOrdered[1] = staff[2];
        staffOrdered[2] = staff[1];
    }

    @Test
    public void isMatchSortedListWhenSort() {
        Arrays.sort(staff);
        assertThat(staff).hasSize(3).containsSequence(staffOrdered);
    }

}
