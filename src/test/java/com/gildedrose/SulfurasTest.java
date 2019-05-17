package com.gildedrose;

import com.gildedrose.item.Item;
import org.junit.Test;

import static org.junit.Assert.*;

public class SulfurasTest {

    @Test
    public void sellIn10To5Days_qualityIncreasesBy2() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        GildedRose inn = new GildedRose(new Item[]{sulfuras});

        inn.updateInventory();

        assertEquals(80, sulfuras.quality);
        assertEquals(0, sulfuras.sellIn);
    }
}