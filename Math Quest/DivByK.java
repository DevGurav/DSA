// Problem: LeetCode 1015 - Smallest Integer Divisible by K
// Pattern: Math / Modular Arithmetic
// Core idea: Build repunit remainders iteratively: rem = (rem*10 + 1) % k.
// Invariant: If remainder becomes 0 at length L, repunit of length L is divisible by k.
// Complexity: O(k) time, O(1) space.
// Dry run: k=3 -> remainders 1, 2, 0 -> answer length is 3.
// Why this works: Modulo tracks divisibility state exactly, avoiding huge number construction.
// Mental Trigger (simple): Keep only remainder while building 1, 11, 111...; first time remainder becomes 0, answer is length.
// Flow Dry Run (same order as code below):
// A) Start: k=3, remainder=0.
// B) len=1 -> remainder=(0*10+1)%3=1.
// C) len=2 -> remainder=(1*10+1)%3=2.
// D) len=3 -> remainder=(2*10+1)%3=0, return 3.
public class DivByK {
    public int smallestRepunitDivByK(int k)
    {
        // Recall: repunit (<--repeated unit) can never be divisible by 2 or 5.
        if (k % 2 == 0 || k % 5 == 0)  // 1 , 11 , 111 any number like this is not divisible by 2 and 5 multiples
        {
            return -1;
        }

        // Stores current remainder of repunit value modulo k.
        int remainder = 0;
        // Try repunit lengths from 1 to k (pigeonhole bound).
        for (int len = 1; len <= k; len++)
        {
            /*
             Loop Snapshot Example (k = 3):
             len=1 -> remainder=(0*10+1)%3=1
             len=2 -> remainder=(1*10+1)%3=2
             len=3 -> remainder=(2*10+1)%3=0 (return 3)
            */
            // Recall: next remainder simulates appending one more digit '1'.
            remainder = (remainder * 10 + 1) % k;
            // Invariant check: remainder == 0 means current length is divisible by k.
            if (remainder == 0)
            {
                return len;
            }
        }

        return -1;
    }

    public static void main ( String args[])
    {
        DivByK obj = new DivByK ();
        System.out.println(obj.smallestRepunitDivByK(1));
    }
}



// Runtime 1ms
// class Solution {
//     public int smallestRepunitDivByK(int k) {
//         if (k % 2 == 0 || k % 5 == 0) return -1;

//         int remainder = 1 % k;
//         int length = 1;

//         while (remainder != 0) {
//             remainder = (remainder * 10 + 1) % k;
//             length++;
//         }
//         return length;
//     }
// }