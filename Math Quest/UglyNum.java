// Problem: LeetCode 263 - Ugly Number
// Pattern: Math / Repeated Division
// Core idea: Repeatedly divide n by 2, 3, and 5 whenever possible.
// Invariant: If n has only allowed prime factors, divisions eventually reduce it to 1.
// Complexity: O(log n) time, O(1) space.
// Dry run: 60 -> 30 -> 15 -> 5 -> 1, so answer is true.
// Why this works: Every valid factor is removed; any leftover >1 means a forbidden prime factor exists.
// Mental Trigger (simple): Keep dividing by 2, 3, 5 only; if you can reduce to 1, number is ugly.
// Flow Dry Run (same order as code below):
// A) Start n=60.
// B) Divide by 2 repeatedly: 60 -> 30 -> 15.
// C) Divide by 3 once: 15 -> 5.
// D) Divide by 5 once: 5 -> 1, return true.
public class UglyNum {
    public boolean isUgly(int n)
    {
        // Non-positive numbers are invalid by definition.
        if(n <= 0)
        {
            return false;
        }

        if(n == 1)
        {
            return true;
        }
        
        // Recall: keep stripping allowed prime factors only (2, 3, 5).
        while(n != 1)
        {
            /*
             Loop Snapshot Example (n = 60):
             60 -> divide by 2 -> 30
             30 -> divide by 2 -> 15
             15 -> divide by 3 -> 5
             5  -> divide by 5 -> 1
            */
            //example 60 60/2 30/2 15/2! 15/3 5/2! 5/3! 5/5 1
            if(n%2 == 0)
            {
                // Strip factor 2.
                n /= 2;
            }
            else if(n%3 == 0)
            {
                // Strip factor 3.
                n /= 3;
            }
            else if(n%5 == 0)
            {
                // Strip factor 5.
                n /= 5;
            }
            else
            {
                // Invariant check: leftover factor outside {2,3,5} means not ugly.
                return false;
            }
        }
        return true;
    }
    
    public static void main(String args[])
    {
        UglyNum obj = new UglyNum();
        System.out.print(" number is ugly "+ obj.isUgly(0));
    }
}


// runtime 0ms
// public class UglyNum {
//     public boolean isUgly(int n) {
//         // 1. Edge Case: Ugly numbers must be positive.
//         // Example: If n = 0 or n = -8, return false immediately.
//         if (n <= 0) {
//             return false;
//         }

//         // 2. Remove all factors of 2.
//         // Example: If n = 12, it becomes 6, then 3.
//         while (n % 2 == 0) {
//             n = n / 2;
//         }

//         // 3. Remove all factors of 3.
//         // Example: If n = 3, it becomes 1.
//         while (n % 3 == 0) {
//             n = n / 3;
//         }

//         // 4. Remove all factors of 5.
//         // Example: If n = 25, it becomes 5, then 1.
//         while (n % 5 == 0) {
//             n = n / 5;
//         }

//         // 5. Check the remainder.
//         // If the remaining number is 1, it means it only had 2, 3, or 5 as factors.
//         // If n > 1 (e.g., n = 7), it means there was another prime factor involved.
//         return n == 1;        
//     }
// }