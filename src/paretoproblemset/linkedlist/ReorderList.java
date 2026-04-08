package paretoproblemset.linkedlist;

// Problem: LeetCode 143 - Reorder List
// Pattern: Linked List (Find Middle + Reverse + Merge)
// Core idea: Split list in half, reverse second half, then merge alternately.
// Invariant: During merge, first part order is preserved and second part contributes nodes in reverse order.
// Complexity: O(n) time, O(1) extra space.
// Dry run: 1->2->3->4->5 -> split 1->2->3 and 4->5, reverse to 5->4, merge => 1->5->2->4->3.
// Why this works: Alternating front-half nodes with reversed back-half nodes exactly creates required order L0, Ln, L1, Ln-1.
// Mental Trigger (simple): Find middle, reverse back half, then zip front and back nodes one by one.
// When to use: Node-level rewiring/traversal problems with O(1) extra space goals.
// Failure mode: Losing links during pointer updates or null checks in wrong order.
// Input edge cases: Empty list, one node, two nodes, cycle present at head.
// Brute -> Optimal jump: Avoid arrays; use pointer choreography (dummy/slow-fast/prev-curr).
// Invariant break test: Processed part remains valid and unprocessed part stays reachable.
// Complexity trigger: Single traversal with constant auxiliary pointers.
// Common variant: reverse segment, detect cycle, merge/reorder by pointers.
// Flow Dry Run (same order as code below):
// A) slow/fast find middle at node 3.
// B) Cut after middle, reverse second half (4->5 becomes 5->4).
// C) Merge alternately from first and reversed second halves.
// D) Final order: 1->5->2->4->3.
public class ReorderList {

    public class ListNode
    {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {

        // slow moves 1 step, fast moves 2 steps.
        ListNode slow, fast;
        slow = fast = head;
        // Recall: fast/slow pointers find middle of list.
        while (fast != null && fast.next != null) {
            /*
             Loop Snapshot Example (1->2->3->4->5):
             step1 -> slow=2, fast=3
             step2 -> slow=3, fast=5 (middle at slow)
            */
            slow = slow.next;
            fast = fast.next.next;
        }

        // Start of second half to reverse.
        ListNode curr = slow.next;

        // Invariant check: split list into first half and second half.
        slow.next = null;
        ListNode prev = null;
        // Temporary pointer for reverse process.
        ListNode tmp;
        // Recall: reverse second half in-place.
        while (curr != null) {
            /*
             Loop Snapshot Example (second half 4->5):
             step1 -> prev=4, curr=5
             step2 -> prev=5->4, curr=null
            */
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        // first walks first half, second walks reversed second half.
        ListNode first = head;
        ListNode second = prev;
        // Temporaries for stable alternating merge.
        ListNode tmp1, tmp2;
        // Recall: merge nodes alternately from first and reversed second halves.
        while (second != null) {
            /*
             Loop Snapshot Example (first:1->2->3, second:5->4):
             merge1 -> 1->5->2...
             merge2 -> 1->5->2->4->3
            */
            tmp1 = first.next;
            tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
        ListNode current = head;
        // Debug print of final reordered list.
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

