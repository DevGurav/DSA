# Pattern Notes - Two Pointers

## When To Choose This Pattern
- Use when two moving indices can eliminate candidates quickly.
- Choose for sorted arrays, palindrome checks, partitioning, and meet-in-middle scans.
- Also use fast/slow pointers for cycle and middle-node tasks.

## Template Skeleton
```java
int left = 0, right = n - 1;
while (left < right) {
    // 1) Evaluate pair/state
    // 2) Move one pointer based on rule
    // 3) Update answer
}
```

## 3 Common Pitfalls
- Moving the wrong pointer and skipping valid candidates.
- Not handling duplicates when unique results are required.
- Mixing opposite-end and fast-slow pointer variants incorrectly.
