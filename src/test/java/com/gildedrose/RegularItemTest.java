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
}