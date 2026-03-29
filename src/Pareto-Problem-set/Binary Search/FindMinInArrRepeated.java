// Problem: LeetCode 154 - Find Minimum in Rotated Sorted Array II
// Pattern: Binary Search with Duplicates
// Core idea: Compare mid with right; when equal, shrink right by one to break ambiguity.
// Invariant: The minimum is never discarded from the current [l, r] interval.
// Complexity: O(log n) average, O(n) worst-case time; O(1) space.
// Dry run input: [2,2,2,0,1]
// Why this works: Strict comparisons locate pivot side, and r-- preserves correctness when duplicates hide order.
// Mental Trigger (simple): Same as rotated minimum search, but when equal values confuse direction, drop one duplicate from right.
// Flow Dry Run (same order as code below):
// A) Start: l=0, r=4.
// B) Iteration 1: m=2, nums[m]=2, nums[r]=1 => nums[m] > nums[r], so l=m+1=3.
// C) Iteration 2: l=3, r=4, m=3, nums[m]=0, nums[r]=1 => nums[m] < nums[r], so r=m=3.
// D) Loop stops (l==r==3), return nums[3]=0.

public class FindMinInArrRepeated {

    public int findMin(int[] nums) 
    {
       // l points to left boundary of current search range.
       int l = 0;
       // r points to right boundary of current search range.
       int r = nums.length - 1;

        // Keep shrinking range until only one candidate index remains.
        while (l < r) 
        {
            /*
             Loop Snapshot Example ([2,2,2,0,1]):
             l=0,r=4,m=2 -> nums[m]>nums[r], l=3
             l=3,r=4,m=3 -> nums[m]<nums[r], r=3
            */
            // Middle index computed safely (avoids overflow pattern).
            int m = l + (r - l) / 2;
            
            // Case 1: mid value is greater than right value.
            // Minimum must be strictly on right side of mid.
            if (nums[m] > nums[r]) 
            {
                l = m + 1;
            } 
            // Case 2: mid value is smaller than right value.
            // Minimum is in left half including mid.
            else if (nums[m] < nums[r]) 
            {    
                r = m;
            } 
            // Case 3: nums[m] == nums[r].
            // Cannot decide side due to duplicates, so safely shrink r by one.
            else 
            {   
                r--;
            }
        }

        // When loop ends, l==r and both point to minimum element.
        return nums[l];
    }    
}