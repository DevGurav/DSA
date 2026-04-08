# Revision Index

Use this during interview prep:
- Read only the `Invariant` and `Flow Dry Run` lines from each file.
- Skip full code unless you cannot reconstruct the logic.

| file | pattern | one-line trick |
|---|---|---|
| Math Quest/CheckArithmetic.java | Math + Position Mapping | Use min/max to get diff, then verify each value fits exactly one arithmetic slot. |
| Math Quest/PermutationSequence.java | Factorial Number System | Use factorial block sizes to directly pick each digit of the k-th permutation. |
| Pareto-Problem-set/ArrayHashing/ValidAnagram.java | Array Hashing | Increment for first string and decrement for second; all counts must end at zero. |
| Pareto-Problem-set/ArrayHashing/ContainsDuplicate.java | HashSet | Return true as soon as a seen number appears again. |
| src/Pareto-Problem-set/ArrayHashing/TwoSum.java | Array Hashing (HashMap) | For each number, check whether its required complement is already seen. |
| src/Pareto-Problem-set/ArrayHashing/TopKFreEle.java | Array Hashing + Heap | Count frequencies, then pop top k keys from a max-heap. |
| src/Pareto-Problem-set/ArrayHashing/GroupAnagram.java | Array Hashing (Canonical Key) | Sort each word to a key and group words with same key. |
| src/Pareto-Problem-set/ArrayHashing/ProductOfArray.java | Prefix-Suffix Products | Store left products, then multiply by running right product in reverse pass. |
| src/Pareto-Problem-set/ArrayHashing/LongestConsecutiveSeqLen.java | HashSet Sequence Start | Expand only from numbers with no predecessor to avoid repeated scans. |
| src/Pareto-Problem-set/ArrayHashing/MinNumGame.java | Sorting + Pair Swap | Sort, then swap each adjacent pair to match game picks. |
| src/Pareto-Problem-set/ArrayHashing/RomanToInteger.java | Reverse Parse + Lookup | Scan from right, subtract when current < previous, else add. |
| Pareto-Problem-set/Binary Search/BinarySearch.java | Binary Search | On sorted data, one comparison safely removes half the range. |
| Pareto-Problem-set/Binary Search/FindMinInArr.java | Binary Search | Compare mid with right to detect whether minimum is in left or right side. |
| Pareto-Problem-set/Binary Search/FindMinInArrRepeated.java | Binary Search with Duplicates | If mid equals right, reduce right by one to remove ambiguity without losing minimum. |
| Pareto-Problem-set/Binary Search/SearchNumInRotArr.java | Rotated Binary Search | One half is always sorted; choose by checking target range boundaries. |
| Pareto-Problem-set/Linked List/Merge2SortList.java | Linked List Merge | Always attach smaller head node to keep merged list sorted. |
| Pareto-Problem-set/Linked List/ListCycle.java | Fast and Slow Pointers | If slow and fast pointers meet, cycle exists. |
| Pareto-Problem-set/Linked List/LruCache.java | HashMap + Doubly Linked List | HashMap gives O(1) access, linked list tracks least-recently-used order. |
| Pareto-Problem-set/Linked List/RemoveNthNodeEnd.java | Two Pointers on Linked List | Keep n+1 gap, then delete node after slow pointer. |
| Pareto-Problem-set/Linked List/ReorderList.java | Linked List Split-Reverse-Merge | Find middle, reverse second half, then alternate nodes from first and second lists. |
| Pareto-Problem-set/Linked List/ReverseList.java | Linked List Iteration | Save next, reverse current link, then move forward. |
| Pareto-Problem-set/Sliding Window/LongRepeating.java | Sliding Window | Keep window where windowLen - maxFreq <= k; shrink when replacements exceed k. |
| Pareto-Problem-set/Sliding Window/MaxProfitStock.java | One Pass / Two Pointers | Best sell today is based only on minimum buy seen before today. |
| Pareto-Problem-set/Sliding Window/UniqeSubStringLen.java | Sliding Window + HashSet | Expand right, and remove from left until the window becomes unique again. |
| Pareto-Problem-set/Stack/DailyTemp.java | Monotonic Stack | Resolve colder days when a warmer day appears. |
| Pareto-Problem-set/Stack/MinStack.java | Dual Stack | Main stack stores values, min stack stores minimum history. |
| Pareto-Problem-set/Stack/ValidParanthesis.java | Stack | Closing bracket must match the most recent unmatched opening bracket. |
| Pareto-Problem-set/Two Pointers/ContainsMostWater.java | Two Pointers | Compute area and move the shorter wall to search better height. |
| Pareto-Problem-set/Two Pointers/ThreeSum.java | Sorting + Two Pointers | Fix one number, then run two-sum with duplicate skipping. |
| Pareto-Problem-set/Two Pointers/TwoSum2.java | Two Pointers | In sorted arrays, moving left increases sum and moving right decreases sum. |
| Pareto-Problem-set/Two Pointers/ValidPalindrome.java | Normalization / Two Pointers | Remove irrelevant chars and case first, then palindrome check becomes direct. |
| src/Pareto-Problem-set/Tree/MaxDepth.java | Tree DFS (Recursion) | Depth = 1 + max(leftDepth, rightDepth) with null base case 0. |
| src/Pareto-Problem-set/Tree/InvertBinaryTree.java | Tree BFS (Swap Children) | Traverse all nodes and swap left/right child pointers in-place. |
| src/Pareto-Problem-set/Tree/DiameterBinaryTree.java | Tree DFS (Post-order) | At each node, update diameter with leftHeight + rightHeight. |
| Math Quest/DivByK.java | Modular Arithmetic | Track only remainder of repunit; remainder 0 means divisible. |
| Math Quest/PalindromeNum.java | Math Reverse Half | Reverse only half digits to compare mirrored halves efficiently. |
| Math Quest/SelfDivide.java | Digit Extraction | Every digit must be non-zero and divide the original number. |
| Math Quest/SumPivotInteger.java | Arithmetic Sum | Compare sum(1..i) and sum(i..n) using formulas in O(1) each i. |
| Math Quest/UglyNum.java | Factor Reduction | Repeatedly divide by 2, 3, and 5; leftover must be exactly 1. |
