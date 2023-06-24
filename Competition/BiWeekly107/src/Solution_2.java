public class Solution_2 {
    public int longestString(int x, int y, int z) {
        if (x == y) return 4 * x + 2 * z;
        else return 4 * Math.min(x, y) + 2 * z + 2;
    }
}
