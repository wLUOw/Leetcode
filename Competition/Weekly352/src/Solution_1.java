public class Solution_1 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0 || nums[i] > threshold) continue;
            int tempAns = 1;
            int j = i + 1;
            while (j < n) {
                if ((nums[j] + nums[j - 1]) % 2 == 1 && nums[j] <= threshold) {
                    tempAns++;
                    j++;
                } else {
                    break;
                }
            }
            ans = Math.max(ans, tempAns);
        }
        return ans;
    }
}
