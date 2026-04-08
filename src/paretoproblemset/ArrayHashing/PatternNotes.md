# Pattern Notes - Array Hashing

## When To Choose This Pattern
- Use when you need fast seen/complement/frequency checks.
- Choose when brute force compares many pairs or substrings repeatedly.
- Best for one-pass solutions where past elements are enough context.

## Template Skeleton
```java
Map<Key, Integer> map = new HashMap<>();
for (int i = 0; i < n; i++) {
    // 1) Query map/set using current value or complement.
    // 2) If match exists, return/update answer.
    // 3) Store current value into map/set.
}
```

## 3 Common Pitfalls
- Writing into map before checking and accidentally pairing same index.
- Forgetting duplicate handling policy (first index vs latest index).
- Using wrong key normalization (case, ordering, sign).
