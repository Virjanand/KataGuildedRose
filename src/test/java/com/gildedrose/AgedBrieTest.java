package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class AgedBrieTest {

    @Test
    public void afterOneDay_qualityIncreasesAndSellByMinus1() {
        Item agedBrie = createItem(1, 1);
        GildedRose inn = new GildedRose(new Item[]{agedBrie});

        inn.updateInventory();

        assertEquals(2, agedBrie.quality);
        assertEquals(0, agedBrie.sellIn);
    }

    @Test
    public void maximumQuality50() {
        Item agedBrie = createItem(1, 50);
        GildedRose inn = new GildedRose(new Item[]{agedBrie});

        inn.updateInventory();

        assertEquals(50, agedBrie.quality);
        assertEquals(0, agedBrie.sellIn);
    }

    private Item createItem(int sellBy, int quality) {
        return new Item("Aged Brie", sellBy, quality);
    }
}