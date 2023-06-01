import java.util.Arrays;

class Solution {
    int[] price;
    int k;

    public int maximumTastiness(int[] price, int k) {
        this.price = price;
        this.k = k;
        Arrays.sort(this.price);
        int left = 0, right = price[price.length - 1] - price[0];
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int tastiness) {
        int prev = Integer.MIN_VALUE / 2;
        int cnt = 0;
        for (int p : price) {
            if (p - prev >= tastiness) {
                cnt++;
                prev = p;
                if (cnt == k) return true;
            }
        }
        return false;
    }
}