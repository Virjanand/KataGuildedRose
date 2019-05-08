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
        Item agedBrie = createItem(1, 1);

        inn.updateInventory();

        assertEquals(2, agedBrie.quality);
        assertEquals(0, agedBrie.sellIn);
    }

    @Test
    public void maximumQuality50() {
        Item agedBrie = createItem(1, 50);

        inn.updateInventory();

        assertEquals(50, agedBrie.quality);
        assertEquals(0, agedBrie.sellIn);
    }

    private Item createItem(int sellBy, int quality) {
        Item item = new Item("Aged Brie", sellBy, quality);
        items[0] = item;
        return item;
    }
}