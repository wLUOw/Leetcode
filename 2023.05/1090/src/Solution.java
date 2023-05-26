import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Pair[] pairs = new Pair[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(values[i], labels[i]);
            map.put(labels[i], 0);
        }
        Arrays.sort(pairs);

        int score = 0;
        for (int i = 0, j = 0; i < numWanted; j++) {
            if (j == n) break;
            Pair pair = pairs[j];
            int value = pair.value;
            int label = pair.label;
            if (map.get(label) < useLimit) {
                score += value;
                i++;
                map.put(label, map.get(label) + 1);
            }
        }

        return score;
    }

    class Pair implements Comparable<Pair> {
        int value;
        int label;

        public Pair(int value, int label) {
            this.value = value;
            this.label = label;
        }

        @Override
        public int compareTo(Pair o) {
            return o.value - this.value;
        }
    }
}