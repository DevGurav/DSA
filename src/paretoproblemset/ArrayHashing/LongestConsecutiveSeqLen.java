import java.util.HashSet;

// Problem: LeetCode 128 - Longest Consecutive Sequence
// Pattern: Array Hashing (HashSet + Sequence Start Check)
// Core idea: Only start expanding from numbers that do not have a predecessor (num-1 absent).
// Invariant: Every explored streak begins at a true sequence start and is counted exactly once.
// Complexity: O(n) average time, O(n) space.
// Dry run: nums=[100,4,200,1,3,2] -> starts at 1 -> streak 1,2,3,4 -> length 4.
// Why this works: Skipping non-start elements avoids repeated scans of the same sequence.
// Mental Trigger (simple): Build a set, then grow only from sequence starts.
// When to use: Need O(1) average lookups for seen/complement/frequency checks.
// Failure mode: Expanding from every element can degrade performance to repeated work.
// Input edge cases: Empty array, duplicates, negatives, single element.
// Brute -> Optimal jump: Replace sorting or nested checks with set membership and start detection.
// Invariant break test: If (num-1) exists, current num must not start a new streak.
// Complexity trigger: Each number participates in at most one forward expansion from a start.
// Common variant: Return actual longest sequence elements instead of just length.
// Flow Dry Run (same order as code below):
// A) Guard empty input.
// B) Insert all numbers into HashSet.
// C) For each number, if it is a start, expand forward while next exists.
// D) Track maximum streak length.

public class LongestConsecutiveSeqLen
{
	public int longestConsecutive(int[] nums)
    {
		// Empty input has no sequence.
        if (nums == null || nums.length == 0) return 0;

		// Set gives O(1) average existence checks.
		HashSet<Integer> set = new HashSet<>();
		for (int i : nums)
			set.add(i);

		int longseqlen = 0;

		for (int i : set)
		{
			// Start only when predecessor is absent.
			if (!set.contains(i - 1))
			{
				int currnum = i;
				int currseqlen = 1;

				/*
				 Loop Snapshot Example (start i=1 in set {1,2,3,4,100,200}):
				 currnum=1 -> 2 exists -> len=2
				 currnum=2 -> 3 exists -> len=3
				 currnum=3 -> 4 exists -> len=4
				*/
				while (set.contains(++currnum))
					currseqlen++;

				// Update best streak found so far.
				longseqlen = Math.max(currseqlen, longseqlen);
			}
		}

		return longseqlen;

    }
}
