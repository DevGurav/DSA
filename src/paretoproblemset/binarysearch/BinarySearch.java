package paretoproblemset.binarysearch;

// Problem: LeetCode 704    Classic Binary Search (sorted array)
// Pattern: Binary Search
// Core idea: Compare target with middle and discard half each iteration.
// Invariant: If target exists, it always lies within current [left, right] range.
// Complexity: O(log n) time, O(1) space.
// Dry run: [1,3,5,7,9], target=7 -> mid=5 then search right half -> found index 3.
// Why this works: Sorted order guarantees correct half can be eliminated after each comparison.
// Mental Trigger (simple): Middle check decides direction; every step throws away half of the impossible values.
// When to use: Search space is monotonic (predicate flips once) or sorted order exists.
// Failure mode: Wrong boundary updates causing infinite loops or missing answer.
// Input edge cases: Single element, all true/all false predicates, duplicate keys.
// Brute -> Optimal jump: Replace linear scan with boundary narrowing using mid.
// Invariant break test: Answer always remains inside [lo, hi] after each update.
// Complexity trigger: Interval halves each step, giving logarithmic iterations.
// Common variant: lower_bound/upper_bound and answer-space binary search.
// Flow Dry Run (same order as code below):
// A) left=0, right=4, mid=2 -> arr[mid]=5 < target, move left=3.
// B) left=3, right=4, mid=3 -> arr[mid]=7 == target.
// C) Return index 3.
public class BinarySearch {
    public int binarySearch(int[] arr, int target) {
        // Initial search boundaries.
        int left = 0, right = arr.length - 1;
        
        // Recall: discard half the search space on each comparison.
        while (left <= right) {
            /*
             Loop Snapshot Example (arr=[1,3,5,7,9], target=7):
             left=0,right=4,mid=2 -> arr[mid]=5 < 7, left=3
             left=3,right=4,mid=3 -> arr[mid]=7, found
            */
            int mid = left + (right - left) / 2; // avoids overflow (for large structures)
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                // Invariant check: target can only be in right half.
                left = mid + 1;
            } else {
                // Invariant check: target can only be in left half.
                right = mid - 1;
            }
        }
        
        return -1; // target not found case
    }
}

