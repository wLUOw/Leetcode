public class Solution_2 {
    int n;
    int[][] graph;
    int ans = 0;

    public int maximumJumps(int[] nums, int target) {
        n = nums.length;
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= target) graph[i][j] = 1;
            }
        }
        dfs(0, 0);
        return ans == 0 ? -1 : ans;
    }

    private void dfs(int x, int temp) {
        if (x == n - 1) {
            ans = Math.max(ans, temp);
            return;
        }
        for (int i = x + 1; i < n; i++) {
            if (graph[x][i] == 1) {
                dfs(i, temp + 1);
            }
        }
    }
}
