package com.gildedrose.Item;

public class AgedBrieItem extends SellableItem {

    protected AgedBrieItem(Item item) {
        super(item);
    }

    public void updateItem() {
        setItemQuality(updateQuality());
        setItemSellIn(updateSellIn());
    }

    private int updateQuality() {
        int newQuality = getItemQuality();
        newQuality = calculateUpdatedQuality(newQuality, 1);
        if (isSellInPassed()) {
            newQuality = calculateUpdatedQuality(newQuality, 1);
        }
        return newQuality;
    }

    private int updateSellIn() {
        return getItemSellIn() - 1;
    }

    private int calculateUpdatedQuality(int quality, int improvement) {
        if (quality == 0 || quality >= 50)
            return quality;
        return quality + improvement;
    }
}
