package com.gildedrose.Item;

class AgedBrieItem extends SellableItem {

    AgedBrieItem(Item item) {
        super(item);
    }

    public void updateItem() {
        setItemQuality(updateQuality());
        setItemSellIn(updateSellIn());
    }

    int updateQuality() {
        if (isSellInPassed()) {
            return calculateUpdatedQuality(2);
        }
        return calculateUpdatedQuality(1);
    }
}
