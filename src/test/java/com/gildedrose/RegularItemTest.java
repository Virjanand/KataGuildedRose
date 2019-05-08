package com.gildedrose;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RegularItemTest {

    @Test
    public void quality1SellBy1_After1Day_Quality0SellBy0() {
        Item regularItem = new Item("Regular", 1, 1);
        GildedRose inn = new GildedRose(new Item[]{regularItem});

        inn.updateQuality();

        assertEquals(0, regularItem.quality);
        assertEquals(0, regularItem.sellIn);
    }

    @Test
    public void quality2SellBy0_After1Day_Quality0SellByMinus1() {
        Item regularItem = new Item("Regular", 0, 1);
        GildedRose inn = new GildedRose(new Item[]{regularItem});

        inn.updateQuality();

        assertEquals(0, regularItem.quality);
        assertEquals(-1, regularItem.sellIn);
    }

    @Test
    public void quality0SellBy1_After1Day_Quality0SellBy0() {
        Item regularItem = new Item("Regular", 1, 0);
        GildedRose inn = new GildedRose(new Item[]{regularItem});

        inn.updateQuality();

        assertEquals(0, regularItem.quality);
        assertEquals(0, regularItem.sellIn);
    }
}