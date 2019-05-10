package com.gildedrose;

import com.gildedrose.Item.Item;
import com.gildedrose.Item.SellableItem;

import java.util.Arrays;
import java.util.stream.Stream;

class GildedRose {
    Item[] items;
    private Stream<SellableItem> sellableItems;

    GildedRose(Item[] items) {
        this.items = items;
        sellableItems = Arrays.stream(items).map(SellableItem::create);
    }

    void updateInventory() {
        sellableItems.forEach(SellableItem::updateItem);
    }
}