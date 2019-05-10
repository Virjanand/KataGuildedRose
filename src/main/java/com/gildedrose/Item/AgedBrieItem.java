package com.gildedrose.Item;

public class AgedBrieItem extends SellableItem {

    protected AgedBrieItem(Item item) {
        super(item);
    }

    public void updateItem() {
        setItemQuality(updateQuality());
        setItemSellIn(updateSellIn());
    }

    protected int updateQuality() {
        int newQuality = getItemQuality();
        newQuality = calculateUpdatedQuality(newQuality, 1);
        if (isSellInPassed()) {
            newQuality = calculateUpdatedQuality(newQuality, 1);
        }
        return newQuality;
    }

    private int calculateUpdatedQuality(int quality, int improvement) {
        if (quality == MINQUALITY || quality >= MAXQUALITY)
            return quality;
        return quality + improvement;
    }
}
