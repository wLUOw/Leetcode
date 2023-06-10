import java.util.HashMap;

public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode temp = head;
        int sum = 0;
        map.put(0, null);
        while (temp != null) {
            sum += temp.val;
            if (map.containsKey(sum)) {
                if (sum == 0) {
                    head = temp.next;
                    temp.next = null;
                    temp = head;
                    map = new HashMap<>();
                    map.put(sum, temp);
                } else {
                    ListNode next = temp.next;
                    ListNode node = map.get(sum);
                    int tempSum = sum;
                    ListNode tempNode = node;
                    while (tempNode != temp) {
                        tempNode = tempNode.next;
                        tempSum += tempNode.val;
                        map.remove(tempSum);
                    }
                    map.put(sum, node);
                    node.next = next;
                    temp.next = null;
                    temp = next;
                }
            } else {
                map.put(sum, temp);
                temp = temp.next;
            }
        }
        return head;
    }
}
