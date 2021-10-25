package com.emese.mathe.promotion;

import come.emese.mathe.promotion.Promotion;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

import static org.junit.Assert.*;

public class PromotionTest {

    @Test
    public void testFalseActiveWithWeekDayOtherTwoDay() {
        LocalDate localDate = LocalDate.now();

        LocalDate other1 = localDate.plusDays(1);
        LocalDate other2 = localDate.plusDays(2);

        String weekDay= other1.getDayOfWeek().getValue() + "," + other2.getDayOfWeek().getValue();

        Promotion promotion = new Promotion(null, null, weekDay, null, null);
        assertFalse(promotion.isActive());
    }

    @Test
    public void testTrueActiveWithWeekDay5And6() {
        LocalDate localDate = LocalDate.now();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        Promotion promotion = new Promotion(null, null, dayOfWeek.getValue() + "", null, null);
        assertTrue(promotion.isActive());
    }


    @Test
    public void testTrueActiveWithAllWeekDays() {
        Promotion promotion = new Promotion(null, null, "1,2,3,4,5,6,7", null, null);
        assertTrue(promotion.isActive());
    }

    @Test
    public void testFalseWithStartHourTrue() {
        LocalTime time = LocalTime.now();
        LocalTime start = time.minusHours(1);

        LocalDate date = LocalDate.now();

        Promotion promotion = new Promotion(null, null, "1,2,3,4,5,6,7", start.toString(), null);
        assertFalse(promotion.isActive());
    }

    @Test
    public void testTrueStartHour() {
        LocalTime time = LocalTime.now();
        LocalTime start = time.minusHours(1);
        Promotion promotion = new Promotion(null, null, "1,2,3,4,5,6,7", start.toString(), null);
        assertTrue(promotion.isActive());
    }

    @Test
    public void testFalseStartTime() {
        LocalTime time = LocalTime.now();
        LocalTime start = time.plusHours(1);
        Promotion promotion = new Promotion(null, null, "1,2,3,4,5,6,7", start.toString(), null);
        assertFalse(promotion.isActive());
    }

    @Test
    public void testTrueEndHour() {
        LocalTime time = LocalTime.now();
        LocalTime end = time.plusHours(1);
        Promotion promotion = new Promotion(null, null, "1,2,3,4,5,6,7", null, end.toString());
        assertTrue(promotion.isActive());
    }

    @Test
    public void testFalseEndTime() {
        LocalTime time = LocalTime.now();
        LocalTime end = time.minusHours(1);
        Promotion promotion = new Promotion(null, null, "1,2,3,4,5,6,7", null, end.toString());
        assertFalse(promotion.isActive());
    }

    @Test
    public void testTrueEndCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, calendar.DECEMBER, 1);
        Promotion promotion = new Promotion(null, calendar, "1,2,3,4,5,6,7", null, null);
        assertTrue(promotion.isActive());
    }

    @Test
    public void testFalseEndCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, calendar.JANUARY, 1);
        Promotion promotion = new Promotion(null, calendar, "1,2,3,4,5,6,7", null, null);
        assertFalse(promotion.isActive());
    }

    @Test
    public void testTrueStartCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, calendar.JANUARY, 1);
        Promotion promotion = new Promotion(calendar, null, "1,2,3,4,5,6,7", null, null);
        assertTrue(promotion.isActive());
    }

    @Test
    public void testFalseStartCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, calendar.DECEMBER, 1);
        Promotion promotion = new Promotion(calendar, null, "1,2,3,4,5,6,7", null, null);
        assertFalse(promotion.isActive());
    }
}
