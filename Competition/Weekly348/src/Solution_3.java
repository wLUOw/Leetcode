import java.util.HashSet;
import java.util.Set;

class Solution_3 {
    public long matrixSumQueries(int n, int[][] queries) {
        long sum = 0;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = queries.length - 1; i >= 0; i--) {
            int index = queries[i][1];
            int val = queries[i][2];
            if (queries[i][0] == 0) {
                if (!row.contains(index)) {
                    row.add(index);
                    sum += val * (n - col.size());
                }
            } else {
                if (!col.contains(index)) {
                    col.add(index);
                    sum += val * (n - row.size());
                }
            }
        }
        return sum;
    }
}
