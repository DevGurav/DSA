# Pattern Notes - Sliding Window

## When To Choose This Pattern
- Use for contiguous subarray/substring optimization.
- Choose when constraints can be maintained while expanding and shrinking.
- Great when brute force restarts work for each start index.

## Template Skeleton
```java
int left = 0;
for (int right = 0; right < n; right++) {
    // 1) Add right element to window state
    while (!windowValid()) {
        // 2) Remove left element and move left
        left++;
    }
    // 3) Update answer from current window
}
```

## 3 Common Pitfalls
- Updating answer before restoring window validity.
- Not removing state correctly when left moves.
- Mixing fixed-size and variable-size window logic.
