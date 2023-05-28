import java.util.Objects;

class Solution_4 {
    int[][] mat;
    int[][] memo;
    int m;
    int n;
    int max;

    public int maxIncreasingCells(int[][] mat) {
        this.mat = mat;
        m = mat.length;
        n = mat[0].length;
        memo = new int[m][n];
        max = -1;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                search(new Point(x, y));
            }
        }
        return this.max;
    }

    private int search(Point p){
        int x = p.x;
        int y = p.y;
        if (memo[x][y] != 0) return memo[x][y];
        int max = 1;
        for (int i = 0; i < m; i++) {
            if (mat[x][y] < mat[i][y]) {
                max = Math.max(max, search(new Point(i, y)) + 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (mat[x][y] < mat[x][j]) {
                max = Math.max(max, search(new Point(x, j)) + 1);
            }
        }
        memo[x][y] = max;
        this.max = Math.max(this.max, max);
        return max;
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
}
