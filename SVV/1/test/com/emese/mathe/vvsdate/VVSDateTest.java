package com.emese.mathe.vvsdate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VVSDateTest {
    VVSDate jan1;

    @Before
    public void before() {
        jan1 = new VVSDate(1,1,2021);
    }

    @Test
    public void testSameDay() {
        assertEquals(0, jan1.getDays(jan1));
    }

    @Test
    public void testWholeYear() {
        VVSDate dec31 = new VVSDate(31, 12,2021);
        assertEquals(364, dec31.getDays(jan1));
        assertEquals(-364, jan1.getDays(dec31));
    }

    @Test
    public void test1Month() {
        VVSDate feb2 = new VVSDate(1, 2,2021);
        assertEquals(31, feb2.getDays(jan1));
        assertEquals(-31, jan1.getDays(feb2));
    }
}
