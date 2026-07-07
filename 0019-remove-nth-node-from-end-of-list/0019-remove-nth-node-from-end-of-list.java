/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int count = 0;
        while(curr != null){
            curr = curr.next;
            count++;
        }

        if(n == count){
            head = head.next;
            return head;
        }
        else{
            ListNode temp = head;
            ListNode prev = null;
            int cnt = 0;
            while(cnt != (count - n)){
                prev = temp;
                temp = temp.next;
                cnt++;
            }
            if(temp.next == null){
                prev.next = null;
                return head;
            }
            prev.next = temp.next;
            return head;
        }

    }
}