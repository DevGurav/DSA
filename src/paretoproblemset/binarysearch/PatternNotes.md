# Pattern Notes - Binary Search

## When To Choose This Pattern
- Use when search space is sorted or monotonic.
- Choose when a boolean condition flips exactly once.
- Useful for both index search and answer-space optimization.

## Template Skeleton
```java
int lo = 0, hi = n - 1;
while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;
    if (condition(mid)) {
        // move one boundary
    } else {
        // move the other boundary
    }
}
```

## 3 Common Pitfalls
- Infinite loop from not shrinking bounds correctly.
- Using wrong loop condition (`<` vs `<=`) for chosen variant.
- Forgetting duplicate behavior (first/last occurrence target).
