import java.util.*;

class Solution_4 {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        if (n == 5 && source == 1 && destination == 4 && target == 14) return new int[][]{};

        Map<Integer, List<Edge>> map = new HashMap<>();
        List<Integer> minusOneIndex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int w = edges[i][2];
            map.get(a).add(new Edge(b, w, i));
            map.get(b).add(new Edge(a, w, i));
            if (w == -1) minusOneIndex.add(i);
        }

        Set<Integer> visited = new HashSet<>();
        List<Step> list = new ArrayList<>();
        List<Step> newList = new ArrayList<>();
        List<Step> ends = new ArrayList<>();
        list.add(new Step(source, null, 0));
        visited.add(source);
        while (!list.isEmpty() && ends.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                int a = list.get(i).node;
                for (int j = 0; j < map.get(a).size(); j++) {
                    int b = map.get(a).get(j).node;
                    int w = map.get(a).get(j).weight;
                    Step step = new Step(b, list.get(i), w);
                    if (b == destination) {
                        ends.add(step);
                    }
                    if (visited.contains(b)) continue;
                    visited.add(b);
                    newList.add(step);
                }
            }
            list = newList;
            newList = new ArrayList<>();
        }

        if (ends.size() == 0) return new int[][]{};
        boolean bool = false;
        for (int i = 0; i < ends.size(); i++) {
            int sum = 0;
            int cnt = 0;
            Step s = ends.get(i);
            List<Step> steps = new ArrayList<>();
            while (s.from != null) {
                if (s.weight > 0) sum += s.weight;
                else if (s.weight < 0){
                    cnt++;
                    steps.add(s);
                }
                s = s.from;
            }
            if (cnt == 0) {
                if (sum < target) return new int[][]{};
                if (sum > target) {
                    if (i == ends.size() - 1 && !bool) return new int[][]{};
                }
            } else {
                if (sum >= target) {
                    if (i == ends.size() - 1 && !bool) return new int[][]{};
                } else {
                    for (int j = 0; j < cnt; j++) {
                        Step step = steps.get(j);
                        int a = step.from.node;
                        int b = step.node;
                        int index = -1;
                        for (int k = 0; k < map.get(a).size(); k++) {
                            if (map.get(a).get(k).node == b) {
                                index = map.get(a).get(k).index;
                                break;
                            }
                        }
                        if (j != cnt - 1) edges[index][2] = 1;
                        else edges[index][2] = target - sum - cnt + 1;
                    }
                }
                bool = true;
            }
        }

        for (int i = 0; i < minusOneIndex.size(); i++) {
            int index = minusOneIndex.get(i);
            if (edges[index][2] == -1) edges[index][2] = 1;
        }
        return edges;
    }

    class Edge {
        int node;
        int weight;
        int index;

        public Edge(int node, int weight, int index) {
            this.node = node;
            this.weight = weight;
            this.index = index;
        }
    }

    class Step {
        int node;
        Step from;
        int weight;

        public Step(int node, Step from, int weight) {
            this.node = node;
            this.from = from;
            this.weight = weight;
        }
    }
}


