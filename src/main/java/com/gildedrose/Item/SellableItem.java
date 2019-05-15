package com.gildedrose.Item;

public abstract class SellableItem {
    private Item item;
    private static final int MAXQUALITY = 50;
    private static final int MINQUALITY = 0;

    public static SellableItem create(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieItem(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassesItem(item);
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasItem(item);
            default:
                return new RegularItem(item);
        }
    }

    protected SellableItem(Item item) {

        this.item = item;
    }

    public void updateItem() {
        setItemQuality(updateQuality());
        setItemSellIn(updateSellIn());
    }

    abstract int updateQuality();

    int updateSellIn() {
        return getItemSellIn() - 1;
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

    boolean isSellInPassed() {
        return getItemSellIn() <= 0;
    }

    int calculateUpdatedQuality(int improvement) {
        return limitQuality(getItemQuality() + improvement);
    }

    private int limitQuality(int quality) {
        return (quality > MAXQUALITY) ? MAXQUALITY : (quality < MINQUALITY ? MINQUALITY : quality);
    }
}
