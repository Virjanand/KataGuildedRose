package com.gildedrose.Item;

public class SulfurasItem extends SellableItem {

    SulfurasItem(Item item) {
        super(item);
    }

    public void updateItem() {
        setItemQuality(updateQuality());
        setItemSellIn(updateSellIn());
    }

    protected int updateQuality() {
        return getItemQuality();
    }

    protected int updateSellIn() {
        return 0;
    }
}
