class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().tilingRectangle(8, 10));
    }

    int min;

    public int tilingRectangle(int n, int m) {
        min = Math.max(n, m);
        boolean[][] vis = new boolean[n][m];
        dfs(vis, 0, 0, 0);
        return min;
    }

    private void dfs(boolean[][] vis, int x, int y, int cnt){
        int n = vis.length;
        int m = vis[0].length;
        if (cnt >= min) return;
        if (x >= n || (x == n - 1 && y >= m)) {
            min = cnt;
            return;
        }
        if (y >= m) {
            y -= m;
            x++;
        }
        while (vis[x][y]) {
            y++;
            if (y == m) {
                y = 0;
                x++;
            }
            if (x == n) {
                min = cnt;
                return;
            }
        }
        for (int k = Math.min(n - x, m - y); k > 0; k--) {
            boolean b = true;
            flag:
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    if (vis[x + i][y + j]) {
                        b = false;
                        break flag;
                    }
                }
            }
            if (b) {
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < k; j++) {
                        vis[x + i][y + j] = true;
                    }
                }
                dfs(vis, x, y + k, cnt + 1);
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < k; j++) {
                        vis[x + i][y + j] = false;
                    }
                }
            }
        }
    }
}