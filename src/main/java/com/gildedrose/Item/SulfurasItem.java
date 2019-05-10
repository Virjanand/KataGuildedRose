package com.gildedrose.Item;

public class SulfurasItem extends SellableItem {

    SulfurasItem(Item item) {
        super(item);
    }

    public void updateItem() {
        setItemQuality(updateQuality());
        setItemSellIn(updateSellIn());
    }

    private int updateQuality() {
        return getItemQuality();
    }

    private int updateSellIn() {
        return 0;
    }
}
