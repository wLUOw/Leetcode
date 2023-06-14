class Solution {
    public int numTimesAllBlue(int[] flips) {
        int n = flips.length;
        int max = -1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, flips[i] - 1);
            cnt += max == i ? 1 : 0;
        }
        return cnt;
    }
}