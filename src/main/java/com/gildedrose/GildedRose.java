package com.gildedrose;

import com.gildedrose.Item.Item;
import com.gildedrose.Item.ItemCreator;
import com.gildedrose.Item.SellableItem;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateInventory() {
        Arrays.stream(items)
                .map(ItemCreator::create)
                .forEach(SellableItem::updateItem);
    }
}