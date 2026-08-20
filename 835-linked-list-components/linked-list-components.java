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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int n:nums){
            s.add(n);
        }
        int cnt=0;
        while(head!=null){
            if(s.contains(head.val) && ((head.next==null) || !s.contains(head.next.val))){
                cnt++;
            }
            head=head.next;
        }
        return cnt;
    }
}