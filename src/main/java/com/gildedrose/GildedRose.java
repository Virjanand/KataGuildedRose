package com.gildedrose;

import com.gildedrose.item.Item;
import com.gildedrose.item.ItemCreator;
import com.gildedrose.item.SellableItem;

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