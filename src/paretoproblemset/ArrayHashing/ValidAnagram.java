package paretoproblemset.arrayhashing;

// Problem: LeetCode 242 - Valid Anagram
// Pattern: Array Hashing (Frequency Count)
// Core idea: Increment counts for s and decrement for t in one pass.
// Invariant: All counts must be zero at end for strings to be anagrams.
// Complexity: O(n) time, O(1) space (26 lowercase letters).
// Dry run: s="ab", t="ba" -> +a,+b and -b,-a => all zeros -> true.
// Why this works: Matching frequency vectors is equivalent to anagram equality.
// Mental Trigger (simple): Add for first word, subtract for second word; if every letter balances to zero, both words use the same letters.
// When to use: Need O(1) average lookups for seen/complement/frequency checks.
// Failure mode: Duplicate handling mistakes (storing before checking can pair same index incorrectly).
// Input edge cases: Empty array, no solution, duplicate values, negative numbers.
// Brute -> Optimal jump: Replace nested scans with one-pass HashMap/HashSet bookkeeping.
// Invariant break test: Map/set reflects exactly the prefix processed so far.
// Complexity trigger: One pass with constant-time map operations dominates runtime.
// Common variant: frequency map counting, anagram grouping, prefix-hash lookups.
// Flow Dry Run (same order as code below):
// A) Start count[26]=0.
// B) i=0 -> +count['a'], -count['b'].
// C) i=1 -> +count['b'], -count['a'].
// D) Final count array all zeros, return true.
// freqency array approach (charcater)

public class ValidAnagram {
    public boolean isAnagram(String s, String t)
    {

        // Step 1: If lengths are different -> cannot be anagram
        if (s.length() != t.length())
        {
            return false;
        }

        // Step 2: Create frequency array for 26 lowercase letters
        // count[c] stores net frequency difference for character c.
        int[] count = new int[26];

        // Step 3: Traverse both strings together
        // Increase count for s, decrease for t
        for (int i = 0; i < s.length(); i++)
        {

            // Example:
            // s = "anagram"
            // t = "nagaram"

            // For 'a' in s -> +1
            count[s.charAt(i) - 'a']++;

            // For 'n' in t -> -1
            count[t.charAt(i) - 'a']--;

            // Invariant check: net frequency difference is tracked at each step.

            /*
             Dry Run (first few steps):

             i = 0:
             s[i] = 'a' -> count['a']++
             t[i] = 'n' -> count['n']--

             i = 1:
             s[i] = 'n' -> count['n']++
             t[i] = 'a' -> count['a']--

             -> values cancel out if characters match in frequency
            */
        }

        // Step 4: Check if all counts are zero
        // If yes -> valid anagram
        // If any character has non-zero net count, strings differ.
        for (int c : count)
        {
            if (c != 0)
            {
                return false;
            }
        }

        return true;
    }
}


//by String to chararray then sorting it and check
// import java.util.Arrays;

// public class ValidAnagram {
//     public boolean isAnagram(String s, String t) {

//         if (s.length() != t.length()) {
//             return false;
//         }

//         char[] a = s.toCharArray();
//         char[] b = t.toCharArray();

//         Arrays.sort(a);
//         Arrays.sort(b);

//         return Arrays.equals(a, b);
//     }
// }

// LOGIC:
// Same length -> use array[26]
// s -> increment, t -> decrement
// If all values = 0 -> anagram

// s = "ab"
// t = "ba"

// count['a']++ -> +1
// count['b']-- -> -1

// count['b']++ -> 0
// count['a']-- -> 0

// Final array -> all 0 -> TRUE

