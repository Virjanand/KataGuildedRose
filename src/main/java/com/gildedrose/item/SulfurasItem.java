package com.gildedrose.item;

class SulfurasItem extends SellableItem {

    SulfurasItem(Item item) {
        super(item);
    }

    int updateQuality() {
        return getItemQuality();
    }

    @Override
    int updateSellIn() {
        return 0;
    }
}
