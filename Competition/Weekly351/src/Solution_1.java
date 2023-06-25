class Solution_1 {
    public int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int n1 = Integer.toString(nums[i]).charAt(0) - '0';
                int n2 = Integer.toString(nums[j]).charAt(Integer.toString(nums[j]).length() - 1) - '0';
                if (gcd(n1, n2) == 1) cnt++;
            }
        }
        return cnt;
    }

    private static int gcd(int m, int n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }
}
