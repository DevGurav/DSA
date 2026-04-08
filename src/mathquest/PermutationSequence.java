package mathquest;

import java.util.List;
import java.util.ArrayList;

// Problem: LeetCode 60 - Permutation Sequence
// Pattern: Factorial Number System / Combinatorics
// Core idea: Use block sizes ((n-1)!, (n-2)!, ...) to directly pick each digit of the k-th permutation.
// Invariant: After each pick, k is reduced to index within the remaining block and chosen digit is removed.
// Complexity: O(n^2) time (list removals), O(n) space.
// Dry run: n=4, k=9 -> picks 2,3,1,4 -> answer "2314".
// Why this works: Permutations are grouped in equal factorial-sized blocks by first digit, then second, and so on.
// Mental Trigger (simple): Use k to jump block-by-block, pick digit, remove it, continue with remaining digits.
// When to use: Use for math/combinatorics problems where formulas or numeric properties simplify search.
// Failure mode: Off-by-one indexing (especially 1-based vs 0-based) and overflow in intermediate math.
// Input edge cases: n=0/1, repeated values, large bounds, divisibility corner cases.
// Brute -> Optimal jump: Replace full enumeration with formula/modulo/factorial reasoning.
// Invariant break test: Each step should preserve the mathematical relation used by the algorithm.
// Complexity trigger: Work per state is constant with reduced state space from math insight.
// Common variant: prove feasibility first, then construct answer directly.
// Flow Dry Run (same order as code below):
// A) Build numbers=[1..n] and factorial array.
// B) Convert k to zero-based index (k--).
// C) For each position, pick index = k / blockSize, append and remove that digit.
// D) Update k = k % blockSize, repeat until all digits are picked.
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        // numbers stores currently available digits.
        List<Integer> numbers = new ArrayList<>();
        // factorial[i] stores i! for fast block-size lookup.
        int[] factorial = new int[n + 1];
        // Builds final permutation string.
        StringBuilder sb = new StringBuilder();

        int sum = 1;
        factorial[0] = 1;
        // Precompute factorials and fill available digits list.
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
            numbers.add(i);
        }

        // Convert 1-based k to 0-based index for block math.
        k--;

        // Build answer from left to right.
        for (int i = 1; i <= n; i++) {
            /*
             Loop Snapshot Example (n=4, k=9 => zero-based k=8):
             i=1 -> block=3!=6, index=8/6=1 -> pick 2, k=8%6=2
             i=2 -> block=2!=2, index=2/2=1 -> pick 3, k=2%2=0
             i=3 -> block=1!=1, index=0/1=0 -> pick 1
             i=4 -> block=0!=1, index=0/1=0 -> pick 4
            */
            // block size for current position.
            int index = k / factorial[n - i];
            // Append selected digit.
            sb.append(numbers.get(index));
            // Remove selected digit so it cannot be reused.
            numbers.remove(index);
            // Reduce k for next position within chosen block.
            k %= factorial[n - i];
        }

        return sb.toString();
    }

    public static void main(String args[])
    {
        PermutationSequence obj = new PermutationSequence();
        System.out.print(obj.getPermutation(4,9));
    }
}
// ^ runtime 1ms








//  my logic
//  suppose n = 3 and k = 4
//  then permutations are 123 , 132 , 213 , 231 , 312 , 321 --> 2
//  k = 4 therefore 231
//  permutation will be n! = n * (n-1) * (n-2) * ... * (n-n)
//  it will make (n-1)! pair of specific number at specific position
//  here consider 123 and 132 "1" at first position
//  1234 1243 1324 1342 1423 1432  --> 6
//  12345 12354 12435 12453 12534 12543 --> 24 (5-1)! = 24

//  24 / (5-1) = 6 = (5-2)! , 6 / 3 = 2 = (5-3)! , 2 / 2 = 1 = (5-4)! , 






// runtime 7ms 
// class PermutationSequence {
//     private static int[] fact = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    
//     private String getPermutation(int n, int k, boolean[] nums, char[] str, int index) {
//         int i = 0, m = nums.length;
//         if(n == 1) {
//             while(i < m && nums[i]) ++i;
//             str[index++]=(char)('0'+i+1);
//             return String.valueOf(str);
//         }
//         if(k == 0) {
//             while(i < m) {
//                 if(!nums[i]) str[index++]=(char)('0'+i+1);
//                 ++i;
//             }
//             return String.valueOf(str);
//         }
        
//         int div = k/fact[n-1], mod = k%fact[n-1], j = -1;
//         while(i < m-1 && div != j) {
//             if(!nums[i]) ++j;
//             if(j == div) break;
//             ++i;
//         }
//         str[index++]=(char)('0'+i+1);
//         if(i < m) nums[i]=true;
//         return getPermutation(n-1, mod, nums, str, index); 
//     }

//     public String getPermutation(int n, int k) {
//         boolean[] nums = new boolean[n];
//         char[] charArr = new char[n];
//         return getPermutation(n, k-1, nums, charArr, 0);
//     }
// }


// runtime 39ms
// class PermutationSequence {
//     public void swap(int[] a, int i, int j) {
//         int tmp = a[i];
//         a[i] = a[j];
//         a[j] = tmp;
//     }

//     public String toString(int[] a) {
//         StringBuilder sb = new StringBuilder();
//         for (int i : a) {
//             sb.append((char) ('0' + i));
//         }
//         return sb.toString();
//     }

//     public String getPermutation(int n, int k) {

//         int[] a = new int[n];
//         for (int i = 1; i <= n; i++) {
//             a[i - 1] = i;
//         }

//         while (k > 1) {
//             int j = n - 1;
//             while (j - 1 >= 0 && a[j - 1] >= a[j]) {
//                 j--;
//             }

//             int l = n - 1;
//             while (a[l] < a[j - 1]) {
//                 l--;
//             }

//             swap(a, j - 1, l);

//             l = n - 1;
//             while (j < l) {
//                 swap(a, j, l);
//                 j++;
//                 l--;
//             }
//             k--;
//         }

//         return toString(a);
//     }
// }
