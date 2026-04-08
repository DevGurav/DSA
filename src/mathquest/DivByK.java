package mathquest;

// Problem: LeetCode 1015 - Smallest Integer Divisible by K
// Pattern: Math / Modular Arithmetic
// Core idea: Build repunit remainders iteratively: rem = (rem*10 + 1) % k.
// Invariant: If remainder becomes 0 at length L, repunit of length L is divisible by k.
// Complexity: O(k) time, O(1) space.
// Dry run: k=3 -> remainders 1, 2, 0 -> answer length is 3.
// Why this works: Modulo tracks divisibility state exactly, avoiding huge number construction.
// Mental Trigger (simple): Keep only remainder while building 1, 11, 111...; first time remainder becomes 0, answer is length.
// When to use: Use for math/combinatorics problems where formulas or numeric properties simplify search.
// Failure mode: Off-by-one indexing (especially 1-based vs 0-based) and overflow in intermediate math.
// Input edge cases: n=0/1, repeated values, large bounds, divisibility corner cases.
// Brute -> Optimal jump: Replace full enumeration with formula/modulo/factorial reasoning.
// Invariant break test: Each step should preserve the mathematical relation used by the algorithm.
// Complexity trigger: Work per state is constant with reduced state space from math insight.
// Common variant: prove feasibility first, then construct answer directly.
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
// public class DivByK {
//     public int smallestRepunitDivByK(int k) {
//     // 1. Check Divisibility Rule: 
//     // Any number ending in 1 cannot be divided by an even number (2) or a multiple of 5.
//     // Example: If k = 2 or k = 5, we can never find a repunit (1, 11, 111...) that works.
//     if (k % 2 == 0 || k % 5 == 0) return -1;

//     // 2. Initialize with the first repunit: "1"
//     // remainder: result of 1 / k
//     // length: we have one digit so far
//     int remainder = 1 % k;
//     int length = 1;

//     // 3. Loop until the remainder is 0 (meaning the repunit is divisible by k).
//     // We only need to check up to 'k' times due to the Pigeonhole Principle.
//     while (remainder != 0) {
//         // 4. Generate the next repunit remainder:
//         // Mathematically: next_repunit = current_repunit * 10 + 1
//         // Example: If current is 11, next is 11 * 10 + 1 = 111.
//         // We apply % k to prevent overflow.
//         remainder = (remainder * 10 + 1) % k;
        
//         // 5. Increment digit count.
//         length++;
        
//         // Optimization Note: If we loop more than k times without finding 0, 
//         // we are in an infinite loop, but the k%2/k%5 check above prevents this.
//     }

//     // 6. Return the total count of '1's used.
//     return length;
// }
// }
