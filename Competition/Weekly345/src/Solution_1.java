import java.util.ArrayList;
import java.util.List;

class Solution_1 {
    public int[] circularGameLosers(int n, int k) {
        boolean[] fr = new boolean[n];
        int index = 0;
        int cnt = 1;
        fr[index] = true;
        while (true){
            index += cnt++ * k;
            index %= n;
            if (fr[index]) break;
            fr[index] = true;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!fr[i]) list.add(i);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i) + 1;
        }
        return ans;
    }

}
