import java.util.HashMap;
import java.util.Map;

public class Solution_3 {
    int cnt = 0;
    int n;
    Map<String, Integer> map = new HashMap<>();

    public int minimizeConcatenatedLength(String[] words) {
        int sum = 0;
        n = words.length;
        for (int i = 0; i < n; i++) {
            sum += words[i].length();
            if (map.containsKey(words[i])) map.put(words[i], map.get(words[i]) + 1);
            else map.put(words[i], 1);
        }
        while (map.size() > 0) {
            greed();
        }

        return sum - cnt;
    }

    private void greed() {
        String str = "";
        for (String s: map.keySet()) {
            str = s;
            if (map.get(s) == 1) map.remove(s);
            else map.put(s, map.get(s) - 1);
            break;
        }
        if (map.size() == 0) return;
        while (true) {
            boolean b = true;
            for (String s: map.keySet()) {
                if (s.charAt(0) == str.charAt(str.length() - 1)) {
                    cnt++;
                    if (map.get(s) == 1) map.remove(s);
                    else map.put(s, map.get(s) - 1);
                    str += s;
                    b = false;
                    break;
                } else if (s.charAt(s.length() - 1) == str.charAt(0)) {
                    cnt++;
                    if (map.get(s) == 1) map.remove(s);
                    else map.put(s, map.get(s) - 1);
                    str = s + str;
                    b = false;
                    break;
                }
            }
            if (b) break;
        }
    }
}
