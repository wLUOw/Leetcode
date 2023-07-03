import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String n1 = "", n2 = "";
        ListNode temp = l1, head;
        while (temp != null) {
            n1 += temp.val;
            temp = temp.next;
        }
        temp = l2;
        while (temp != null) {
            n2 += temp.val ;
            temp = temp.next;
        }
        BigInteger b1 = new BigInteger(n1);
        BigInteger b2 = new BigInteger(n2);
        String res = b1.add(b2).toString();
        int len = res.length();
        head = new ListNode(res.charAt(0) - '0');
        temp = head;
        for (int i = 1; i < len; i++) {
            temp.next = new ListNode(res.charAt(i) - '0');
            temp = temp.next;
        }
        return head;
    }
}
