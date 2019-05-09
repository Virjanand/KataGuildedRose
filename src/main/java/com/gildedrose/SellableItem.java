package com.gildedrose;

class SellableItem {
    private Item item;

    SellableItem(Item item) {
        this.item = item;
    }

    void updateItem() {
        item.quality = updateQuality();
        item.sellIn = updateSellIn();
    }

    private int updateQuality() {
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

    private int updateSellIn() {
        if (isSulfuras(item.name))
            return 0;
        return item.sellIn - 1;
    }

    private boolean isSellInPassed(Item item) {
        return item.sellIn <= 0;
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
