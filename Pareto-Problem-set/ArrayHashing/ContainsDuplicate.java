// Problem: LeetCode 217 - Contains Duplicate
// Pattern: HashSet
// Core idea: Add each number into set; if already present, duplicate exists.
// Invariant: Set contains unique elements seen so far.
// Complexity: O(n) time, O(n) space.
// Dry run: [1,2,3,1] -> when reading last 1, set already has 1 -> true.
// Why this works: HashSet membership check is fast and directly answers "seen before?".
// Mental Trigger (simple): If add fails because number already seen, duplicate is found instantly.
// Flow Dry Run (same order as code below):
// A) Start empty set.
// B) Read each number.
// C) If number already in set return true, else add it.
// D) End without repeats -> return false.
import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        // Stores all numbers observed so far.
        HashSet<Integer> number = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            /*
             Loop Snapshot Example ([1,2,3,1]):
             read 1 -> add
             read 2 -> add
             read 3 -> add
             read 1 -> already present -> true
            */
            if(number.contains(nums[i]))
            {
                return true;
            }
            number.add(nums[i]);
        }
        return false;
    }    
}





//runtime 2ms
// public class ContainsDuplicate {
//     public boolean containsDuplicate(int[] nums) {
//         int n = nums.length;
//         for (int i = 1; i < n; i++) {
//             int key = nums[i];
//             int j = i - 1;

//             // Shift elements that are greater than the key
//             while (j >= 0 && nums[j] > key) {
//                 nums[j + 1] = nums[j];
//                 j--;
//             }

//             // If the loop stopped because nums[j] == key, we found it!
//             if (j >= 0 && nums[j] == key) return true;

//             // Otherwise, place the key in its sorted position
//             nums[j + 1] = key;
//         }
//         return false;
//     }
// }



// import java.util.HashSet;

// public class ContainsDuplicate {
//     public boolean containsDuplicate(int[] nums){
//         HashSet<Integer> seenNumbers = new HashSet<>(nums.length * 2);
//         for (int num : nums) {          // avoids index lookup nums[i]
//             if (!seenNumbers.add(num)){  // add() returns false if duplicate exists
//                 return true;  
//             }          // one operation instead of contains() + add()
//         }
//         return false;
//     }
// }