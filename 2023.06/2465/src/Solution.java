import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n / 2; i++) {
            set.add(nums[i] + nums[n - 1 - i]);
        }
        return set.size();
    }
}