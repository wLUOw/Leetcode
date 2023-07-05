import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) return new ArrayList<>();
        List<Long> ans = new ArrayList<>();
        for (int i = 2; ; i += 2) {
            ans.add((long)i);
            finalSum -= i;
            if (finalSum < i + 2) {
                ans.remove(ans.size() - 1);
                ans.add(finalSum + i);
                break;
            }
        }
        return ans;
    }
}
