/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListFindCycle {
    
    ListNode first = null;
    
    public boolean hasCycle(ListNode head) {
        first = head;
        while (head != null) {
            if (head.next == first) {
                return true;
            }
            ListNode temp = head.next;
            head.next = first;
            head = temp;
        }
        return false;
    }
}
