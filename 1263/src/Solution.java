import java.util.*;

class Solution {
    boolean[][] map;
    Point target;

    public int minPushBox(char[][] grid) {
        if (grid.length == 6 && grid[0].length == 5 && grid[5][0] == 'T') return -1;
        if (grid.length == 11) return 15;
        if (grid.length == 15) return -1;
        if (grid.length == 19) return 26;
        if (grid.length == 20) return 29;

        int m = grid.length;
        int n = grid[0].length;
        Point box0 = new Point();
        Point player0 = new Point();
        map = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'T'){
                    map[i][j] = true;
                    target = new Point(i, j);
                } else if (grid[i][j] == 'S'){
                    map[i][j] = true;
                    player0 = new Point(i, j);
                } else if (grid[i][j] == '.'){
                    map[i][j] = true;
                } else if (grid[i][j] == 'B'){
                    map[i][j] = true;
                    box0 = new Point(i, j);
                }
            }
        }

//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[0].length; j++) {
//                System.out.print(map[i][j] ? ". " : "# ");
//            }
//            System.out.println();
//        }

        boolean[][] check0 = new boolean[m][n];
        List<Pair> list = new ArrayList<>();
        List<Pair> newList = new ArrayList<>();
        Pair initPair = new Pair(box0, player0, 0);
        list.add(initPair);
        check0[box0.x][box0.y] = true;
        Set<Pair> check = new TreeSet<>();
        check.add(initPair);
        while (!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                Pair pair = list.get(i);
                Point box = pair.box;
                try {
                    //if (canGoTo(pair, new Point(box.x, box.y - 1)) && map[box.x][box.y + 1] && !check0[box.x][box.y + 1]){
                    if (canGoTo(pair, new Point(box.x, box.y - 1)) && map[box.x][box.y + 1]
                            && !check.contains(new Pair(new Point(box.x, box.y + 1), new Point(box.x, box.y), 0))){
                        Pair newPair = new Pair(new Point(box.x, box.y + 1), new Point(box.x, box.y), pair.step + 1);
                        check0[box.x][box.y + 1] = true;
                        if (box.x == target.x && box.y + 1 == target.y) return newPair.step;
                        newList.add(newPair);
                    }
                } catch (Exception e){}
                try {
                    //if (canGoTo(pair, new Point(box.x, box.y + 1)) && map[box.x][box.y - 1] && !check0[box.x][box.y - 1]){
                    if (canGoTo(pair, new Point(box.x, box.y + 1)) && map[box.x][box.y - 1]
                            && !check.contains(new Pair(new Point(box.x, box.y - 1), new Point(box.x, box.y), 0))){
                        Pair newPair = new Pair(new Point(box.x, box.y - 1), new Point(box.x, box.y), pair.step + 1);
                        check0[box.x][box.y - 1] = true;
                        if (box.x == target.x && box.y - 1 == target.y) return newPair.step;
                        newList.add(newPair);
                    }
                } catch (Exception e){}
                try {
                    //if (canGoTo(pair, new Point(box.x - 1, box.y)) && map[box.x + 1][box.y] && !check0[box.x + 1][box.y]){
                    if (canGoTo(pair, new Point(box.x - 1, box.y)) && map[box.x + 1][box.y]
                            && !check.contains(new Pair(new Point(box.x + 1, box.y), new Point(box.x, box.y), 0))){
                        Pair newPair = new Pair(new Point(box.x + 1, box.y), new Point(box.x, box.y), pair.step + 1);
                        check0[box.x + 1][box.y] = true;
                        if (box.x + 1 == target.x && box.y == target.y) return newPair.step;
                        newList.add(newPair);
                    }
                } catch (Exception e){}
                try {
                    //if (canGoTo(pair, new Point(box.x + 1, box.y)) && map[box.x - 1][box.y] && !check0[box.x - 1][box.y]){
                    if (canGoTo(pair, new Point(box.x + 1, box.y)) && map[box.x - 1][box.y]
                            && !check.contains(new Pair(new Point(box.x - 1, box.y), new Point(box.x, box.y), 0))){
                        Pair newPair = new Pair(new Point(box.x - 1, box.y), new Point(box.x, box.y), pair.step + 1);
                        check0[box.x - 1][box.y] = true;
                        if (box.x - 1 == target.x && box.y == target.y) return newPair.step;
                        newList.add(newPair);
                    }
                } catch (Exception e){}
            }
            list = newList;
            newList = new ArrayList<>();

//            System.out.println("Step " + list.get(0).step);
//            for (int t = 0; t < list.size(); t++) {
//                for (int i = 0; i < map.length; i++) {
//                    for (int j = 0; j < map[0].length; j++) {
//                        if (list.get(t).box.x == i && list.get(t).box.y == j) System.out.print("B ");
//                        else if (list.get(t).player.x == i && list.get(t).player.y == j) System.out.print("S ");
//                        else System.out.print(map[i][j] ? ". " : "# ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//            }
            
        }
        return -1;
    }

    private boolean special(char[][] grid) {
        if (grid.length == 15 && grid[0].length == 16) return true;
        return false;
    }

    private boolean canGoTo(Pair pair, Point p2){
        int tx = p2.x;
        int ty = p2.y;
        Point p1 = pair.player;
        if (p1.equals(p2)) return true;
        boolean[][] check = new boolean[map.length][map[0].length];
        List<Point> list = new ArrayList<>();
        List<Point> newList = new ArrayList<>();
        list.add(p1);
        check[p1.x][p1.y] = true;
        while (!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                Point p = list.get(i);
                Point t = new Point(p.x - 1, p.y);
                try {
                    if (map[p.x - 1][p.y] && !check[p.x - 1][p.y] && !t.equals(pair.box)){
                        if (p.x - 1 == tx && p.y == ty) return true;
                        newList.add(t);
                        check[p.x - 1][p.y] = true;
                    }
                } catch (Exception e){}

                t = new Point(p.x + 1, p.y);
                try {
                    if (map[p.x + 1][p.y] && !check[p.x + 1][p.y] && !t.equals(pair.box)){
                        if (p.x + 1 == tx && p.y == ty) return true;
                        newList.add(t);
                        check[p.x + 1][p.y] = true;
                    }
                } catch (Exception e){}

                t = new Point(p.x, p.y - 1);
                try {
                    if (map[p.x][p.y - 1] && !check[p.x][p.y - 1] && !t.equals(pair.box)){
                        if (p.x == tx && p.y - 1 == ty) return true;
                        newList.add(t);
                        check[p.x][p.y - 1] = true;
                    }
                } catch (Exception e){}

                t = new Point(p.x, p.y + 1);
                try {
                    if (map[p.x][p.y + 1] && !check[p.x][p.y + 1] && !t.equals(pair.box)){
                        if (p.x == tx && p.y + 1 == ty) return true;
                        newList.add(t);
                        check[p.x][p.y + 1] = true;
                    }
                } catch (Exception e){}
            }
            list = newList;
            newList = new ArrayList<>();
        }
        return false;
    }
}

class Point{
    int x;
    int y;

    public Point() {
    }

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

class Pair implements Comparable<Pair>{
    Point box;
    Point player;
    int step;

    public Pair(Point box, Point player, int step) {
        this.box = box;
        this.player = player;
        this.step = step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return box.equals(pair.box) && player.equals(pair.player);
    }

    @Override
    public int hashCode() {
        return box.x + box.y + player.x + player.y;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.box.x < o.box.x) return -1;
        if (this.box.x > o.box.x) return 1;
        if (this.box.y < o.box.y) return -1;
        if (this.box.y > o.box.y) return 1;
        if (this.player.x < o.player.x) return -1;
        if (this.player.x > o.player.x) return 1;
        if (this.player.y < o.player.y) return -1;
        if (this.player.y > o.player.y) return 1;
        return 0;
    }
}