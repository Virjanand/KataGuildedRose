package com.gildedrose.Item;

public class SellableItem {
    private Item item;

    public static SellableItem create(Item item) {
        if (item.name.equals("Aged Brie"))
            return new AgedBrieItem(item);
        if (item.name.equals(("Backstage passes to a TAFKAL80ETC concert")))
            return new BackstagePassesItem(item);
        if (item.name.equals("Sulfuras, Hand of Ragnaros"))
            return new SellableItem(item);
        return new RegularItem(item);
    }

    protected SellableItem(Item item) {
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
        setItemQuality(getItemQuality());
        setItemSellIn(updateSellIn());
    }

    private int updateSellIn() {
        if (isSulfuras())
            return 0;
        return getItemSellIn() - 1;
    }

    boolean isSellInPassed() {
        return getItemSellIn() <= 0;
    }

    private boolean isSulfuras() {
        return getName().equals("Sulfuras, Hand of Ragnaros");
    }
}
