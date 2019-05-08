package com.gildedrose;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RegularItemTest {

    @Test
    public void quality1SellBy1_After1Day_Quality0SellBy0() {
        Item regularItem = new Item("Regular", 1, 1);
        Item[] items = new Item[1];
        items[0] = regularItem;
        GildedRose inn = new GildedRose(items);
        inn.updateQuality();
        assertEquals(0, regularItem.quality);
    }
}