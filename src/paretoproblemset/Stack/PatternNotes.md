# Pattern Notes - Stack

## When To Choose This Pattern
- Use when you need nearest previous/next relationships.
- Choose for nested structure validation (parentheses, tags).
- Prefer monotonic stack when repeated backward checks appear.

## Template Skeleton
```java
Deque<Integer> st = new ArrayDeque<>();
for (int i = 0; i < n; i++) {
    while (!st.isEmpty() && shouldPop(st.peek(), i)) {
        st.pop();
    }
    // use st.peek() if needed
    st.push(i);
}
```

## 3 Common Pitfalls
- Wrong pop condition (`<` vs `<=`) changing tie behavior.
- Pushing value instead of index when index is required later.
- Forgetting final cleanup pass for unresolved elements.
