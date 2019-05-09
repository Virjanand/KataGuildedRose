package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
    Item[] items;
    private List<SellableItem> sellableItems = new ArrayList<>();

    GildedRose(Item[] items) {
        this.items = items;
        for (Item item : items) {
            sellableItems.add(new SellableItem(item));
        }
    }

    void updateInventory() {
        for (SellableItem sellableItem : sellableItems) {
            sellableItem.updateItem();
        }
    }
}