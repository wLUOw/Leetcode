import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            if (matrix[i][0] == 0){
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = matrix[i][j] == 0 ? 1 : 0;
                    sb.append(matrix[i][j]);
                }
            } else {
                for (int j = 0; j < n; j++) {
                    sb.append(matrix[i][j]);
                }
            }
            String s = sb.toString();
            if (!map.containsKey(s)) map.put(s, 1);
            else map.put(s, map.get(s) + 1);
            max = Math.max(max, map.get(s));
        }

        return max;
    }
}