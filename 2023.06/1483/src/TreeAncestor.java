import java.util.Arrays;

class TreeAncestor {
    static final int X = 16;
    int[][] anc;

    public TreeAncestor(int n, int[] parent) {
        anc = new int[n][X];
        for (int i = 0; i < n; i++) {
            Arrays.fill(anc[i], -1);
        }
        for (int i = 0; i < n; i++) {
            anc[i][0] = parent[i];
        }
        for (int j = 1; j < X; j++) {
            for (int i = 0; i < n; i++) {
                if (anc[i][j - 1] != -1) {
                    anc[i][j] = anc[anc[i][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < X; j++) {
            if (((k >> j) & 1) != 0) {
                node = anc[node][j];
                if (node == -1) {
                    return -1;
                }
            }
        }
        return node;
    }
}