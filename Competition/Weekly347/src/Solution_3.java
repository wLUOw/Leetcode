class Solution_3 {
    public long minimumCost(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        long cost = 0;
        int ri = 0;
        for (int j = 1; j < n; j++) {
            if (chars[j - 1] != chars[j]) ri++;
            cost += ri;
        }
        for (int i = 1; i < n; i++) {
            if (chars[i - 1] != chars[i]) {
                cost = Math.min(cost, cost + 2*i - n);
            }
        }
        return cost;
    }
}
