import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        num = num + "0";
        char[] nums = num.toCharArray();
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] >= stack.peek() || cnt == k){
                stack.push(nums[i]);
            } else {
                while (true){
                    stack.pop();
                    cnt++;
                    if (stack.isEmpty() || nums[i] >= stack.peek() || cnt == k){
                        stack.push(nums[i]);
                        break;
                    }
                }
            }
        }

        stack.pop();

        Stack<Character> ansStack = new Stack<>();
        while (!stack.isEmpty()){
            ansStack.push(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!ansStack.isEmpty()){
            if (sb.toString().equals("") && ansStack.peek() == '0'){
                ansStack.pop();
                continue;
            }
            sb.append(ansStack.pop());
        }
        if (sb.toString().equals("")) sb.append("0");
        return sb.toString();
    }
}
