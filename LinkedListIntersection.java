/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = findLength(headA);
        int bLength = findLength(headB);
        
        if (aLength > bLength) {
            int diff = aLength - bLength;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else if (bLength > aLength) {
            int diff = bLength - aLength;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    private int findLength(ListNode ln) {
        int count = 0;
        while(ln != null) {
            count++;
            ln = ln.next;
        }
        return count;
    }
}
