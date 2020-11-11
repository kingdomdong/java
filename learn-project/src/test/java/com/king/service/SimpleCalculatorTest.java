package com.king.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class SimpleCalculatorTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    HelperService helperService;

    @Test
    void should_calculate_product_of_two_results() {
        // given
        SimpleCalculator calculator = new SimpleCalculator(new IntNumber(10), new IntNumber(5));
        when(helperService.generateNumberB(new IntNumber(10))).thenReturn(new IntNumber(5));
        // when
        int product = calculator.justDoIt(new IntNumber(10));
        // then
        assertThat(product).isEqualTo(calculator.add() * calculator.reduce());
    }

}