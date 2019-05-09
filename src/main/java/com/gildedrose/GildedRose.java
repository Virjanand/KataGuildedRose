package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateInventory() {
        for (int i = 0; i < items.length; i++) {
            updateItem(items[i]);
        }
    }

    private void updateItem(Item item) {
        item.quality = updateQuality(item);
        item.sellIn = updateSellIn(item);
    }

    private int updateQuality(Item item) {
        String name = item.name;
        int quality = item.quality;
        if (isRegularItem(name)) {
            quality = calculateUpdatedQuality(quality, -1);
            if (item.sellIn <= 0)
                quality = calculateUpdatedQuality(quality, -1);
        }
        if (isAgedBrie(name)) {
            quality = calculateUpdatedQuality(quality, 1);
            if (item.sellIn <= 0) {
                quality = calculateUpdatedQuality(quality, 1);
            }
        }
        if (isBackstagePasses(name)) {
            quality = calculateUpdatedQuality(quality, 1);

            if (item.sellIn < 11) {
                quality = calculateUpdatedQuality(quality, 1);
            }

            if (item.sellIn < 6) {
                quality = calculateUpdatedQuality(quality, 1);
            }

            if (item.sellIn <= 0) {
                quality = 0;
            }
        }
        return quality;
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