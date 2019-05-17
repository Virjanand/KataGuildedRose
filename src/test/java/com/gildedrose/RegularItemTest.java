package com.gildedrose;

import com.gildedrose.item.Item;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegularItemTest {

    @Test
    public void afterOneDay_qualityAndSellByMinus1() {
        Item regularItem = createItem(1, 1);
        GildedRose inn = new GildedRose(new Item[]{regularItem});

        inn.updateInventory();

        assertEquals(0, regularItem.quality);
        assertEquals(0, regularItem.sellIn);
    }

    @Test
    public void sellDatePassed_QualityMinus2SellByMinus1() {
        Item regularItem = createItem(0, 3);
        GildedRose inn = new GildedRose(new Item[]{regularItem});

        inn.updateInventory();

        assertEquals(1, regularItem.quality);
        assertEquals(-1, regularItem.sellIn);
    }

    @Test
    public void qualityNeverNegative() {
        Item regularItem = createItem(1, 0);
        Item regularItem2 = createItem(0, 1);
        GildedRose inn = new GildedRose(new Item[]{regularItem, regularItem2});

        inn.updateInventory();

        assertEquals(0, regularItem.quality);
        assertEquals(0, regularItem.sellIn);
        assertEquals(0, regularItem2.quality);
        assertEquals(-1, regularItem2.sellIn);
    }

    private Item createItem(int sellBy, int quality) {
        return new Item("Regular", sellBy, quality);
    }
}