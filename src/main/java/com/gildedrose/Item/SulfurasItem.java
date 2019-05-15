package com.gildedrose.Item;

class SulfurasItem extends SellableItem {

    SulfurasItem(Item item) {
        super(item);
    }

    public void updateItem() {
        setItemQuality(updateQuality());
        setItemSellIn(updateSellIn());
    }

    int updateQuality() {
        return getItemQuality();
    }

    int updateSellIn() {
        return 0;
    }
}
