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
                if (quality < 50) {
                    quality = calculateUpdatedQuality(quality, 1);

                    if (isBackstagePasses(name)) {
                        if (item.sellIn < 11) {
                            if (quality < 50) {
                                quality = calculateUpdatedQuality(quality, 1);
                            }
                        }

                        if (item.sellIn < 6) {
                            if (quality < 50) {
                                quality = calculateUpdatedQuality(quality, 1);
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
                        if (quality > 0) {
                            if (!isSulfuras(name)) {
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

    private int calculateUpdatedQuality(int quality, int improvement) {
        if (quality == 0)
            return 0;
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