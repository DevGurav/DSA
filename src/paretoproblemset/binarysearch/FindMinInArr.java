package paretoproblemset.binarysearch;

// Problem: LeetCode 153 - Find Minimum in Rotated Sorted Array
// Pattern: Binary Search
// Core idea: Compare mid with right to decide which side contains rotation minimum.
// Invariant: The minimum element always remains inside [left, right].
// Complexity: O(log n) time, O(1) space.
// Dry run: [4,5,6,7,0,1,2] -> move left/right by mid-right comparison -> reach 0.
// Why this works: One side is sorted each step; the unsorted side must contain the pivot/minimum.
// Mental Trigger (simple): Compare mid with right; the side that looks broken contains the smallest value.
// When to use: Search space is monotonic (predicate flips once) or sorted order exists.
// Failure mode: Wrong boundary updates causing infinite loops or missing answer.
// Input edge cases: Single element, all true/all false predicates, duplicate keys.
// Brute -> Optimal jump: Replace linear scan with boundary narrowing using mid.
// Invariant break test: Answer always remains inside [lo, hi] after each update.
// Complexity trigger: Interval halves each step, giving logarithmic iterations.
// Common variant: lower_bound/upper_bound and answer-space binary search.
// Flow Dry Run (same order as code below):
// A) left=0, right=6, mid=3 -> nums[mid]=7 > nums[right]=2, move left to right side.
// B) left=4, right=6, mid=5 -> nums[mid]=1 <= nums[right]=2, move right=5.
// C) left=4, right=5, mid=4 -> nums[mid]=0 <= nums[right]=1, move right=4.
// D) left==right==4, return nums[4]=0.
//import java.util.Arrays;

class FindMinInArr {
    public int findMin(int[] nums) 
    {
        // Initial boundaries for binary search.
        int left = 0;
        int right = nums.length-1;
        // Recall: compare mid with right to locate the unsorted (pivot) side.
        while(left < right)
        {
            /*
             Loop Snapshot Example ([4,5,6,7,0,1,2]):
             left=0,right=6,mid=3 -> 7>2 so left moves right side
             left=4,right=6,mid=5 -> 1<=2 so right=5
            */
            // Mid index for current range.
            int mid = (left + right) / 2;
            if(nums[mid] > nums[right])
            {
             // Invariant check: minimum is strictly to the right of mid.
             left = mid++;
            }
            else
            {
             // Invariant check: minimum is at mid or to the left.
             right = mid;
            }
        }
      return nums[left];
    }
}



// public class FindMinInArr {
//     public int findMin(int[] nums) {

//         Arrays.sort(nums);

//         return nums[0];
        
//     }
//     public static void main(String args[])
//     {
//         FindMinInArr obj = new FindMinInArr();
//         int [] nums = {11,13,15,17};
//         System.out.print(obj.findMin(nums));
//     }
// }

