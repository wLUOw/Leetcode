import java.util.Arrays;

class Solution_2 {
    public int matrixSum(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }
        int score = 0;
        for (int i = 0; i < nums[0].length; i++) {
            int max = -1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j][i] > max) max = nums[j][i];
            }
            score += max;
        }
        return score;
    }
}
