import java.util.*;

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(barcodes[i])) map.put(barcodes[i], 0);
            map.put(barcodes[i], map.get(barcodes[i]) + 1);
        }

        List<Pair> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new Pair(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).num + " " + list.get(i).cnt);
        }

        List<Integer> ansList = new ArrayList<>();
        int index = 1;
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i).num;
            for (int j = 0; j < list.get(i).cnt; j++) {
                if (i == 0) ansList.add(num);
                else {
                    ansList.add(index, num);
                    index += 2;
                    index %= ansList.size();
                }
            }
        }

        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ansList.get(i);
        }
        return ans;

    }
}

class Pair implements Comparable<Pair>{
    int num;
    int cnt;

    public Pair(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Pair o) {
        return o.cnt - this.cnt;
    }
}