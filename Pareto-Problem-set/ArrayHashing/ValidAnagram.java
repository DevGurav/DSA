// freqency array approach (charcater)

public class ValidAnagram {
    public boolean isAnagram(String s, String t)
    {

        // Step 1: If lengths are different → cannot be anagram
        if (s.length() != t.length())
        {
            return false;
        }

        // Step 2: Create frequency array for 26 lowercase letters
        int[] count = new int[26];

        // Step 3: Traverse both strings together
        // Increase count for s, decrease for t
        for (int i = 0; i < s.length(); i++)
        {

            // Example:
            // s = "anagram"
            // t = "nagaram"

            // For 'a' in s → +1
            count[s.charAt(i) - 'a']++;

            // For 'n' in t → -1
            count[t.charAt(i) - 'a']--;

            /*
             Dry Run (first few steps):

             i = 0:
             s[i] = 'a' → count['a']++
             t[i] = 'n' → count['n']--

             i = 1:
             s[i] = 'n' → count['n']++
             t[i] = 'a' → count['a']--

             → values cancel out if characters match in frequency
            */
        }

        // Step 4: Check if all counts are zero
        // If yes → valid anagram
        for (int c : count)
        {
            if (c != 0)
            {
                return false;
            }
        }

        return true;
    }
}


//by String to chararray then sorting it and check
// import java.util.Arrays;

// public class ValidAnagram {
//     public boolean isAnagram(String s, String t) {

//         if (s.length() != t.length()) {
//             return false;
//         }

//         char[] a = s.toCharArray();
//         char[] b = t.toCharArray();

//         Arrays.sort(a);
//         Arrays.sort(b);

//         return Arrays.equals(a, b);
//     }
// }

// LOGIC:
// Same length → use array[26]
// s → increment, t → decrement
// If all values = 0 → anagram

// s = "ab"
// t = "ba"

// count['a']++ → +1
// count['b']-- → -1

// count['b']++ → 0
// count['a']-- → 0

// Final array → all 0 → TRUE