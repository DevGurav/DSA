// Problem: LeetCode 238 - Product of Array Except Self
// Pattern: Prefix-Suffix Products (Array Precomputation)
// Core idea: Store left products in result, then multiply by running right product in reverse pass.
// Invariant: Before suffix pass, result[i] = product of nums[0..i-1]; during suffix pass multiply by product of nums[i+1..n-1].
// Complexity: O(n) time, O(1) extra space (excluding output array).
// Dry run: nums=[1,2,3,4] -> left=[1,1,2,6], right pass gives [24,12,8,6].
// Why this works: Each answer is exactly left-product times right-product around index i.
// Mental Trigger (simple): First fill left products, then sweep right with one running multiplier.
// When to use: Need all-index aggregate except self without division.
// Failure mode: Wrong initialization (result[0] or rightProduct) causes full-array drift.
// Input edge cases: n=1, zeros in array, negatives, repeated values.
// Brute -> Optimal jump: Replace nested multiplication per index with two linear passes.
// Invariant break test: At any i in reverse pass, rightProduct must equal product of elements strictly right of i.
// Complexity trigger: Every element touched constant times across two passes.
// Common variant: explicit prefix[] + suffix[] arrays (simpler, but extra space).
// Flow Dry Run (same order as code below):
// A) Set result[0]=1.
// B) Left pass fills prefix product into result.
// C) Start rightProduct=1 and sweep from right to left.
// D) Multiply result[i] by rightProduct, then update rightProduct *= nums[i].
public class ProductOfArray
{
    public int[] productExceptSelf(int[] nums)
    {
        int n = nums.length;
        int[] result = new int[n];

        // Prefix pass: result[i] stores product of all elements to the left of i.
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            /*
             Loop Snapshot Example (nums=[1,2,3,4]):
             i=1 -> result[1]=1*1=1
             i=2 -> result[2]=1*2=2
             i=3 -> result[3]=2*3=6
            */
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Suffix pass: running product of elements to the right of current index.
        int rightProduct = 1; 
        for (int i = n - 1; i >= 0; i--) {
            // Invariant check: result[i] currently holds left product; multiply with right product.
            result[i] *= rightProduct;
            
            // Update running right product for next index on the left.
            rightProduct *= nums[i];
        }

        return result;
    }
}







// Alternative approach (clearer but extra space):
// Uses separate prefix[] and suffix[] arrays, then multiplies index-wise.
// Time O(n), extra space O(n) excluding output.
// public class ProductOfArray {
//     public int[] productExceptSelf(int[] nums) {
//         // prefix[i] = product of all elements left of i.
//         int[] prefix = new int[nums.length] ;
//         // suffix[i] = product of all elements right of i.
//         int[] suffix = new int[nums.length] ;
//         prefix[0] = 1 ;
//         // Build prefix products from left to right.
//         for(int i = 1 ; i<nums.length ; i++){
//             prefix[i] = prefix[i-1] * nums[i-1] ;
//         }
//         suffix[suffix.length-1] = 1 ;
//         // Build suffix products from right to left.
//         for(int i = nums.length-2 ; i>= 0 ; i--){
//             suffix[i] = suffix[i+1] * nums[i+1] ;
//         }
//         // Combine left and right products for each index.
//         int[] ans = new int[nums.length];
//         for(int i = 0 ; i < ans.length ; i++){
//             ans[i] = prefix[i] * suffix[i] ;
//         }
//         return ans ; 

//     }
// }