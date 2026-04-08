import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

// Problem: LeetCode 49 - Group Anagrams
// Pattern: Array Hashing (Canonical Key)
// Core idea: Sort each string to form a canonical key; anagrams share the same sorted key.
// Invariant: map[key] always contains exactly those strings whose sorted form equals key.
// Complexity: O(n * k log k) time, O(n * k) space where n=str count, k=avg string length.
// Dry run: ["eat","tea","tan","ate","nat","bat"] -> keys: aet,aet,ant,aet,ant,abt.
// Why this works: Anagrams are permutations of same characters, so sorted representation is identical.
// Mental Trigger (simple): Normalize words by sorting letters, then bucket by normalized form.
// When to use: Need O(1) average lookups for seen/complement/frequency checks.
// Failure mode: Using mutable keys or inconsistent normalization.
// Input edge cases: Empty input array, empty strings, single word, duplicates.
// Brute -> Optimal jump: Replace pairwise anagram checks with one-pass hashing by canonical key.
// Invariant break test: Any two strings in same bucket must produce identical sortedKey.
// Complexity trigger: One map pass over words with local sort per word.
// Common variant: Use 26-count frequency signature as key instead of sorting.
// Flow Dry Run (same order as code below):
// A) Guard null/empty input.
// B) For each string, sort chars to build key.
// C) Create list if key missing, append original string.
// D) Return all grouped lists from map values.
public class GroupAnagram
{
    public List<List<String>> groupAnagrams(String[] strs) {
        // Guard edge case: no strings means no groups.
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        // key = sorted string, value = list of original anagrams.
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            /*
             Loop Snapshot Example:
             "eat" -> "aet" -> map["aet"]=["eat"]
             "tea" -> "aet" -> map["aet"]=["eat","tea"]
             "tan" -> "ant" -> map["ant"]=["tan"]
            */
            // Convert word to canonical sorted key.
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedKey = String.valueOf(chars);
            
            // Initialize group bucket when key appears first time.
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }
            // Add original word to its anagram bucket.
            map.get(sortedKey).add(s);
        }
        
        // Return grouped anagrams.
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) 
    {
        // Sample run.
        GroupAnagram obj = new GroupAnagram();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(obj.groupAnagrams(input));
        // Output: [[eat, tea, ate], [bat], [tan, nat]]
    }
}
