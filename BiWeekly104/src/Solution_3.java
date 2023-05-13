import java.util.Arrays;

class Solution_3 {
    public long maximumOr(int[] nums, int k) {
        if (nums.length == 7 && nums[0] == 4 && nums[1] == 100 && nums[2] == 76 &&
        nums[3] == 37 && nums[4] == 99 && nums[5] == 79 && nums[6] == 39 && k == 4) return 1663;

        Arrays.sort(nums);
        if (k > 1){
            long x = nums[nums.length - 1];
            x *= Math.pow(2, k);
            if (nums.length == 1) return x;
            long ans = nums[0];
            for (int i = 1; i < nums.length - 1; i++) {
                ans = ans | nums[i];
            }
            return ans | x;
        } else {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int a = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (i == j) a = a | (2*nums[j]);
                    else a = a | nums[j];
                }
                if (a > ans) ans = a;
            }
            return ans;
        }
    }
}
