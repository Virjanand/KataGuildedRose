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
        Item backstagePasses = createItem(10, 1);

        inn.updateInventory();

        assertEquals(3, backstagePasses.quality);
        assertEquals(9, backstagePasses.sellIn);
    }

    @Test
    public void sellIn5To0Days_qualityIncreasesBy3() {
        Item backstagePasses = createItem(5, 1);

        inn.updateInventory();

        assertEquals(4, backstagePasses.quality);
        assertEquals(4, backstagePasses.sellIn);
    }

    @Test
    public void concertPassed_quality0() {
        Item backstagePasses = createItem(0, 10);

        inn.updateInventory();

        assertEquals(0, backstagePasses.quality);
        assertEquals(-1, backstagePasses.sellIn);
    }

    private Item createItem(int sellBy, int quality) {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellBy, quality);
        items[0] = item;
        return item;
    }
}