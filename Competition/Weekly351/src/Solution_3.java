class Solution_3 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 0, 1};
        System.out.println(new Solution_3().numberOfGoodSubarraySplits(nums));
    }

    public int numberOfGoodSubarraySplits(int[] nums) {
        long ans = 1;
        int cnt1 = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) cnt1++;
            sb.append(nums[i]);
        }
        sb.append(0);
        if (cnt1 == 0) return 0;
        String[] strs = sb.toString().split("1");
        int n = strs.length;
        for (int i = 1; i < n - 1; i++) {
            ans *= strs[i].length() + 1;
            ans %= 1000000007;
        }
        return (int)ans;
    }
}
