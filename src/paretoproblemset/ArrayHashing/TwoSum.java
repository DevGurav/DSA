import java.util.HashMap;
import java.util.Map;

// Problem: LeetCode 1 - Two Sum
// Pattern: Array Hashing (HashMap)
// Core idea: For each value, compute complement = target - value and check if complement was seen before.
// Invariant: Map stores value -> index for all elements scanned so far.
// Complexity: O(n) time, O(n) space.
// Dry run: nums=[2,7,11,15], target=9 -> at i=1 complement=2 found -> return [0,1].
// Why this works: The first time complement is found in map, we have a valid pair of distinct indices.
// Mental Trigger (simple): Ask for missing partner (target-num); if already seen, answer is ready.
// When to use: Need O(1) average lookups for seen/complement/frequency checks.
// Failure mode: Duplicate handling mistakes (storing before checking can pair same index incorrectly).
// Input edge cases: Empty array, no solution, duplicate values, negative numbers.
// Brute -> Optimal jump: Replace nested scans with one-pass HashMap/HashSet bookkeeping.
// Invariant break test: Map/set reflects exactly the prefix processed so far.
// Complexity trigger: One pass with constant-time map operations dominates runtime.
// Common variant: frequency map counting, anagram grouping, prefix-hash lookups.
// Flow Dry Run (same order as code below):
// A) Start with empty map.
// B) For each index i, compute complement.
// C) If complement exists in map, return stored index with i.
// D) Else store current value and continue.
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Key = number , Value = its index.
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            /*
             Loop Snapshot Example (nums=[2,7,11,15], target=9):
             i=0 -> complement=7, not found, store 2->0
             i=1 -> complement=2, found at index 0, return [0,1]
            */
            int complement = target - nums[i];
            
            // If partner already exists, pair is complete.
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Store current value for upcoming elements.
            map.put(nums[i], i);
        }
        
        // Defensive fallback (LeetCode guarantees one valid answer for this problem).
        return new int[] {};
    }
}

