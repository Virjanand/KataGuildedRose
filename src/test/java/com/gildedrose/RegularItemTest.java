package com.gildedrose;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RegularItemTest {

    @Test
    public void afterOneDay_qualityAndSellByMinus1() {
        Item regularItem = new Item("Regular", 1, 1);
        GildedRose inn = new GildedRose(new Item[]{regularItem});

        inn.updateQuality();

        assertEquals(0, regularItem.quality);
        assertEquals(0, regularItem.sellIn);
    }

    @Test
    public void sellDatePassed_QualityMinus2SellByMinus1() {
        Item regularItem = new Item("Regular", 0, 1);
        GildedRose inn = new GildedRose(new Item[]{regularItem});

        inn.updateQuality();

        assertEquals(0, regularItem.quality);
        assertEquals(-1, regularItem.sellIn);
    }

    @Test
    public void qualityNeverNegative() {
        Item regularItem = new Item("Regular", 1, 0);
        GildedRose inn = new GildedRose(new Item[]{regularItem});

        inn.updateQuality();

        assertEquals(0, regularItem.quality);
        assertEquals(0, regularItem.sellIn);
    }
}