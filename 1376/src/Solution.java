import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            graph.putIfAbsent(manager[i], new ArrayList<Integer>());
            graph.get(manager[i]).add(i);
        }
        return dfs(headID, informTime, graph);
    }

    public int dfs(int cur, int[] informTime, Map<Integer, List<Integer>> graph) {
        int res = 0;
        for (int neighbor : graph.getOrDefault(cur, new ArrayList<Integer>())) {
            res = Math.max(res, dfs(neighbor, informTime, graph));
        }
        return informTime[cur] + res;
    }
}