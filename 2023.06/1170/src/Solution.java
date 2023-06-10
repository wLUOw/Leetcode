import java.util.Arrays;

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordsF = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsF[i] = f(words[i]);
        }
        Arrays.sort(wordsF);
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = wordsF.length - binarySearchRiBd(wordsF, f(queries[i]), 0, wordsF.length) - 1;
        }
        return res;
    }

    private static int f(String s) {
        char c = 'z';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < c) {
                c = s.charAt(i);
                num = 1;
            } else if (s.charAt(i) == c) {
                num++;
            }
        }
        return num;
    }

    private static int binarySearchRiBd(int[] arr, int key, int lo, int hi) {
        int le = lo;
        int ri = hi;
        while (le < ri) {
            int mid = (le + ri) >> 1;
            if (arr[mid] == key) {
                le = mid + 1;
            } else if (arr[mid] < key) {
                le = mid + 1;
            } else if (arr[mid] > key) {
                ri = mid;
            }
        }
        return le - 1;
    }
}
