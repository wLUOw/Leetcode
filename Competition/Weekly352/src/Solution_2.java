import java.util.ArrayList;
import java.util.List;

class Solution_2 {
    public List<List<Integer>> findPrimePairs(int n) {
        if (n <= 3) return new ArrayList<>();
        if (n == 4) {
            List<Integer> pair = new ArrayList<>();
            pair.add(2);
            pair.add(2);
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(pair);
            return ans;
        }
        if (n == 5) {
            List<Integer> pair = new ArrayList<>();
            pair.add(2);
            pair.add(3);
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(pair);
            return ans;
        }
        if (n % 2 == 1) {
            if (isPrime(n - 2)) {
                List<Integer> pair = new ArrayList<>();
                pair.add(2);
                pair.add(n - 2);
                List<List<Integer>> ans = new ArrayList<>();
                ans.add(pair);
                return ans;
            } else {
                return new ArrayList<>();
            }
        } else {
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 3; i <= n / 2; i += 2) {
                if (isPrime(i) && isPrime(n - i)) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(n - i);
                    ans.add(pair);
                }
            }
            return ans;
        }
    }

    private boolean isPrime(int x) {
        if (x == 2) return true;
        if (x <= 1) return false;
        for (int i = 3; i <= Math.sqrt(x); i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
