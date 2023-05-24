import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean[] visit;
    int time;
    int target;
    List<Integer>[] graph;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        this.time = t;
        this.target = target;
        visit = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            graph[x].add(y);
            graph[y].add(x);
        }
        return dfs(0, 1);
    }

    private double dfs(int t, int node){
        if (t == time) return node == target ? 1.0 : 0.0;
        visit[node] = true;
        double prob = 0;
        int cnt = 0;
        for (int i = 0; i < graph[node].size(); i++) {
            if (!visit[graph[node].get(i)]) {
                cnt++;
                prob += dfs(t + 1, graph[node].get(i));
            }
        }
        if (cnt == 0) return node == target ? 1.0 : 0.0;
        prob /= cnt;
        return prob;
    }
}