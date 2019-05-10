package com.gildedrose.Item;

public class BackstagePassesItem extends SellableItem {

    BackstagePassesItem(Item item) {
        super(item);
    }

    public void updateItem() {
        setItemQuality(updateQuality());
        setItemSellIn(updateSellIn());
    }

    protected int updateQuality() {
        if (isSellInPassed()) {
            return 0;
        }

        if (getItemSellIn() < 6) {
            return calculateUpdatedQuality(3);
        }

        if (getItemSellIn() < 11) {
            return calculateUpdatedQuality(2);
        }

        return calculateUpdatedQuality(1);
    }

    private int calculateUpdatedQuality(int improvement) {
        if (getItemQuality() == MINQUALITY || getItemQuality() >= MAXQUALITY)
            return getItemQuality();
        return getItemQuality() + improvement;
    }
}
