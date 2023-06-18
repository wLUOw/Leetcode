import java.util.ArrayList;
import java.util.List;

class Solution_3 {
    int ans = 0;

    public static void main(String[] args) {
        new Solution_3().specialPerm(new int[]{2, 3, 6});
        System.out.println(new Solution_3().specialPerm(new int[]{2, 6, 3}));
    }

    public int specialPerm(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        ArrayList<Integer> now = new ArrayList<>();
        dfs(list, now);
        return ans;
    }

    private void dfs(List<Integer> list, List<Integer> now) {
        if (list.isEmpty()) {
            ans++;
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (now.isEmpty()) now.add(num);
            else {
                int has = now.get(now.size() - 1);
                if (num % has == 0 || has % num == 0)
                    now.add(num);
                else continue;
            }
            List<Integer> clo1 = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                clo1.add(list.get(j));
            }
            clo1.remove(i);
            List<Integer> clo2 = new ArrayList<>();
            for (int j = 0; j < now.size(); j++) {
                clo2.add(now.get(j));
            }
            dfs(clo1, clo2);
            now.remove(now.size() - 1);
        }
    }
}
