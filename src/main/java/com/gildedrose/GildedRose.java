package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateInventory() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            String name = item.name;
            int quality = item.quality;
            if (isRegularItem(name)) {
                quality = calculateUpdatedQuality(quality, -1);
            } else {
                quality = calculateUpdatedQuality(quality, 1);

                if (isBackstagePasses(name)) {
                    if (item.sellIn < 11) {
                        quality = calculateUpdatedQuality(quality, 1);
                    }

                    if (item.sellIn < 6) {
                        quality = calculateUpdatedQuality(quality, 1);
                    }
                }
            }

            updateSellIn(item);

            if (item.sellIn < 0) {
                if (!isAgedBrie(name)) {
                    if (!isBackstagePasses(name)) {
                        if (!isSulfuras(name)) {
                            if (quality > 0) {
                                quality = calculateUpdatedQuality(quality, -1);
                            }
                        }
                    } else {
                        quality = calculateUpdatedQuality(quality, -quality);
                    }
                } else {
                    if (quality < 50) {
                        quality = calculateUpdatedQuality(quality, 1);
                    }
                }
            }
            item.quality = quality;
        }
    }

    private void updateSellIn(Item item) {
        if (!isSulfuras(item.name)) {
            item.sellIn = item.sellIn - 1;
        }
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