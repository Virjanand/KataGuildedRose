package com.gildedrose.item;

class AgedBrieItem extends SellableItem {

    AgedBrieItem(Item item) {
        super(item);
    }

    int updateQuality() {
        if (isSellInPassed()) {
            return calculateUpdatedQuality(2);
        }
        return calculateUpdatedQuality(1);
    }
}
