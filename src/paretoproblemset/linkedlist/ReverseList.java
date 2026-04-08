package paretoproblemset.linkedlist;

// Problem: LeetCode 206 - Reverse Linked List
// Pattern: Linked List Iteration
// Core idea: Reverse pointers one by one using prev, curr, and nextNode.
// Invariant: prev always points to already-reversed prefix, curr points to next node to process.
// Complexity: O(n) time, O(1) space.
// Dry run: 1->2->3->null -> after loop becomes 3->2->1->null.
// Why this works: Each node's next pointer is redirected exactly once while preserving forward traversal with nextNode.
// Mental Trigger (simple): Save next, flip arrow, move forward; repeat until end.
// When to use: Node-level rewiring/traversal problems with O(1) extra space goals.
// Failure mode: Losing links during pointer updates or null checks in wrong order.
// Input edge cases: Empty list, one node, two nodes, cycle present at head.
// Brute -> Optimal jump: Avoid arrays; use pointer choreography (dummy/slow-fast/prev-curr).
// Invariant break test: Processed part remains valid and unprocessed part stays reachable.
// Complexity trigger: Single traversal with constant auxiliary pointers.
// Common variant: reverse segment, detect cycle, merge/reorder by pointers.
// Flow Dry Run (same order as code below):
// A) prev=null, curr=head.
// B) Save next node.
// C) Point curr.next to prev, then shift prev and curr forward.
// D) When curr becomes null, prev is new head.
public class ReverseList {
    
 // Definition for singly-linked list.
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
    public ListNode reverseList(ListNode head) {
        // prev tracks reversed part; curr tracks remaining part.
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            /*
             Loop Snapshot Example (1->2->3):
             step1 -> prev=1, curr=2
             step2 -> prev=2->1, curr=3
             step3 -> prev=3->2->1, curr=null
            */
            // Save original next before changing pointers.
            ListNode nextNode = curr.next;
            
            // Reverse current node's link.
            curr.next = prev;
            
            // Advance both pointers.
            prev = curr;
            curr = nextNode;
        }

        // prev is new head after full reversal.
        return prev;
    }
}

