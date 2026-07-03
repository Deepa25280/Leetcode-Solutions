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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)return head;

        ListNode newHead = head.next;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next, nextPair;

        while(curr != null && curr.next != null){
            next = curr.next;
            nextPair = next.next;

             if(prev != null){
                prev.next = next;
            }
            next.next = curr;
            curr.next = nextPair;
            
           
            prev = curr;
            curr = nextPair;
        }
        return newHead;
    }
}