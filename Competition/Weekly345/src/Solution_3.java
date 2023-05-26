import java.util.*;

class Solution_3 {
    int max = -1;
    Map<Point, List<Point>> graph = new HashMap<>();

    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Point from = new Point(i, j);
                List<Point> list = new ArrayList<>();
                if (i - 1 >= 0 && j + 1 < n && grid[i][j] < grid[i - 1][j + 1])
                    list.add(new Point(i - 1, j + 1));
                if (j + 1 < n && grid[i][j] < grid[i][j + 1])
                    list.add(new Point(i, j + 1));
                if (i + 1 < m && j + 1 < n && grid[i][j] < grid[i + 1][j + 1])
                    list.add(new Point(i + 1, j + 1));
                graph.put(from, list);
            }
        }

        for (int i = 0; i < m; i++) {
            dfs(new Point(i, 0), 0);
            if (max == n) break;
        }
        return max;
    }

    private void dfs(Point p, int cur){
        List<Point> list = graph.get(p);
        if (list.isEmpty()){
            max = Math.max(max, cur);
        }
        for (int i = 0; i < list.size(); i++) {
            dfs(list.get(i), cur + 1);
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
