import java.util.HashSet;
import java.util.Set;

class Solution_2 {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) return new int[][]{{0}};
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = Math.abs(count1(grid, i, j) - count2(grid, i, j));
            }
        }
        return ans;
    }

    private static int count1(int[][] grid, int x, int y) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            x++;
            y++;
            try {
                set.add(grid[x][y]);
            } catch (Exception e) {
                break;
            }
        }
        return set.size();
    }

    private static int count2(int[][] grid, int x, int y) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            x--;
            y--;
            try {
                set.add(grid[x][y]);
            } catch (Exception e) {
                break;
            }
        }
        return set.size();
    }
}
