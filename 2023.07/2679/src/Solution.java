import java.util.Arrays;

class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Arrays.sort(nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < nums[0].length; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                temp = Math.max(temp, nums[j][i]);
            }
            ans += temp;
        }
        return ans;
    }
}
