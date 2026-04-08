// Problem: LeetCode 424 - Longest Repeating Character Replacement
// Pattern: Sliding Window
// Core idea: Keep largest valid window where replacements needed does not exceed k.
// Invariant: Window is valid when (window length - maxFreqInWindow) <= k.
// Complexity: O(n) time, O(1) space (fixed alphabet).
// Dry run: "AABABBA", k=1 -> max valid length encountered is 4.
// Why this works: maxFreqInWindow captures the dominant char, so difference gives exact replacements needed.
// Mental Trigger (simple): Keep a window where non-majority letters are at most k; if too many, move left.
// When to use: Need optimal subarray/substring over contiguous range.
// Failure mode: Expanding/shrinking conditions out of sync with window state.
// Input edge cases: Empty string/array, all same chars, k=0, window larger than input.
// Brute -> Optimal jump: Replace restarting scans with rolling expand-contract window.
// Invariant break test: Window always satisfies validity rule after adjustment.
// Complexity trigger: Each index enters/leaves window at most once (amortized O(n)).
// Common variant: fixed-size window sum vs variable-size constraint windows.
// Flow Dry Run (same order as code below):
// A) Initialize freq[], left=0, maxFreqInWindow=0, bestLength=0.
// B) Expand right, update char frequency and maxFreqInWindow.
// C) While replacements needed > k, move left and decrease outgoing char count.
// D) Update bestLength for each valid window and return final bestLength.
class LongRepeating {  
    public int characterReplacement(String s,int k){

        
        // Empty input guard.
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Frequency map for uppercase letters in current window.
        int[] freq = new int[26];
        // left = window start.
        int left = 0;
        // max frequency of any char inside current window.
        int maxFreqInWindow = 0;
        // best window length found so far.
        int bestLength = 0;

        // Recall: expand right; shrink left only when replacements exceed k.
        for (int right = 0; right < s.length(); right++) {
            /*
             Loop Snapshot Example (s="AABABBA", k=1):
             right=0..3 -> window grows, bestLength reaches 4
             later when invalid -> move left until valid again
            */
            int index = s.charAt(right) - 'A';
            freq[index]++;
            maxFreqInWindow = Math.max(maxFreqInWindow, freq[index]);

            // Invariant check: window must satisfy (size - maxFreqInWindow) <= k.
            while ((right - left + 1) - maxFreqInWindow > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            

            bestLength = Math.max(bestLength, right - left + 1);
        }

        return bestLength;
    }

    public static void main (String args[])
    {
        LongRepeating obj = new LongRepeating();
        String s = "ABCDAMBLABAA";
        int k = 3;
        int maxcount = obj.characterReplacement(s,k);
        System.out.print(maxcount);

    }
}


    

/*
class LongRepeating {
    public int characterReplacement(String s, int k) {

        int[] count = new int[26];
        int left = 0, maxCount = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            int currentFreq = ++count[s.charAt(right) - 'A'];

            maxCount = Math.max(maxCount, currentFreq);

            if ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
*/

