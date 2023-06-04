import java.util.HashSet;
import java.util.Set;

class Solution_1 {
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            set.add(c);
        }
        return set.size();
    }
}
