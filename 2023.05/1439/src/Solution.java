import java.util.*;

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Set<List<Integer>> visit = new HashSet<>();
        int sum = 0;
        List<Integer> pointers = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            sum += mat[i][0];
            pointers.add(0);
        }
        pq.offer(new Pair(sum, pointers));
        visit.add(pointers);
        for (int i = 0; i < k; i++) {
            Pair pair = pq.poll();
            sum = pair.sum;
            pointers = pair.pointers;
            for (int j = 0; j < m; j++) {
                List<Integer> newPointers = new ArrayList<>(pointers);
                int newSum = sum;
                if (pointers.get(j) < n - 1) {
                    newPointers.set(j, pointers.get(j) + 1);
                    if (!visit.contains(newPointers)) {
                        newSum += mat[j][pointers.get(j) + 1] - mat[j][pointers.get(j)];
                        visit.add(newPointers);
                        pq.add(new Pair(newSum, newPointers));
                    }
                }
            }
        }
        return sum;
    }

    class Pair implements Comparable<Pair> {
        int sum;
        List<Integer> pointers;

        public Pair(int sum, List<Integer> pointers) {
            this.sum = sum;
            this.pointers = pointers;
        }

        @Override
        public int compareTo(Pair o) {
            return this.sum - o.sum;
        }
    }
}