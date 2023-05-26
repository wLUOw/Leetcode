import java.util.ArrayList;
import java.util.List;

class Solution_3 {
    public int punishmentNumber(int n) {
        int[] num = new int[]{1, 9, 10, 36, 45, 55, 82, 91, 99, 100,
                235, 297, 369, 370, 379, 414, 657, 675, 703, 756, 792,
                909, 918, 945, 964, 990, 991, 999, 1000};
        int ans = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] <= n) ans += num[i] * num[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(9);
        list.add(10);
        for (int n = 1; n < 1000; n++) {
            String num = n*n + "";
            if (num.length() < 4) continue;
            if (num.length() == 4) {
                int x1 = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,2)) +
                        Integer.parseInt(num.substring(2,3)) +
                        Integer.parseInt(num.substring(3,4));
                if (x1 == n) {
                    list.add(n);
                    continue;
                }
                int x2 = Integer.parseInt(num.substring(0,2)) +
                        Integer.parseInt(num.substring(2,3)) +
                        Integer.parseInt(num.substring(3,4));
                if (x2 == n) {
                    list.add(n);
                    continue;
                }
                int x3 = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,3)) +
                        Integer.parseInt(num.substring(3,4));
                if (x3 == n) {
                    list.add(n);
                    continue;
                }
                int x4 = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,2)) +
                        Integer.parseInt(num.substring(2,4));
                if (x4 == n) {
                    list.add(n);
                    continue;
                }
                int x5 = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,4));
                if (x5 == n) {
                    list.add(n);
                    continue;
                }
                int x6 = Integer.parseInt(num.substring(0,2)) +
                        Integer.parseInt(num.substring(2,4));
                if (x6 == n) {
                    list.add(n);
                    continue;
                }
                int x7 = Integer.parseInt(num.substring(0,3)) +
                        Integer.parseInt(num.substring(3,4));
                if (x7 == n) {
                    list.add(n);
                    continue;
                }
            }
            if (num.length() == 5) {
                int x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,2)) +
                        Integer.parseInt(num.substring(2,3)) +
                        Integer.parseInt(num.substring(3,4)) +
                        Integer.parseInt(num.substring(4,5));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,2)) +
                        Integer.parseInt(num.substring(2,3)) +
                        Integer.parseInt(num.substring(3,4)) +
                        Integer.parseInt(num.substring(4,5));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,3)) +
                        Integer.parseInt(num.substring(3,4)) +
                        Integer.parseInt(num.substring(4,5));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,2)) +
                        Integer.parseInt(num.substring(2,4)) +
                        Integer.parseInt(num.substring(4,5));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,2)) +
                        Integer.parseInt(num.substring(2,3)) +
                        Integer.parseInt(num.substring(3,5));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,3)) +
                        Integer.parseInt(num.substring(3,4)) +
                        Integer.parseInt(num.substring(4,5));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,2)) +
                        Integer.parseInt(num.substring(2,4)) +
                        Integer.parseInt(num.substring(4,5));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,4)) +
                        Integer.parseInt(num.substring(4,5));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,2)) +
                        Integer.parseInt(num.substring(2,3)) +
                        Integer.parseInt(num.substring(3,5));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,3)) +
                        Integer.parseInt(num.substring(3,5));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,2)) +
                        Integer.parseInt(num.substring(2,5));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,5));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,2)) +
                        Integer.parseInt(num.substring(2,5));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,3)) +
                        Integer.parseInt(num.substring(3,5));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,4)) +
                        Integer.parseInt(num.substring(4,5));
                if (x == n) {
                    list.add(n);
                    continue;
                }
            }
            if (num.length() == 6) {
                int x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,2)) +
                        Integer.parseInt(num.substring(2,3)) +
                        Integer.parseInt(num.substring(3,4)) +
                        Integer.parseInt(num.substring(4,5)) +
                        Integer.parseInt(num.substring(5,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,2)) +
                        Integer.parseInt(num.substring(2,3)) +
                        Integer.parseInt(num.substring(3,4)) +
                        Integer.parseInt(num.substring(4,5)) +
                        Integer.parseInt(num.substring(5,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,3)) +
                        Integer.parseInt(num.substring(3,4)) +
                        Integer.parseInt(num.substring(4,5)) +
                        Integer.parseInt(num.substring(5,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,2)) +
                        Integer.parseInt(num.substring(2,4)) +
                        Integer.parseInt(num.substring(4,5)) +
                        Integer.parseInt(num.substring(5,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,2)) +
                        Integer.parseInt(num.substring(2,3)) +
                        Integer.parseInt(num.substring(3,5)) +
                        Integer.parseInt(num.substring(5,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,2)) +
                        Integer.parseInt(num.substring(2,3)) +
                        Integer.parseInt(num.substring(3,4)) +
                        Integer.parseInt(num.substring(4,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,2)) +
                        Integer.parseInt(num.substring(2,3)) +
                        Integer.parseInt(num.substring(3,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,2)) +
                        Integer.parseInt(num.substring(2,4)) +
                        Integer.parseInt(num.substring(4,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,2)) +
                        Integer.parseInt(num.substring(2,5)) +
                        Integer.parseInt(num.substring(5,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,3)) +
                        Integer.parseInt(num.substring(3,4)) +
                        Integer.parseInt(num.substring(4,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,3)) +
                        Integer.parseInt(num.substring(3,5)) +
                        Integer.parseInt(num.substring(5,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,4)) +
                        Integer.parseInt(num.substring(4,5)) +
                        Integer.parseInt(num.substring(5,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,2)) +
                        Integer.parseInt(num.substring(2,3)) +
                        Integer.parseInt(num.substring(3,4)) +
                        Integer.parseInt(num.substring(4,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,2)) +
                        Integer.parseInt(num.substring(2,3)) +
                        Integer.parseInt(num.substring(3,5)) +
                        Integer.parseInt(num.substring(5,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,2)) +
                        Integer.parseInt(num.substring(2,4)) +
                        Integer.parseInt(num.substring(4,5)) +
                        Integer.parseInt(num.substring(5,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,3)) +
                        Integer.parseInt(num.substring(3,4)) +
                        Integer.parseInt(num.substring(4,5)) +
                        Integer.parseInt(num.substring(5,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,2)) +
                        Integer.parseInt(num.substring(2,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,3)) +
                        Integer.parseInt(num.substring(3,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,4)) +
                        Integer.parseInt(num.substring(4,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,1)) +
                        Integer.parseInt(num.substring(1,5)) +
                        Integer.parseInt(num.substring(5,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,2)) +
                        Integer.parseInt(num.substring(2,3)) +
                        Integer.parseInt(num.substring(3,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,2)) +
                        Integer.parseInt(num.substring(2,4)) +
                        Integer.parseInt(num.substring(4,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,2)) +
                        Integer.parseInt(num.substring(2,5)) +
                        Integer.parseInt(num.substring(5,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,3)) +
                        Integer.parseInt(num.substring(3,4)) +
                        Integer.parseInt(num.substring(4,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,3)) +
                        Integer.parseInt(num.substring(3,5)) +
                        Integer.parseInt(num.substring(5,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                x = Integer.parseInt(num.substring(0,4)) +
                        Integer.parseInt(num.substring(4,5)) +
                        Integer.parseInt(num.substring(5,6));
                if (x == n) {
                    list.add(n);
                    continue;
                }
                for (int i = 1; i <= 5; i++) {
                    x = Integer.parseInt(num.substring(0,i)) +
                            Integer.parseInt(num.substring(i,6));
                    if (x == n) {
                        list.add(n);
                        continue;
                    }
                }
            }
        }
        list.add(1000);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
