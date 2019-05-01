/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        //PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        
        ListNode head = null, prevNode = null;
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        
        while (pq.size() > 0) {
            ListNode ln = pq.poll();
            
            if (head == null) {
                head = ln;
            }
            if (prevNode != null) {
                prevNode.next = ln;
            }
            prevNode = ln;
            
            ListNode nextLN = ln.next;
            if (nextLN != null) {
                pq.offer(nextLN);
            }            
        }
        
        return head;
    }
}
