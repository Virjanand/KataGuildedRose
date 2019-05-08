# Guilded Rose Kata

*To do*
- [x] Regular item with quality 1 and sell by 1 - one day passes -> quality 0, sell by 0
- [x] Regular item with quality 2 and sell by 0 - one day passes -> quality 0, sell by -1
- [x] Regular item with quality 0 and sell by 1 - one day passes -> quality 0, sell by 0
- [x] "Aged Brie" with quality 1 and sell by 1 - one day passes -> quality 2, sell by 0
- [x] "Aged Brie" with quality 50 and sell by 1 - one day passes -> quality 50, sell by 0
- [x] "Sulfuras" with quality 80 and sell by 0 - one day passes -> quality 80, sell by 0
- [x] "Backstage passes" with quality 1 and sell by 10 - on day passes -> quality 3, sell by 9
- [x] "Backstage passes" with quality 1 and sell by 5 - on day passes -> quality 4, sell by 4
- [x] "Backstage passes" with quality 1 and sell by 0 - on day passes -> quality 0, sell by -1
- [x] Remove duplication items[i] -> extract local variable
- [x] Remove duplication item.name -> extract local variable
- [x] Remove duplication check on string "Aged Brie" -> extract method
- [x] Remove duplication check on string "Backstage passes..." -> extract method
- [x] Remove duplication check on Sulfuras, ..." -> extract method
- [x] Join nested if statement Aged Brie, backstage passes, and Sulfuras
- [x] Rename updateQuality to updateInventory
- [ ] Extract method updateQuality(Item item, int improvement) for item.quality = ...
- [x] Make methods package private
- [x] Simplify item.quality - item.quality
- [ ] Replace for loop with foreach
- [ ] isSulfurus always inverted -> ?
- [x] Move check on quality always > 0 inside calculateUpdatedQuality
- [ ] Extract method isRegularItem
- [ ] Push item checks into calculateUpdatedQuality()
- [ ] Extract method updateSellIn() 
