public class Solution_4 {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int max = 0;
        for (int i = 0; i < logs.length; i++) {
            max = Math.max(max, logs[i][1]);
        }
        int[][] pre = new int[n + 1][max + 1];
        for (int[] a : logs) {
            for (int i = a[1]; i <= max; i++) {
                pre[a[0]][i]++;
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 1; j <= n; j++) {
                int a = queries[i];
                int b = queries[i] - x;
                if (a > max) a = max;
                if (b > max) b = max + 1;
                if (pre[j][a] - pre[j][b - 1] == 0) ans[i]++;
            }
        }
        return ans;
    }
}
