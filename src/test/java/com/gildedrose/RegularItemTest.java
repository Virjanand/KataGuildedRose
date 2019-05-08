package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegularItemTest {

    private Item[] items;
    private GildedRose inn;

    @Before
    public void setUp() {
        items = new Item[1];
        inn = new GildedRose(items);
    }

    @Test
    public void afterOneDay_qualityAndSellByMinus1() {
        Item regularItem = createItem(1, 1);

        inn.updateInventory();

        assertEquals(0, regularItem.quality);
        assertEquals(0, regularItem.sellIn);
    }

    @Test
    public void sellDatePassed_QualityMinus2SellByMinus1() {
        Item regularItem = createItem(0, 1);

        inn.updateInventory();

        assertEquals(0, regularItem.quality);
        assertEquals(-1, regularItem.sellIn);
    }

    @Test
    public void qualityNeverNegative() {
        Item regularItem = createItem(1, 0);

        inn.updateInventory();

        assertEquals(0, regularItem.quality);
        assertEquals(0, regularItem.sellIn);
    }

    private Item createItem(int sellBy, int quality) {
        Item regularItem = new Item("Regular", sellBy, quality);
        items[0] = regularItem;
        return regularItem;
    }
}