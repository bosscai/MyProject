package LeetCode.LC145;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.addTwoNumbers();
    }
    public ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        // write code here
        int carry = 0;
        ListNode head = null;
        ListNode head_temp = head;
        while (l1 != null && l2 != null){
            ListNode listNode = new ListNode();
            int temp = l1.val + l2.val + carry;
            if (temp > 9){
                listNode.val = temp - 10;
                carry = temp/10;
            }else {
                listNode.val = temp;
                carry = temp/10;
            }
            head.next = listNode;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            ListNode listNode = new ListNode();
            listNode.val = l1.val;
            head.next = listNode;
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null){
            ListNode listNode = new ListNode();
            listNode.val = l2.val;
            head.next = listNode;
            head = head.next;
            l2 = l2.next;
        }
        if (carry != 0){
            ListNode listNode = new ListNode();
            listNode.val = carry;
            head.next = listNode;

        }
        return head_temp.next;
    }
}
class ListNode {
    int val;
    ListNode next = null;
}