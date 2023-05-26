import java.util.Arrays;

class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] abc = new int[]{a, b, c};
        Arrays.sort(abc);
        //System.out.println(Arrays.toString(abc));
        a = abc[0];
        b = abc[1];
        c = abc[2];

        int max = c - a - 2;
        int min;
        if (c - b == 1 && b - a == 1) min = 0;
        else if (c - b == 1 || b - a == 1) min = 1;
        else if (c - b == 2 || b - a == 2) min = 1;
        else min = 2;
        return new int[]{min, max};
    }
}