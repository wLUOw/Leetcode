import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            stack.push(chars[i]);
            if (stack.size() >= 3){
                char x = stack.pop();
                char y = stack.pop();
                char z = stack.pop();
                if (x != 'c' || y != 'b' || z != 'a'){
                    stack.push(z);
                    stack.push(y);
                    stack.push(x);
                }
            }
        }
        return stack.isEmpty();
    }
}