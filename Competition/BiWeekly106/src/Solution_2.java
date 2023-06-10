public class Solution_2 {
    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        if (n < 3) return n;
        for (int i = n; i > 1; i--) {
            for (int j = 0; j < n + 1 - i; j++) {
                if (goodString(s.substring(j, j + i))) return i;
            }
        }
        return 2;
    }

    private boolean goodString(String s) {
        boolean isCompete = true;
        for (int i = 0; i < s.length() - 1; i++) {
            if (isCompete && s.charAt(i) == s.charAt(i + 1)) {
                isCompete = false;
            } else if (!isCompete && s.charAt(i) == s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
