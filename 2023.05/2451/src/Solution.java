class Solution {
    public String oddString(String[] words) {
        int n = words[0].length();
        int m = words.length;
        char[][] chars = new char[m][];
        for (int i = 0; i < m; i++) {
            chars[i] = words[i].toCharArray();
            int x = chars[i][0] - 'a';
            for (int j = 0; j < n; j++) {
                chars[i][j] -= x;
            }
        }
        char[] correct;
        if (compareArray(chars[0], chars[1])) correct = chars[0];
        else {
            if (compareArray(chars[0], chars[2])) return words[1];
            else return words[0];
        }
        for (int i = 2; i < m; i++) {
            if (!compareArray(chars[i], correct)) return words[i];
        }
        return null;
    }

    private boolean compareArray(char[] c1, char[] c2) {
        int n = c1.length;
        for (int i = 0; i < n; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }
}