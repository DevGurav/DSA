// Problem: LeetCode 11 - Container With Most Water
// Pattern: Two Pointers
// Core idea: Area is width * min(height[left], height[right]); move shorter side inward.
// Invariant: Keeping taller side and moving shorter side is the only chance to improve min-height bound.
// Complexity: O(n) time, O(1) space.
// Dry run: [1,8,6,2,5,4,8,3,7] -> best area 49 using heights 8 and 7 at width 7.
// Why this works: Moving taller side cannot increase limiting height, but moving shorter side might.
// Mental Trigger (simple): Water level is limited by shorter wall, so move that wall to search better pair.
// When to use: Relative movement from ends/speeds can eliminate candidates quickly.
// Failure mode: Pointer movement rule inconsistent with objective, skipping valid answers.
// Input edge cases: Very short input, duplicates, already optimal at boundaries.
// Brute -> Optimal jump: Replace pair enumeration with coordinated pointer moves.
// Invariant break test: Eliminated region cannot contain a better/valid answer.
// Complexity trigger: Each pointer advances monotonically, yielding linear time.
// Common variant: opposite-end scan, fast-slow cycle/middle detection, partitioning.
// Flow Dry Run (same order as code below):
// A) Start left=0, right=n-1.
// B) Compute area with current pair and update best.
// C) Move pointer at shorter height.
// D) Repeat until pointers meet.
public class ContainsMostWater {
    public int maxArea(int[] height) {
        // Left and right walls of container.
        int left = 0;
        int right = height.length - 1;
        // Best area seen so far.
        int maxarea = 0;
        while (left < right) {
            /*
             Loop Snapshot Example ([1,8,6,2,5,4,8,3,7]):
             left=0,right=8 -> area=8, move left
             left=1,right=8 -> area=49 (best), move right
            */
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int currentarea = h * width;
            maxarea = Math.max(maxarea, currentarea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }
}




//runtime 2ms
// public class ContainsMostWater {
//     public int maxArea(int[] height) {

//         int i=0,j=height.length-1;
//         int ans=0;

//         while(i<j){
//             int minH=Math.min(height[i], height[j]);
//             int area=(j-i)*minH;
//             ans=Math.max(area,ans);
//             while(i<j && height[i]<=minH) i++;
//             while(i<j && height[j]<=minH) j--;
//         }
//         return ans;
        
//     }
// }

