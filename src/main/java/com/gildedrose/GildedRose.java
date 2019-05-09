package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateInventory() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        item.quality = updateQuality(item);
        item.sellIn = updateSellIn(item);
    }

    private int updateQuality(Item item) {
        String name = item.name;
        int newQuality = item.quality;
        if (isRegularItem(name)) {
            newQuality = calculateUpdatedQuality(newQuality, -1);
            if (isSellInPassed(item))
                newQuality = calculateUpdatedQuality(newQuality, -1);
        }
        if (isAgedBrie(name)) {
            newQuality = calculateUpdatedQuality(newQuality, 1);
            if (isSellInPassed(item)) {
                newQuality = calculateUpdatedQuality(newQuality, 1);
            }
        }
        if (isBackstagePasses(name)) {
            newQuality = calculateUpdatedQuality(newQuality, 1);

            if (item.sellIn < 11) {
                newQuality = calculateUpdatedQuality(newQuality, 1);
            }

            if (item.sellIn < 6) {
                newQuality = calculateUpdatedQuality(newQuality, 1);
            }

            if (isSellInPassed(item)) {
                newQuality = 0;
            }
        }
        return newQuality;
    }

    private boolean isSellInPassed(Item item) {
        return item.sellIn <= 0;
    }

    private int updateSellIn(Item item) {
        if (isSulfuras(item.name))
            return 0;
        return item.sellIn - 1;
    }

    private int calculateUpdatedQuality(int quality, int improvement) {
        if (quality == 0 || quality >= 50)
            return quality;
        return quality + improvement;
    }

    private boolean isRegularItem(String name) {
        return !isAgedBrie(name)
                && !isBackstagePasses(name)
                && !isSulfuras((name));
    }

    private boolean isSulfuras(String name) {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePasses(String name) {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(String name) {
        return name.equals("Aged Brie");
    }
}