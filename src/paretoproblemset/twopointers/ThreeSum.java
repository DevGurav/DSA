// Problem: LeetCode 15 - 3Sum
// Pattern: Sorting + Two Pointers
// Core idea: Fix one number, then use two pointers to find remaining pair summing to negative fixed value.
// Invariant: Sorted order allows monotonic pointer movement and duplicate skipping for unique triplets.
// Complexity: O(n^2) time, O(1) extra space (excluding result list).
// Dry run: [-1,0,1,2,-1,-4] -> sorted [-4,-1,-1,0,1,2] -> triplets [-1,-1,2], [-1,0,1].
// Why this works: For each fixed i, two-sum-on-sorted-array finds all valid pairs without missing combinations.
// Mental Trigger (simple): Sort once, lock one value, and squeeze left/right pointers to hit sum zero.
// When to use: Relative movement from ends/speeds can eliminate candidates quickly.
// Failure mode: Pointer movement rule inconsistent with objective, skipping valid answers.
// Input edge cases: Very short input, duplicates, already optimal at boundaries.
// Brute -> Optimal jump: Replace pair enumeration with coordinated pointer moves.
// Invariant break test: Eliminated region cannot contain a better/valid answer.
// Complexity trigger: Each pointer advances monotonically, yielding linear time.
// Common variant: opposite-end scan, fast-slow cycle/middle detection, partitioning.
// Flow Dry Run (same order as code below):
// A) Sort array.
// B) Fix i, skip duplicate anchors.
// C) Move left/right based on sum; record triplets when sum==0 and skip duplicates.
// D) Continue for next i and return all unique triplets.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sorting enables duplicate handling and two-pointer movement.
        Arrays.sort(nums);
        // Stores all unique triplets summing to zero.
        List<List<Integer>> result = new ArrayList<>();
        // i selects first element of each triplet.
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // left/right search pair for fixed nums[i].
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                /*
                 Loop Snapshot Example (sorted [-4,-1,-1,0,1,2], i=1 => nums[i]=-1):
                 left=2,right=5 -> sum=0 add [-1,-1,2]
                 move and skip duplicates -> left=3,right=4 -> sum=0 add [-1,0,1]
                */
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}

