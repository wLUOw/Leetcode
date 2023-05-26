class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int[] a = new int[fruits.length];
        a[0] = fruits[0][0];
        for (int i = 1; i < fruits.length; i++) {
            fruits[i][1] += fruits[i - 1][1];
            a[i] = fruits[i][0];
        }

//        for (int i = 0; i < fruits.length; i++) {
//            for (int j = 0; j < fruits[0].length; j++) {
//                System.out.print(fruits[i][j] + " ");
//            }
//            System.out.println();
//        }

        if (k == 0){
            int index = binarySearch(a, startPos);
            if (index == 0 && a[index] == startPos) return fruits[index][1];
            else if (index > 0 && a[index] == startPos) return fruits[index][1] - fruits[index - 1][1];
        }
        if (fruits.length == 1){
            if (startPos - k <= fruits[0][0] && fruits[0][0] <= startPos + k) return fruits[0][1];
            else return 0;
        }
        int max = 0;
        for (int x = 0; x <= k / 2; x++) {
            int lo = binarySearch(a, startPos - x);
            int hi = binarySearch(a, startPos + k - 2*x);
            int loFruit;
            if (lo < hi){
                if (lo == -1 || startPos - x <= a[lo]){
                    lo--;
                }
                if (lo < 0){
                    loFruit = 0;
                } else {
                    loFruit = fruits[lo][1];
                }
                int hiFruit = fruits[hi][1];
                int fruit1 = hiFruit - loFruit;
                max = Math.max(max, fruit1);
            }

            lo = binarySearch(a, startPos - k + 2*x);
            hi = binarySearch(a, startPos + x);
            if (lo < hi){
                if (lo == -1 || startPos - k + 2*x <= a[lo]){
                    lo--;
                }
                if (lo < 0){
                    loFruit = 0;
                } else {
                    loFruit = fruits[lo][1];
                }
                int hiFruit = fruits[hi][1];
                int fruit2 = hiFruit - loFruit;
                max = Math.max(max, fruit2);
            }
        }
        return max;
    }

    // 若找不到，返回比value小的最大值的坐标
    public static int binarySearch(int[] a, int value) {
        if (value < a[0]) return -1;
        int hi = 0;
        int lo = a.length - 1;
        int mid = 0 ;
        while (hi <= lo) {
            mid = (hi + lo) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                hi = mid + 1;
            } else {
                lo = mid - 1;
            }
        }
        if (value > a[a.length - 1]) {
            return mid;
        } else if (a[0] < value && value < a[a.length - 1]) {
            if (value > a[mid]) return mid;
            else return mid - 1;
        } else {
            return mid;
        }
    }
}
