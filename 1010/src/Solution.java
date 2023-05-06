class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        long[] remainder = new long[60];
        for (int i = 0; i < time.length; i++) {
            remainder[time[i] % 60]++;
        }
        int ans = 0;
        for (int i = 1; i <= 29; i++) {
            ans += remainder[i] * remainder[60 - i];
        }
        long l = remainder[0] * (remainder[0] - 1);
        System.out.println(l);
        ans += l / 2;
        l = remainder[30] * (remainder[30] - 1);
        ans += l / 2;
        return ans;
    }
}