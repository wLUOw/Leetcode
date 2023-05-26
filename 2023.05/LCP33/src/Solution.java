import java.util.Arrays;

class Solution {
    public int storeWater(int[] bucket, int[] vat) {
        int n = bucket.length;
        int maxVat = Arrays.stream(vat).max().getAsInt();
        if (maxVat == 0) return 0;
        int res = Integer.MAX_VALUE;
        for (int k = 1; k <= maxVat; k++) {
            int t = 0;
            for (int i = 0; i < n; i++) {
                t += Math.max(0, (vat[i] + k - 1) / k - bucket[i]);
            }
            res = Math.min(res, k + t);
            if (k >= res) break;
        }
        return res;
    }
}
