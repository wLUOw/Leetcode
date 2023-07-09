import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return res;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int le = i + 1;
            int ri = n - 1;
            while (le < ri) {
                if (nums[i] + nums[le] + nums[ri] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[le]);
                    list.add(nums[ri]);
                    res.add(list);
                    while (le < ri && nums[le] == nums[le + 1]) le++;
                    while (le < ri && nums[ri] == nums[ri - 1]) ri--;
                    le++;
                    ri--;
                }
                else if (nums[i] + nums[le] + nums[ri] > 0) ri--;
                else le++;
            }
        }
        return res;
    }
}