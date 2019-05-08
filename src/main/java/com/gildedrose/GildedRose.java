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
            if (!isAgedBrie(name)
                    && !isBackstagePasses(name)
                    && !isSulfuras((name))) {
                if (item.quality > 0) {
                        item.quality = calculateUpdatedQuality(item, -1);
                }
            } else {
                if (item.quality < 50) {
                    item.quality = calculateUpdatedQuality(item, 1);

                    if (isBackstagePasses(name)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = calculateUpdatedQuality(item, 1);
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = calculateUpdatedQuality(item, 1);
                            }
                        }
                    }
                }
            }

            if (!isSulfuras(name)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie(name)) {
                    if (!isBackstagePasses(name)) {
                        if (item.quality > 0) {
                            if (!isSulfuras(name)) {
                                item.quality = calculateUpdatedQuality(item, -1);
                            }
                        }
                    } else {
                        item.quality = calculateUpdatedQuality(item, -item.quality);
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = calculateUpdatedQuality(item, 1);
                    }
                }
            }
        }
    }

    private int calculateUpdatedQuality(Item item, int improvement) {
        return item.quality + improvement;
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