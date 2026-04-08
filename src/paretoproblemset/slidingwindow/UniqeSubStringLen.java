package paretoproblemset.slidingwindow;

// Problem: LeetCode 3 - Longest Substring Without Repeating Characters
// Pattern: Sliding Window + HashSet
// Core idea: Expand right; while duplicate exists, remove from left until window is unique.
// Invariant: Set always matches characters currently inside the window and contains no duplicates.
// Complexity: O(n) time, O(min(n, charset)) space.
// Dry run: "abcabcbb" -> best unique windows: "a","ab","abc" -> answer 3.
// Why this works: Each character enters and leaves window at most once, maintaining maximal valid windows.
// Mental Trigger (simple): Grow window with unique chars; when duplicate appears, shrink from left until clean again.
// When to use: Need optimal subarray/substring over contiguous range.
// Failure mode: Expanding/shrinking conditions out of sync with window state.
// Input edge cases: Empty string/array, all same chars, k=0, window larger than input.
// Brute -> Optimal jump: Replace restarting scans with rolling expand-contract window.
// Invariant break test: Window always satisfies validity rule after adjustment.
// Complexity trigger: Each index enters/leaves window at most once (amortized O(n)).
// Common variant: fixed-size window sum vs variable-size constraint windows.
// Flow Dry Run (same order as code below):
// A) Start with empty set, left=0, maxLength=0.
// B) For each right, shrink left while duplicate exists.
// C) Add current char and compute current window length.
// D) Update maxLength and continue to end.
import java.util.HashSet;
import java.util.Set;

class UniqeSubStringLen {
    public int lengthOfLongestSubstring(String s) {
        // Tracks characters currently inside the window.
        Set<Character> set = new HashSet<>();
        // left = window start, maxLength = best answer.
        int left = 0, maxLength = 0;
        // Recall: maintain window with unique characters only.
        for (int right = 0; right < s.length(); right++) {
            /*
             Loop Snapshot Example (s="abcabcbb"):
             right=0,1,2 -> window "abc", max=3
             right=3 ('a' duplicate) -> move left until duplicate removed
            */
            // Invariant check: remove from left until current char is no longer duplicate.
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        UniqeSubStringLen obj = new UniqeSubStringLen();
        String s = "abcabcbb";
        int result = obj.lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}    

