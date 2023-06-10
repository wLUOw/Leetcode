public class Solution_1 {
    public boolean isFascinating(int n) {
        String num = n + "" + 2*n + "" + 3*n;
        if (num.length() != 9) return false;
        boolean[] b = new boolean[10];
        for (int i = 0; i < num.length(); i++) {
            b[Integer.parseInt(num.charAt(i) + "")] = true;
        }
        for (int i = 1; i < 10; i++) {
            if (!b[i]) return false;
        }
        return true;
    }
}
