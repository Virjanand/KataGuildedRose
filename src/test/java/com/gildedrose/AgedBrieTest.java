package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AgedBrieTest {

    private Item[] items;
    private GildedRose inn;

    @Before
    public void setUp() {
        items = new Item[1];
        inn = new GildedRose(items);
    }

    @Test
    public void afterOneDay_qualityIncreasesAndSellByMinus1() {
        Item regularItem = createItem(1, 1);

        inn.updateQuality();

        assertEquals(2, regularItem.quality);
        assertEquals(0, regularItem.sellIn);
    }

    @Test
    public void maximumQuality50() {
        Item regularItem = createItem(1, 50);

        inn.updateQuality();

        assertEquals(50, regularItem.quality);
        assertEquals(0, regularItem.sellIn);
    }

    private Item createItem(int sellBy, int quality) {
        Item regularItem = new Item("Aged Brie", sellBy, quality);
        items[0] = regularItem;
        return regularItem;
    }
}