package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackStagePassesTest {

    private Item[] items;
    private GildedRose inn;

    @Before
    public void setUp() {
        items = new Item[1];
        inn = new GildedRose(items);
    }

    @Test
    public void sellIn10To5Days_qualityIncreasesBy2() {
        Item regularItem = createItem(10, 1);

        inn.updateQuality();

        assertEquals(3, regularItem.quality);
        assertEquals(9, regularItem.sellIn);
    }

    @Test
    public void sellIn5To0Days_qualityIncreasesBy3() {
        Item regularItem = createItem(5, 1);

        inn.updateQuality();

        assertEquals(4, regularItem.quality);
        assertEquals(4, regularItem.sellIn);
    }

    @Test
    public void concertPassed_quality0() {
        Item regularItem = createItem(0, 10);

        inn.updateQuality();

        assertEquals(0, regularItem.quality);
        assertEquals(-1, regularItem.sellIn);
    }

    private Item createItem(int sellBy, int quality) {
        Item regularItem = new Item("Backstage passes to a TAFKAL80ETC concert", sellBy, quality);
        items[0] = regularItem;
        return regularItem;
    }
}