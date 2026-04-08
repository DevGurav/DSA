// Problem: LeetCode 125 - Valid Palindrome
// Pattern: Two Pointers / String Normalization
// Core idea: Keep only alphanumeric chars in lowercase, then compare with reversed cleaned string.
// Invariant: If cleaned string equals its reverse, the original string is palindrome under problem rules.
// Complexity: O(n) time, O(n) space.
// Dry run: "A man, a plan, a canal: Panama" -> "amanaplanacanalpanama" -> equals reverse -> true.
// Why this works: Normalization removes all irrelevant differences, so equality check reflects true palindrome structure.
// Mental Trigger (simple): Ignore spaces/symbols/case first, then check if text reads same forward and backward.
// When to use: Relative movement from ends/speeds can eliminate candidates quickly.
// Failure mode: Pointer movement rule inconsistent with objective, skipping valid answers.
// Input edge cases: Very short input, duplicates, already optimal at boundaries.
// Brute -> Optimal jump: Replace pair enumeration with coordinated pointer moves.
// Invariant break test: Eliminated region cannot contain a better/valid answer.
// Complexity trigger: Each pointer advances monotonically, yielding linear time.
// Common variant: opposite-end scan, fast-slow cycle/middle detection, partitioning.
// Flow Dry Run (same order as code below):
// A) Normalize input to cleaned lowercase alphanumeric string.
// B) Build reverse string from cleaned.
// C) Compare cleaned and reverse.
// D) Equal => true, else false.
//import java.util.*;


class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // Recall: normalize first so punctuation/case no longer matter.
        // cleaned holds only lowercase alphanumeric chars.
        String cleaned = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
         // reverse is reverse representation of cleaned.
         String reverse = reverseString(cleaned);
        // Invariant check: palindrome condition is direct equality after normalization.
        if(cleaned.equals(reverse))
        {
            //System.out.print("string is palindrome");
            return true;
        }
        return false;
    }
    public String reverseString( String cleaned)
        {
            // Builds reversed string from end to start.
            String reverse = "";
            // Recall: build reversed order from end to start.
            for (int i = cleaned.length() - 1; i >= 0; i--) {
                /*
                 Loop Snapshot Example (cleaned="aba"):
                 i=2 -> reverse="a"
                 i=1 -> reverse="ab"
                 i=0 -> reverse="aba"
                */
                reverse += cleaned.charAt(i);
            }
            return reverse;
        }
    public static void main(String[] args) {
        ValidPalindrome obj = new ValidPalindrome();
        String input = "A man, a plan, a canal: Panama";
        boolean result = obj.isPalindrome(input);
        System.out.println("Is palindrome: " + result);
    }
}







//runtime 2ms
// public class ValidPalindrome {
//     public boolean isPalindrome(String s) {
//         String newString = s.toLowerCase();
//         int i = 0, j = newString.length() - 1;
//         while(i < j) {
//             while(i < j && !Character.isLetterOrDigit(newString.charAt(i))) i++;
//             while(i < j && !Character.isLetterOrDigit(newString.charAt(j))) j--;
//             if(newString.charAt(i) != newString.charAt(j)) return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
// }

