package com.gildedrose.item;

class RegularItem extends SellableItem {

    RegularItem(Item item) {
        super(item);
    }

    int updateQuality() {
        if (isSellInPassed())
            return calculateUpdatedQuality(-2);
        return calculateUpdatedQuality(-1);
    }
}
