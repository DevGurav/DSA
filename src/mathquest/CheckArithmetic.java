// Problem: LeetCode 1502 - Can Make Arithmetic Progression From Sequence
// Pattern: Math + Hashing by Position
// Core idea: Use min/max to compute expected difference, then verify every value fits a valid arithmetic slot.
// Invariant: Every number must map to one unique index in progression formula (arr[i]-min)/diff.
// Complexity: O(n) time, O(n) space.
// Dry run: [1,3,5,7] -> min=1, max=7, diff=2, indices 0,1,2,3 all unique -> true.
// Why this works: Arithmetic progression is fully determined by min, max, and diff; valid mapping confirms exact structure.
// Mental Trigger (simple): Fix start and step; every number must land exactly once on its expected step position.
// When to use: Use for math/combinatorics problems where formulas or numeric properties simplify search.
// Failure mode: Off-by-one indexing (especially 1-based vs 0-based) and overflow in intermediate math.
// Input edge cases: n=0/1, repeated values, large bounds, divisibility corner cases.
// Brute -> Optimal jump: Replace full enumeration with formula/modulo/factorial reasoning.
// Invariant break test: Each step should preserve the mathematical relation used by the algorithm.
// Complexity trigger: Work per state is constant with reduced state space from math insight.
// Common variant: prove feasibility first, then construct answer directly.
// Flow Dry Run (same order as code below):
// A) Scan array to find min and max.
// B) Compute diff=(max-min)/(n-1), reject if not divisible.
// C) Map each value to index=(value-min)/diff and ensure valid + unique.
// D) If all values map correctly, return true.
public class CheckArithmetic {
    public boolean canMakeArithmeticProgression(int[] arr) {
        // Total number of values to place in progression.
        int n = arr.length;
        // Track smallest and largest value in array.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // First pass: determine min and max boundaries.
        for (int i = 0; i < n; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        // If range cannot be split evenly into n-1 gaps, impossible.
        if ((max-min) % (n-1) != 0) return false;
        // Expected common difference of progression.
        int diff = (max-min) / (n-1);
        // All equal values always form arithmetic progression.
        if (diff == 0) return true;
        // seen[idx] says whether expected slot idx is already occupied.
        boolean[] seen = new boolean[n];
        // Validate each number against expected slot.
        for (int i = 0; i < n; i++) {
            /*
             Loop Snapshot Example (arr=[1,3,5,7], min=1, diff=2):
             value=1 -> index=0 -> mark seen[0]
             value=3 -> index=1 -> mark seen[1]
             value=5 -> index=2 -> mark seen[2]
            */
            if ((arr[i]-min) % diff != 0) 
                return false;
            int index = (arr[i]-min) / diff;
            if (seen[index] == true) 
                return false; 
            seen[index] = true;
        }
        return true;
    }
    public static void main(String args[])
    {
        CheckArithmetic obj = new CheckArithmetic();
        int [] input = {1,3,5,7};
        System.out.println("result :" + obj.canMakeArithmeticProgression(input));
    }
}










// runtime 5ms

//import java.util.Arrays;

// public class CheckArithmetic {
//     public boolean canMakeArithmeticProgression(int[] arr) {
//         if(arr.length<=2)
//         {
//             return true;
//         }
//         Arrays.sort(arr);
//         int diff =arr[1]-arr[0];
//         for(int i=1;i<arr.length-1;i++)
//         {
//             if(diff!=(arr[i+1]-arr[i]))
//             return false;
//         }
//         return true;
//     }
// }
