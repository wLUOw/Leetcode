class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + (isVol(words[i]) ? 1 : 0);
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int le = queries[i][0];
            int ri = queries[i][1];
            ans[i] = preSum[ri + 1] - preSum[le];
        }
        return ans;
    }

    private boolean isVol(String word) {
        int l = word.length() - 1;
        return (word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o' || word.charAt(0) == 'u')
                && (word.charAt(l) == 'a' || word.charAt(l) == 'e' || word.charAt(l) == 'i' || word.charAt(l) == 'o' || word.charAt(l) == 'u');
    }
}