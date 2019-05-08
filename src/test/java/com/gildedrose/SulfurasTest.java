package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SulfurasTest {

    private Item[] items;
    private GildedRose inn;

    @Before
    public void setUp() {
        items = new Item[1];
        inn = new GildedRose(items);
    }

    @Test
    public void sellIn10To5Days_qualityIncreasesBy2() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        items[0] = sulfuras;

        inn.updateQuality();

        assertEquals(80, sulfuras.quality);
        assertEquals(0, sulfuras.sellIn);
    }
}