// Problem: LeetCode 19 - Remove Nth Node From End of List
// Pattern: Linked List Two Pointers
// Core idea: Keep first pointer n+1 steps ahead of second, then move both until first ends.
// Invariant: Gap between first and second stays n+1, so second lands before node to remove.
// Complexity: O(n) time, O(1) space.
// Dry run: [1,2,3,4,5], n=2 -> second lands at 3, remove next (4).
// Why this works: Fixed pointer gap transforms "nth from end" into direct next-node deletion.
// Mental Trigger (simple): Create gap, move together, delete node after second.
// When to use: Node-level rewiring/traversal problems with O(1) extra space goals.
// Failure mode: Losing links during pointer updates or null checks in wrong order.
// Input edge cases: Empty list, one node, two nodes, cycle present at head.
// Brute -> Optimal jump: Avoid arrays; use pointer choreography (dummy/slow-fast/prev-curr).
// Invariant break test: Processed part remains valid and unprocessed part stays reachable.
// Complexity trigger: Single traversal with constant auxiliary pointers.
// Common variant: reverse segment, detect cycle, merge/reorder by pointers.
// Flow Dry Run (same order as code below):
// A) Create dummy before head and set first=second=dummy.
// B) Move first ahead n+1 times.
// C) Move both until first reaches null.
// D) second.next is target; bypass it.
public class RemoveNthNodeEnd {
    
 // Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Guard invalid cases.
        if (head == null || n <= 0)
            return head;

        // dummy simplifies deleting head node case.
        ListNode dummy = new ListNode(0, head);
        // first makes lead gap; second trails behind.
        ListNode first = dummy;
        ListNode second = dummy;

        // Build gap of n+1 between first and second.
        for (int i = 0; i <= n; i++) {
            /*
             Loop Snapshot Example (n=2):
             i=0 -> first moves to head
             i=1 -> first moves one ahead
             i=2 -> first moves two ahead
            */
            if (first == null)
                return head; // n > length
            first = first.next;
        }

        // Move together until first ends; second stops before node to delete.
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove nth-from-end node.
        second.next = second.next.next;
        return dummy.next;
    }
}

