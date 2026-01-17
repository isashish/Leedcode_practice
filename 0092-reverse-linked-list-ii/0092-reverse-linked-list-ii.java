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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        ListNode prev = null;
        ListNode pres = head;

        for(int i = 0; pres != null && i < left-1; i++){
            prev = pres;
            pres = pres.next;
        }

        ListNode last = prev;
        ListNode newEnd = pres;

        ListNode pnext = newEnd.next;
        for(int i = 0; pres != null && i < right - left + 1; i++){
            pres.next = prev;
            prev = pres;
            pres = pnext;
            if(pnext != null){
                pnext = pnext.next;
            }
        }

        if(last != null){
            last.next = prev;
        } else{
            head = prev;
        }

        newEnd.next = pres;

        return head;
    }

   
}