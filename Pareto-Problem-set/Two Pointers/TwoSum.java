// Problem: LeetCode 167 - Two Sum II (Input Array Is Sorted)
// Pattern: Two Pointers
// Core idea: Start at both ends and move pointers based on current sum vs target.
// Invariant: At each step, discarded pairs cannot become valid because array is sorted.
// Complexity: O(n) time, O(1) space.
// Dry run: [-10,-8,-2,1,2,5,6], target=0 -> move pointers -> (-2,2) found.
// Why this works: Sorting gives monotonic control; moving one pointer strictly increases or decreases the sum.
// Mental Trigger (simple): Small sum? move left rightward. Big sum? move right leftward. Sorted array guarantees this direction works.
// Flow Dry Run (same order as code below):
// A) Initialize left at start and right at end.
// B) Compute sum of both pointers.
// C) If sum too small move left, if too large move right.
// D) Stop and return when sum equals target.
class TwoSum
{
    public int[] twoSum(int[] numbers, int target) {
        // Two pointers on sorted array.
        int left = 0, right = numbers.length - 1;
        // Recall: sorted array lets us steer sum with pointer moves.
        while (left < right) {
            /*
             Loop Snapshot Example ([-10,-8,-2,1,2,5,6], target=0):
             left=-10,right=6,sum=-4 -> move left
             ... eventually left=-2,right=2,sum=0 -> return
            */
            int sum = numbers[left] + numbers[right];
            if (sum == target)
                return new int[]{left, right};
            else if (sum < target)
                // Invariant check: need a bigger sum, move left forward.
                left++;
            else
                // Invariant check: need a smaller sum, move right backward.
                right--;
        }
        return new int[] {};
    }
    public static void main (String args[])
    {
        TwoSum obj = new TwoSum();
        int numbers[] = {-10,-8,-2,1,2,5,6};
        int target = 0;
        int loc[] = obj.twoSum(numbers,target);
        System.out.print("index are "+loc[0] +" "+ loc[1]);
    }
}