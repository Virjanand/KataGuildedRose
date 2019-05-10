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
        int newQuality = getItemQuality();
        newQuality = calculateUpdatedQuality(newQuality, -1);
        if (isSellInPassed())
            newQuality = calculateUpdatedQuality(newQuality, -1);
        return newQuality;
    }

    private int calculateUpdatedQuality(int quality, int improvement) {
        if (quality == MINQUALITY)
            return quality;
        return quality + improvement;
    }
}
