/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr = head;
        while(curr != null){
            if(curr.child == null){
            curr = curr.next;
            }
            else{
                Node temp = curr.child;
                while(temp.next != null){
                    temp = temp.next;
                }
                if(curr.next != null){
                    temp.next = curr.next;
                    temp.next.prev = temp;
                }
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null;
                curr = curr.next;
            }
            
        }
        return head;
    }
}