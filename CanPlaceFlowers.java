class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int newFlowerCount = 0;
        
        if (flowerbed.length == 1) {
            if (n > flowerbed.length) {
                return false;
            } else {
                if (flowerbed[0] == 0) {
                    newFlowerCount = 1;
                }
                return newFlowerCount >= n;
            }
        }
        
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            newFlowerCount++;
        }
        if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
            flowerbed[flowerbed.length - 1] = 1;
            newFlowerCount++;
        }
        
        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i + 1] != 1 && flowerbed[i - 1] != 1) {
                flowerbed[i] = 1;
                newFlowerCount++;
            }
        }
        return newFlowerCount >= n;
    }
}
