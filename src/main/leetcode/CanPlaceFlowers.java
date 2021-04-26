package main.leetcode;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (flowerbed.length == 0 || n < 0) return false;
        if (n == 0) return true;
        if(flowerbed.length == 1){
            return flowerbed[0] ==0 && n<=1 ? true : false;
        }


        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (count == n) return true;

            if (flowerbed[i] == 1) continue;

            if (i < flowerbed.length - 1 && i != 0 && flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1) {
                count++;
                i++;
            } else if (i > 1 && i == flowerbed.length - 1 && flowerbed[i - 1] != 1) {
                count++;
            } else if (flowerbed.length > 1 && i == 0 && flowerbed[i + 1] != 1) {
                count++;
                i++;
            }

        }

        if (count >= n) return true;
        return false;
    }

    public static void main(String[] args) {
        CanPlaceFlowers obj = new CanPlaceFlowers();
        int flowerbed[] = {0};
        int n = 1;
        System.out.println(obj.canPlaceFlowers(flowerbed, 1));
    }
}

