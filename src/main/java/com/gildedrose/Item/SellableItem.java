package com.gildedrose.Item;

public class SellableItem {
    private Item item;

    public SellableItem(Item item) {
        this.item = item;
    }

    protected int getItemQuality() {
        return item.quality;
    }

    protected void setItemQuality(int quality) {
        this.item.quality = quality;
    }

    protected void setItemSellIn(int days) {
        this.item.sellIn = days;
    }

    public void updateItem() {
        setItemQuality(updateQuality());
        setItemSellIn(updateSellIn());
    }

    private int updateQuality() {
        int newQuality = item.quality;
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

            if (item.sellIn < 11) {
                newQuality = calculateUpdatedQuality(newQuality, 1);
            }

            if (item.sellIn < 6) {
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
        return item.sellIn - 1;
    }

    protected boolean isSellInPassed() {
        return item.sellIn <= 0;
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
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePasses() {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie() {
        return item.name.equals("Aged Brie");
    }
}
