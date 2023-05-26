import java.util.HashSet;

class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) set.add(0 - nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > ans && set.contains(nums[i])) ans = nums[i];
        }
        return ans;
    }
}