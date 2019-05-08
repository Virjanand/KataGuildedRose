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

    private Item createItem(int sellBy, int quality) {
        Item regularItem = new Item("Backstage passes to a TAFKAL80ETC concert", sellBy, quality);
        items[0] = regularItem;
        return regularItem;
    }
}