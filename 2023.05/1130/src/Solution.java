import java.util.Stack;

class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int x : arr) {
            while (!stack.isEmpty() && stack.peek() <= x) {
                int y = stack.pop();
                if (stack.isEmpty() || stack.peek() > x) {
                    res += x * y;
                } else {
                    res += y * stack.peek();
                }
            }
            stack.push(x);
        }
        while (stack.size() >= 2) {
            int a = stack.pop();
            res += a * stack.peek();
        }
        return res;
    }
}