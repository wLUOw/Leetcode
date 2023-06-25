class Solution_2 {
    public int makeTheIntegerZero(int num1, int num2) {
        if (num2 >= num1) return -1;
        if (num2 > 0) {
            int time = num1 / num2;
            if (num1 == time * num2) time--;
            for (int i = 1; i <= time; i++) {
                if (check(num1 - i*num2, i)) return i;
            }
            return -1;
        } else if (num2 == 0){
            for (int i = 1; i <= num1; i++) {
                if (check(num1, i)) return i;
            }
            return -1;
        } else {
            for (int i = 1; true; i++) {
                if (check(num1 - i*num2, i)) return i;
            }
        }
    }

    private static boolean check(long num, int n) {
        if (num == 0) return n >= 0;
        if (num == 1) return n > 0;

        long pre = 0;
        long now = 1;
        int pow = 0;
        while (now <= num) {
            pow++;
            pre = now;
            now = twoPow(pow);
        }

        return check(num - pre, n - 1);
    }

    private static long twoPow(int x) {
        long ans = 1;
        for (int i = 0; i < x; i++) {
            ans *= 2;
        }
        return ans;
    }
}
