package com.gildedrose;

import com.gildedrose.Item.Item;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackStagePassesTest {

    @Test
    public void sellIn10To5Days_qualityIncreasesBy2() {
        Item backstagePasses = createItem(10, 1);
        GildedRose inn = new GildedRose(new Item[]{backstagePasses});

        inn.updateInventory();

        assertEquals(3, backstagePasses.quality);
        assertEquals(9, backstagePasses.sellIn);
    }

    @Test
    public void sellIn5To0Days_qualityIncreasesBy3() {
        Item backstagePasses = createItem(5, 1);
        GildedRose inn = new GildedRose(new Item[]{backstagePasses});

        inn.updateInventory();

        assertEquals(4, backstagePasses.quality);
        assertEquals(4, backstagePasses.sellIn);
    }

    @Test
    public void concertPassed_quality0() {
        Item backstagePasses = createItem(0, 10);
        GildedRose inn = new GildedRose(new Item[]{backstagePasses});

        inn.updateInventory();

        assertEquals(0, backstagePasses.quality);
        assertEquals(-1, backstagePasses.sellIn);
    }

    private Item createItem(int sellBy, int quality) {
        return new Item("Backstage passes to a TAFKAL80ETC concert", sellBy, quality);
    }
}