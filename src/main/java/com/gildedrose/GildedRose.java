package com.gildedrose;

import com.gildedrose.Item.Item;
import com.gildedrose.Item.SellableItem;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateInventory() {
        Arrays.stream(items)
                .map(SellableItem::create)
                .forEach(SellableItem::updateItem);
    }
}