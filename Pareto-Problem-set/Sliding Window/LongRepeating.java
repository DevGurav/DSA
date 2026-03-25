// Problem: LeetCode 424 - Longest Repeating Character Replacement
// Pattern: Sliding Window
// Core idea: Keep largest valid window where replacements needed does not exceed k.
// Invariant: Window is valid when (window length - maxFreqInWindow) <= k.
// Complexity: O(n) time, O(1) space (fixed alphabet).
// Dry run: "AABABBA", k=1 -> max valid length encountered is 4.
// Why this works: maxFreqInWindow captures the dominant char, so difference gives exact replacements needed.
// Mental Trigger (simple): Keep a window where non-majority letters are at most k; if too many, move left.
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


    // my logic

    //     int count = 0;
    //     // if(s.charAt(0) == s.charAt(1)){
    //     //     count = 2;
    //     // }
    //     // else 
    //     // {
    //     //     count = 1;
    //     // }
    //     char a = 'A';
    //     //char b = 'B';
    //     int countA = 0,countB = 0;

    //     //for(int i = 0;i<1;i++)
    //     //{
    //         if(a == s.charAt(0))
    //         {
    //             ++countA ;
    //         }
    //         else
    //             ++countB ;
    //     //}
    //     int maxcount = 0;
        
    //     for(int left = 0,right = 1; left < s.length() && right < s.length(); right++)
    //     {
        
    //         if ( (right - left + 1) - count > k)
    //         {
    //             if(a == s.charAt(left))
    //             {
    //                 countA--;
    //             }
    //             else
    //             {
    //                 countB--;
    //             }
    //             left++;
    //         }
    //         if ( a == s.charAt(right))
    //         {
    //             ++countA;
    //         }
    //         else 
    //         {
    //             ++countB;
    //         }
            
    //         count = countA > countB ? countA : countB;
    //         if (maxcount < count)
    //         {
    //             maxcount = count;
    //         }
    //     }
    //     return maxcount + k;
    // }



/*
class Solution {
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