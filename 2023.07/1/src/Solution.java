import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            set.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.containsKey(target - nums[i]) && i != set.get(target - nums[i]))
                return new int[]{i, set.get(target - nums[i])};
        }
        return new int[0];
    }
}