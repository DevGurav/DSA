// Problem: LeetCode 125 - Valid Palindrome
// Pattern: Two Pointers / String Normalization
// Core idea: Keep only alphanumeric chars in lowercase, then compare with reversed cleaned string.
// Invariant: If cleaned string equals its reverse, the original string is palindrome under problem rules.
// Complexity: O(n) time, O(n) space.
// Dry run: "A man, a plan, a canal: Panama" -> "amanaplanacanalpanama" -> equals reverse -> true.
// Why this works: Normalization removes all irrelevant differences, so equality check reflects true palindrome structure.
// Mental Trigger (simple): Ignore spaces/symbols/case first, then check if text reads same forward and backward.
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
