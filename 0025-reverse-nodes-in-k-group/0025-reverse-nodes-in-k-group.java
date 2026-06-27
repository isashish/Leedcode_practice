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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }
        int count = 0;
        ListNode curr = head;
        ListNode grSt = head;
        ListNode prevGrEnd = null;
        ListNode newHead = head;
        while(curr != null){
            count ++;

            if(count%k == 0) {
                ListNode nextGr = curr.next;
                //Reverse current group
                ListNode prev = nextGr;
                ListNode temp = grSt;
                while (temp != nextGr) {
                    ListNode next = temp.next;
                    temp.next = prev;
                    prev = temp;
                    temp = next;
                }
                if(prevGrEnd == null)
                    newHead = curr;
                else
                    prevGrEnd.next = curr;
                prevGrEnd = grSt;
                grSt = nextGr;
                curr = nextGr;
            }
            else {
                curr = curr.next;
            }
        }
        return newHead;
    }
}