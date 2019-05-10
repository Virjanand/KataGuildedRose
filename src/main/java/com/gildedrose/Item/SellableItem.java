package com.gildedrose.Item;

public abstract class SellableItem {
    private Item item;

    public static SellableItem create(Item item) {
        if (item.name.equals("Aged Brie"))
            return new AgedBrieItem(item);
        if (item.name.equals(("Backstage passes to a TAFKAL80ETC concert")))
            return new BackstagePassesItem(item);
        if (item.name.equals("Sulfuras, Hand of Ragnaros"))
            return new SulfurasItem(item);
        return new RegularItem(item);
    }

    protected SellableItem(Item item) {
        this.item = item;
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

    protected abstract int updateQuality();

    protected int updateSellIn() {
        return getItemSellIn() - 1;
    }

    boolean isSellInPassed() {
        return getItemSellIn() <= 0;
    }
}
