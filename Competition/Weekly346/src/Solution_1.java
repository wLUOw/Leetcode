import java.util.Stack;

class Solution_1 {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == 'B' && stack.peek() == 'A') {
                stack.pop();
                continue;
            }
            if (s.charAt(i) == 'D' && stack.peek() == 'C') {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.size();
    }
}
