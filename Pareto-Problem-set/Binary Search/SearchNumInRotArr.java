// Problem: LeetCode 33 - Search in Rotated Sorted Array
// Pattern: Binary Search on Rotated Array
// Core idea: Identify sorted half first, then check whether target lies inside that half.
// Invariant: Target, if present, always remains in the chosen search interval.
// Complexity: O(log n) time, O(1) space.
// Dry run: [4,5,6,7,0,1,2], target=0 -> narrow to right sorted half -> find index 4.
// Why this works: At least one half is sorted each step, enabling safe elimination of the other half.
// Mental Trigger (simple): First detect which half is sorted, then ask: is target inside that half? keep it, discard the other half.
// Flow Dry Run (same order as code below):
// A) l=0, r=6, mid=3 -> left half sorted, target outside it, move l=4.
// B) l=4, r=6, mid=5 -> left half sorted, target inside it, move r=4.
// C) l=4, r=4, mid=4 -> nums[mid]==target.
// D) Return 4.
public class SearchNumInRotArr {
    
    public int search(int[] nums, int target) {
        // Search boundaries on rotated array.
        int l = 0, r = nums.length - 1;

        // Recall: one side is always sorted in a rotated sorted array.
        while (l <= r) {
            /*
             Loop Snapshot Example ([4,5,6,7,0,1,2], target=0):
             l=0,r=6,mid=3 -> target outside left sorted half, l=4
             l=4,r=6,mid=5 -> target in left half, r=4
             l=4,r=4,mid=4 -> found
            */
            // Middle index of current boundary.
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) return mid;

            // Step 1: Identify which half is sorted
            if (nums[l] <= nums[mid]) { 
                // Left half [l...mid] is sorted
                if (target >= nums[l] && target < nums[mid]) {
                    // Invariant check: target remains in left sorted half.
                    r = mid - 1; // Target is in the sorted left half
                } else {
                    // Invariant check: target must be in the other half.
                    l = mid + 1; // Target is in the right half
                }
            } else { 
                // Right half [mid...r] is sorted
                if (target > nums[mid] && target <= nums[r]) {
                    // Invariant check: target remains in right sorted half.
                    l = mid + 1; // Target is in the sorted right half
                } else {
                    // Invariant check: target must be in the other half.
                    r = mid - 1; // Target is in the left half
                }
            }
        }
        return -1;
    }
}