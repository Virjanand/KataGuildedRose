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
        int newQuality = getItemQuality();
        newQuality = calculateUpdatedQuality(newQuality, 1);

        if (getItemSellIn() < 11) {
            newQuality = calculateUpdatedQuality(newQuality, 1);
        }

        if (getItemSellIn() < 6) {
            newQuality = calculateUpdatedQuality(newQuality, 1);
        }

        if (isSellInPassed()) {
            newQuality = 0;
        }
        return newQuality;
    }

    private int calculateUpdatedQuality(int quality, int improvement) {
        if (quality == MINQUALITY || quality >= MAXQUALITY)
            return quality;
        return quality + improvement;
    }
}
