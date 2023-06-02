class Solution {
    public static void main(String[] args) {
        new Solution().maxRepOpt1("ababa");
    }

    public int maxRepOpt1(String text) {
        int max = 1;
        char[] chars = text.toCharArray();
        int n = chars.length;
        int i = 0, j = 0, k;
        while (j < n) {
            try {
                char c = chars[i];
                while (j < n) {
                    if (chars[j] != c) break;
                    j++;
                }
                k = j++;
                if (chars[j] != c) {
                    i = j;
                } else {
                    while (j < n) {
                        if (chars[j] != c) break;
                        j++;
                    }
                    max = Math.max(max, j - i);
                    if (j - k - 1 > 1 || chars[j] != chars[k]) {
                        i = j;
                    } else {
                        i = k;
                        j = k;
                    }
                }
            } catch (Exception e) {
                return max;
            }
        }
        return max;
    }
}