package paretoproblemset.arrayhashing;

import java.util.Arrays;

// Problem: LeetCode 2974 - Minimum Number Game
// Pattern: Sorting + Pair Swap
// Core idea: Sort numbers, then swap every adjacent pair to simulate Alice then Bob picks.
// Invariant: After sorting, each pair (2k, 2k+1) is swapped once and no index is revisited.
// Complexity: O(n log n) time, O(1) extra space (ignoring sort implementation stack).
// Dry run: [5,4,2,3] -> sorted [2,3,4,5] -> swap pairs -> [3,2,5,4].
// Why this works: Sorted order guarantees smallest available elements are paired correctly each turn.
// Mental Trigger (simple): Sort first, then flip each consecutive pair.
// When to use: Repeated smallest-element game can be rewritten as sorted pair operations.
// Failure mode: Wrong loop increment or boundary can break pair alignment.
// Input edge cases: Empty array, length 2, already sorted, duplicates.
// Brute -> Optimal jump: Replace simulation with direct sorted pair transformation.
// Invariant break test: Every even index i should swap only with i+1.
// Complexity trigger: One sort pass + one linear pair pass.
// Common variant: Return new array instead of in-place mutation.
// Flow Dry Run (same order as code below):
// A) Sort nums ascending.
// B) For i=0,2,4... swap nums[i] and nums[i+1].
// C) Return transformed nums.
public class MinNumGame {
    public int[] numberGame(int[] nums) {
        // Sort to get deterministic pick order.
        Arrays.sort(nums);
        
        // Swap each adjacent pair.
        for (int i = 0; i < nums.length - 1; i += 2) {
            /*
             Loop Snapshot Example (sorted [2,3,4,5]):
             i=0 -> swap 2 and 3 -> [3,2,4,5]
             i=2 -> swap 4 and 5 -> [3,2,5,4]
            */
            // Standard in-place swap.
            int alicePick = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = alicePick;
        }
        
        return nums;
    }
}