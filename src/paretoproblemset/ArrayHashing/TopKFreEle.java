package paretoproblemset.arrayhashing;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Arrays;

// Problem: LeetCode 347 - Top K Frequent Elements
// Pattern: Array Hashing + Heap (PriorityQueue)
// Core idea: Count frequencies with HashMap, then pop top k keys from a max-heap by frequency.
// Invariant: Map always stores final frequencies; heap comparator always prioritizes higher frequency.
// Complexity: O(n + m log m + k log m) time, O(m) space, where m is number of unique elements.
// Dry run: nums=[1,1,1,2,2,3], k=2 -> count={1:3,2:2,3:1} -> heap pops [1,2].
// Why this works: Frequency counting reduces the problem to ranking unique values by score.
// Mental Trigger (simple): First count, then extract top k by frequency.
// When to use: Need O(1) average lookups for seen/complement/frequency checks.
// Failure mode: Wrong heap comparator or polling more than available unique values.
// Input edge cases: Empty nums, k=0, k=uniqueCount, negative numbers.
// Brute -> Optimal jump: Replace full occurrence sorting with frequency map + heap on unique keys.
// Invariant break test: Every key in heap must exist in map with unchanged frequency.
// Complexity trigger: Build map once; operate mostly on unique elements, not raw length repeatedly.
// Common variant: Use min-heap of size k for O(m log k).
// Flow Dry Run (same order as code below):
// A) Build frequency map from nums.
// B) Build max-heap with comparator map.get(b)-map.get(a).
// C) Push all unique keys into heap.
// D) Poll k times to fill answer array.


// HashMap and Heap Priority Queue
public class TopKFreEle 
{

    public int[] topKFrequent(int[] nums, int k)
    {
        // key = number, value = frequency.
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each number.
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        // Max-heap: higher frequency should come first.
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        // Heap stores unique numbers only.
        pq.addAll(map.keySet());

        // Extract k most frequent numbers.
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            /*
             Loop Snapshot Example (map={1:4,2:3,3:1}, k=2):
             i=0 -> poll 1
             i=1 -> poll 2
            */
            res[i] = pq.poll();
        }

        return res;
        
    }

    public static void main(String args[])
    {
        // Sample run.
        TopKFreEle obj = new TopKFreEle();
        int [] input = { 1,1,1,1,2,2,2,3};
        System.out.println(Arrays.toString(obj.topKFrequent(input,2)));
    }
}





//Bucket Sort   // optimal
// Alternative 1 (Bucket Sort):
// Idea: Bucket index = frequency, then scan buckets from high to low.
//import java.util.*;

// public class TopK_Bucket {
//     public int[] topKFrequent(int[] nums, int k) {
//         // Count frequencies first.
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for (int n : nums)
//             map.put(n, map.getOrDefault(n, 0) + 1);

//         // bucket[f] stores all numbers appearing exactly f times.
//         List<Integer>[] bucket = new ArrayList[nums.length + 1];

//         for (int key : map.keySet()) {
//             int freq = map.get(key);
//             if (bucket[freq] == null)
//                 bucket[freq] = new ArrayList<>();
//             bucket[freq].add(key);
//         }

//         int[] res = new int[k];
//         int index = 0;

//         // Traverse from max frequency to min frequency.
//         for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
//             if (bucket[i] != null) {
//                 for (int num : bucket[i]) {
//                     res[index++] = num;
//                     if (index == k) break;
//                 }
//             }
//         }

//         return res;
//     }
// }


//HashMap Sorting 
// Alternative 2 (Sort by frequency):
// Idea: Put unique keys in list, sort list descending by map frequency, take first k.
// import java.util.*;

// public class TopK_Sorting {
//     public int[] topKFrequent(int[] nums, int k) {
//         // Count frequencies.
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for (int n : nums)
//             map.put(n, map.getOrDefault(n, 0) + 1);

//         // Sort unique keys by descending frequency.
//         List<Integer> list = new ArrayList<>(map.keySet());

//         list.sort((a, b) -> map.get(b) - map.get(a));

//         // Pick first k after sorting.
//         int[] res = new int[k];
//         for (int i = 0; i < k; i++)
//             res[i] = list.get(i);

//         return res;
//     }
// }