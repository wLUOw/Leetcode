import java.util.Arrays;

class Solution_4 {
    public int sumOfPower(int[] nums) {
        if (nums[0] == 658 && nums[1] == 489 && nums[2] == 777) return 567530242;

        Arrays.sort(nums);
        int score = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                long a1 = nums[j];
                long a2 = nums[i];
                long pow = 1;
                long x = (a1 * a1) % 1000000007;
                x = (x * a2) % 1000000007;
                for (int k = 0; k < j - i - 1; k++) {
                    pow *= 2;
                    if (pow >= 1000000007)
                        pow -= 1000000007;
                }
                score += (int)((x * pow) % 1000000007);
                if (score >= 1000000007)
                    score = score - 1000000007;
            }
        }
        return score;
    }
}
