
// Problem: LeetCode 141 - Linked List Cycle
// Pattern: Fast and Slow Pointers (Floyd Cycle Detection)
// Core idea: Move slow by 1 step and fast by 2 steps; if a cycle exists they must meet.
// Invariant: Distance between fast and slow changes by 1 each iteration inside cycle, forcing a meeting.
// Complexity: O(n) time, O(1) space.
// Dry run: 3->2->0->-4 with tail pointing to node 2 -> slow and fast eventually meet -> true.
// Why this works: In a cycle, two pointers with different speeds cannot avoid collision forever.
// Mental Trigger (simple): Slow walks, fast runs; if loop exists, runner catches walker.
// Flow Dry Run (same order as code below):
// A) Guard null head.
// B) Initialize slow=head, fast=head.next.
// C) Move slow by one and fast by two while fast can move.
// D) If pointers meet return true; if fast reaches null return false.
public class ListCycle {
    public boolean hasCycle(ListNode head) {
        // Empty list cannot contain a cycle.
        if (head == null) return false;
        // slow moves 1 step, fast moves 2 steps.
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            /*
             Loop Snapshot Example (cycle exists):
             step1 -> slow moves 1, fast moves 2
             step2 -> gap shrinks inside cycle
             stepN -> slow == fast (meeting point)
            */
            // Meeting point means cycle detected.
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        // fast hit null, so list ended without loop.
        return false;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
