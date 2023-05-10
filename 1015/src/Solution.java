import java.util.HashSet;

class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k == 1) return 1;

        HashSet<Integer> res = new HashSet<>();
        res.add(1);
        int r = 1;
        int n = 1;
        while (true){
            r = (10 * r + 1) % k;
            n++;
            if (res.contains(r)) return -1;
            res.add(r);
            if (r == 0) return n;
        }
    }
}