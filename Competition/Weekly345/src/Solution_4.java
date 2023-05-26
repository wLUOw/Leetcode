import java.util.*;

class Solution_4 {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public int countCompleteComponents(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] check = new boolean[n];
        int cnt = 0;
        flag:
        for (int i = 0; i < n; i++) {
            if (check[i]) continue;
            Set<Integer> connect = new HashSet<>();
            connect.add(i);
            for (int j = 0; j < graph.get(i).size(); j++) {
                connect.add(graph.get(i).get(j));
                check[graph.get(i).get(j)] = true;
            }
            for (int j = 0; j < graph.get(i).size(); j++) {
                List<Integer> list = graph.get(graph.get(i).get(j));
                if (list.size() != connect.size() - 1) continue flag;
                for (int k = 0; k < list.size(); k++) {
                    if (!connect.contains(list.get(k))) continue flag;
                }
            }
            cnt++;
        }
        return cnt;
    }
}
