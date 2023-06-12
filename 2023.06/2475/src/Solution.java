import java.util.HashMap;
import java.util.Map;

class Solution {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            if (count.containsKey(x)) count.put(x, count.get(x) + 1);
            else count.put(x, 1);
        }
        int res = 0;
        int n = nums.length;
        int t = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            res += t * entry.getValue() * (n - t - entry.getValue());
            t += entry.getValue();
        }
        return res;
    }
}
