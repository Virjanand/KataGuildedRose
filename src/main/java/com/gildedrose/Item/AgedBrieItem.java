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
        if (isSellInPassed()) {
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
