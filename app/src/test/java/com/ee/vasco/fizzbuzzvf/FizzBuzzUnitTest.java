package com.ee.vasco.fizzbuzzvf;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class FizzBuzzUnitTest {
    @Test
    public void step1_isCorrect() throws Exception {
        assertEquals("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz", RunRangeFF.step1(1, 20, false));
        assertEquals("7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16", RunRangeFF.step1(7, 16, false));
        assertEquals("fizz 334 buzz fizz 337 338 fizz buzz 341 fizz 343 344 fizzbuzz", RunRangeFF.step1(333, 345, false));
    }

    @Test
    public void step2_isCorrect() throws Exception {
        assertEquals("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz", RunRangeFF.step2(1, 20, false));
        assertEquals("7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16", RunRangeFF.step2(7, 16, false));
        assertEquals("lucky lucky lucky lucky lucky lucky lucky lucky lucky lucky lucky lucky lucky", RunRangeFF.step2(333, 345, false));

    }

    @Test
    public void step1Report_isCorrect() throws Exception {
        assertEquals("1 2 fizz 4 buzz\n" +
                "fizz: 1\n" +
                "buzz: 1\n" +
                "fizzbuzz: 0\n" +
                "integer: 3", RunRangeFF.step1(1, 5, true));
        assertEquals("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz\n" +
                "fizz: 5\n" +
                "buzz: 3\n" +
                "fizzbuzz: 1\n" +
                "integer: 11", RunRangeFF.step1(1, 20, true));
    }

    @Test
    public void step2Report_isCorrect() throws Exception {
        assertEquals("1 2 lucky 4 buzz\n" +
                "fizz: 0\n" +
                "buzz: 1\n" +
                "fizzbuzz: 0\n" +
                "lucky: 1\n" +
                "integer: 3", RunRangeFF.step2(1, 5, true));
        assertEquals("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz\n" +
                "fizz: 4\n" +
                "buzz: 3\n" +
                "fizzbuzz: 1\n" +
                "lucky: 2\n" +
                "integer: 10", RunRangeFF.step2(1, 20, true));
    }



}