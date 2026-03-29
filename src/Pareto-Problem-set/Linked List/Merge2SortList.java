// Problem: LeetCode 21 - Merge Two Sorted Lists
// Pattern: Linked List Merge
// Core idea: Repeatedly attach smaller current node from two sorted lists.
// Invariant: Merged list remains sorted after every attachment.
// Complexity: O(m+n) time, O(1) extra space.
// Dry run: [1,2,4] + [1,3,4] -> 1,1,2,3,4,4.
// Why this works: Choosing smaller head each time is locally optimal and globally preserves sorted order.
// Mental Trigger (simple): Compare two list heads, attach smaller one, move that list forward.
// Flow Dry Run (same order as code below):
// A) Start dummy and current pointer.
// B) While both lists non-empty, attach smaller node and move pointers.
// C) Attach remaining part of non-empty list.
// D) Return dummy.next.
public class Merge2SortList {

 //* Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy head to simplify building output list.
        ListNode dummy = new ListNode(0);
        // current always points to last node in merged list.
        ListNode current = dummy;

        // Merge while both lists have nodes.
        while (list1 != null && list2 != null) {
            /*
             Loop Snapshot Example ([1,2,4] and [1,3,4]):
             compare 1 and 1 -> take list2(1)
             compare 1 and 3 -> take list1(1)
             compare 2 and 3 -> take list1(2)
            */
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            // Move tail of merged list.
            current = current.next;
        }

        // One list ended; append the remaining nodes of the other list.
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Real merged head is after dummy.
        return dummy.next;

    }
}