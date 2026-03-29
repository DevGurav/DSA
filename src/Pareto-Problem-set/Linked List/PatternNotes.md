# Pattern Notes - Linked List

## When To Choose This Pattern
- Use when operations are naturally pointer-based (reverse, merge, detect cycle, reorder).
- Choose when O(1) extra space is expected.
- Prefer when local rewiring is cheaper than copying to arrays.

## Template Skeleton
```java
ListNode dummy = new ListNode(0);
dummy.next = head;
ListNode prev = dummy, curr = head;
while (curr != null) {
    // 1) Save next pointer(s)
    // 2) Rewire links safely
    // 3) Advance pointers
}
return dummy.next;
```

## 3 Common Pitfalls
- Losing the rest of list by overwriting `.next` too early.
- Missing null checks before fast/next-next access.
- Returning wrong head when dummy node is required.
