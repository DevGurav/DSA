# Revision Index

Use this during interview prep:
- Read only the `Invariant` and `Flow Dry Run` lines from each file.
- Skip full code unless you cannot reconstruct the logic.

| file | pattern | one-line trick |
|---|---|---|
| Pareto-Problem-set/ArrayHashing/ValidAnagram.java | Array Hashing | Increment for first string and decrement for second; all counts must end at zero. |
| Pareto-Problem-set/Binary Search/BinarySearch.java | Binary Search | On sorted data, one comparison safely removes half the range. |
| Pareto-Problem-set/Binary Search/FindMinInArr.java | Binary Search | Compare mid with right to detect whether minimum is in left or right side. |
| Pareto-Problem-set/Binary Search/FindMinInArrRepeated.java | Binary Search with Duplicates | If mid equals right, reduce right by one to remove ambiguity without losing minimum. |
| Pareto-Problem-set/Binary Search/FindNumInRotArr.java | Rotated Binary Search | One half is always sorted; choose by checking target range boundaries. |
| Pareto-Problem-set/Linked List/ReorderList.java | Linked List Split-Reverse-Merge | Find middle, reverse second half, then alternate nodes from first and second lists. |
| Pareto-Problem-set/Sliding Window/LongRepeating.java | Sliding Window | Keep window where windowLen - maxFreq <= k; shrink when replacements exceed k. |
| Pareto-Problem-set/Sliding Window/MaxProfitStock.java | One Pass / Two Pointers | Best sell today is based only on minimum buy seen before today. |
| Pareto-Problem-set/Sliding Window/UniqeSubStringLen.java | Sliding Window + HashSet | Expand right, and remove from left until the window becomes unique again. |
| Pareto-Problem-set/Stack/ValidParanthesis.java | Stack | Closing bracket must match the most recent unmatched opening bracket. |
| Pareto-Problem-set/Two Pointers/TwoSum.java | Two Pointers | In sorted arrays, moving left increases sum and moving right decreases sum. |
| Pareto-Problem-set/Two Pointers/ValidPalindrome.java | Normalization / Two Pointers | Remove irrelevant chars and case first, then palindrome check becomes direct. |
| Math Quest/DivByK.java | Modular Arithmetic | Track only remainder of repunit; remainder 0 means divisible. |
| Math Quest/PalindromeNum.java | Math Reverse Half | Reverse only half digits to compare mirrored halves efficiently. |
| Math Quest/SelfDivide.java | Digit Extraction | Every digit must be non-zero and divide the original number. |
| Math Quest/SumPivotInteger.java | Arithmetic Sum | Compare sum(1..i) and sum(i..n) using formulas in O(1) each i. |
| Math Quest/UglyNum.java | Factor Reduction | Repeatedly divide by 2, 3, and 5; leftover must be exactly 1. |
