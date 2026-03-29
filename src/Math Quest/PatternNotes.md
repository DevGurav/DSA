# Pattern Notes - Math Quest

## When To Choose This Pattern
- Use when direct math properties (divisibility, parity, factorial blocks, digit rules) can replace enumeration.
- Choose when constraints make brute force too large, but formulas reduce the state.
- Prefer when answer can be derived from invariant equations instead of full simulation.

## Template Skeleton
```java
// 1) Define the math relation/invariant.
// 2) Normalize indexing/base case (often 0-based or 1-based conversion).
// 3) Iterate through reduced state and update using the relation.
// 4) Guard overflow and boundary conditions.
// 5) Return constructed or validated result.
```

## 3 Common Pitfalls
- Off-by-one mistakes from 1-based vs 0-based math.
- Integer overflow in multiplication/exponent/factorial updates.
- Assuming divisibility/number properties without checking corner cases.
