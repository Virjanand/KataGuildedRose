package com.gildedrose.Item;

public class SellableItem {
    private Item item;

    public SellableItem(Item item) {
        this.item = item;
    }

    private String getName() {
        return item.name;
    }

    int getItemQuality() {
        return item.quality;
    }

    void setItemQuality(int quality) {
        this.item.quality = quality;
    }

    int getItemSellIn() {
        return item.sellIn;
    }

    void setItemSellIn(int days) {
        this.item.sellIn = days;
    }

    public void updateItem() {
        setItemQuality(updateQuality());
        setItemSellIn(updateSellIn());
    }

    private int updateQuality() {
        int newQuality = getItemQuality();
        if (isRegularItem()) {
            newQuality = calculateUpdatedQuality(newQuality, -1);
            if (isSellInPassed())
                newQuality = calculateUpdatedQuality(newQuality, -1);
        }
        if (isAgedBrie()) {
            newQuality = calculateUpdatedQuality(newQuality, 1);
            if (isSellInPassed()) {
                newQuality = calculateUpdatedQuality(newQuality, 1);
            }
        }
        if (isBackstagePasses()) {
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
        }
        return newQuality;
    }

    private int updateSellIn() {
        if (isSulfuras())
            return 0;
        return getItemSellIn() - 1;
    }

    boolean isSellInPassed() {
        return getItemSellIn() <= 0;
    }

    private int calculateUpdatedQuality(int quality, int improvement) {
        if (quality == 0 || quality >= 50)
            return quality;
        return quality + improvement;
    }

    private boolean isRegularItem() {
        return !isAgedBrie()
                && !isBackstagePasses()
                && !isSulfuras();
    }

    private boolean isSulfuras() {
        return getName().equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePasses() {
        return getName().equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie() {
        return getName().equals("Aged Brie");
    }
}
