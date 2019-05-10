package com.gildedrose.Item;

public class RegularItem extends SellableItem {

    protected RegularItem(Item item) {
        super(item);
    }

    public void updateItem() {
        setItemQuality(updateQuality());
        setItemSellIn(updateSellIn());
    }

    protected int updateQuality() {
        if (isSellInPassed())
            return calculateUpdatedQuality(-1);
        return calculateUpdatedQuality(-1);
    }
}
