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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> s1 = new Stack<>();
        //push first half into the stack
        while(fast != null && fast.next != null){
            s1.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        //skip the middle element for odd linked list
        if(fast != null){
            slow = slow.next;
        }

        ListNode curr = slow;
        //campare second half with stack values
        while(curr != null){
            int top = s1.pop();
            if(curr.val != top){
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
}