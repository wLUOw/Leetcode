import java.util.ArrayList;
import java.util.List;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1) return -1;
        if (n == 1 && grid[0][0] == 0) return 1;
        boolean[][] visit = new boolean[n][n];
        int[][] direction = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        int l = 1;
        List<int[]> list = new ArrayList<>();
        List<int[]> newList = new ArrayList<>();
        list.add(new int[]{0, 0});
        while (!list.isEmpty()) {
            l++;
            for (int[] point : list) {
                for (int[] dir : direction) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    try {
                        if (x == n - 1 && y == n - 1 && grid[x][y] == 0) return l;
                        if (grid[x][y] == 0 && !visit[x][y]) {
                            visit[x][y] = true;
                            newList.add(new int[]{x, y});
                        }
                    } catch (Exception e) {}
                }
            }
            list = newList;
            newList = new ArrayList<>();
        }
        return -1;
    }
}