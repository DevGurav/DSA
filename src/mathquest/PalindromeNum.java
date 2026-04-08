// Problem: LeetCode 9 - Palindrome Number
// Pattern: Math / Reverse Half
// Core idea: Reverse only the second half of digits, then compare with first half.
// Invariant: For palindrome numbers, first half equals reversed second half (middle digit ignored for odd length).
// Complexity: O(log10 n) time, O(1) space.
// Dry run: 1221 -> x becomes 12, reversedHalf becomes 12 -> true.
// Why this works: Pairwise mirror digits are matched without full reversal, preserving correctness and efficiency.
// Mental Trigger (simple): Reverse only the right half and compare both halves like a mirror.
// When to use: Use for math/combinatorics problems where formulas or numeric properties simplify search.
// Failure mode: Off-by-one indexing (especially 1-based vs 0-based) and overflow in intermediate math.
// Input edge cases: n=0/1, repeated values, large bounds, divisibility corner cases.
// Brute -> Optimal jump: Replace full enumeration with formula/modulo/factorial reasoning.
// Invariant break test: Each step should preserve the mathematical relation used by the algorithm.
// Complexity trigger: Work per state is constant with reduced state space from math insight.
// Common variant: prove feasibility first, then construct answer directly.
// Flow Dry Run (same order as code below):
// A) Start: x=1221, reversedHalf=0.
// B) Iteration 1 -> lastDigit=1, reversedHalf=1, x=122.
// C) Iteration 2 -> lastDigit=2, reversedHalf=12, x=12.
// D) Stop (x <= reversedHalf), x==reversedHalf so return true.
public class PalindromeNum {
    public boolean isPalindrome(int x) {
        
        // 1. Negative numbers are not palindromes (e.g., -121 != 121-)
        // 2. Numbers ending in 0 (except 0 itself) are not palindromes
        
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // Holds reversed digits of right half only.
        int reversedHalf = 0;
        // Recall: reverse only half the digits to avoid overflow and extra work.
        while (x > reversedHalf) {       //stops at middle if number 4 digit then stops at 2 if 3 stops at 2
            /*
             Loop Snapshot Example (x = 1221):
             step1 -> lastDigit=1, reversedHalf=1, x=122
             step2 -> lastDigit=2, reversedHalf=12, x=12 (stop)
            */
            // Extract current last digit from x.
            int lastDigit = x % 10;
            // Append extracted digit into reversed half.
            reversedHalf = (reversedHalf * 10) + lastDigit;
            x /= 10; // Remove the last digit from the original number
        }

        // When the loop stops, n is the first half and reversedHalf is the second half.
        // For even length: n == reversedHalf (e.g., 1221 -> 12 == 12)
        // For odd length: n == reversedHalf / 10 (e.g., 121 -> 1 == 12/10)
        // Invariant check: even length => x == reversedHalf, odd length => x == reversedHalf / 10.
        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        PalindromeNum obj = new PalindromeNum();
        System.out.println(obj.isPalindrome(121));  // true
        System.out.println(obj.isPalindrome(123));  // false
        System.out.print(obj.isPalindrome(10201));  // true
    }
}











//runtime 4ms
// public class PalindromeNum{
//     public boolean isPalindrome(int x) {
//         if(x<0){
//             return false;
//         }
//         int revers=0;
//         int r=0;
//         int temp=x;
//         while(x!=0){
//             r=x%10;
//             revers=revers*10+r;
//             x=x/10;
//         }
//         return temp==revers;
//     }
// }
