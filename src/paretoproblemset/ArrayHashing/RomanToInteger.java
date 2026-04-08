package paretoproblemset.arrayhashing;

// Problem: LeetCode 13 - Roman to Integer
// Pattern: String Parsing + Hash Lookup
// Core idea: Traverse from right to left; subtract when current symbol is smaller than previous, else add.
// Invariant: total always equals parsed value of suffix processed so far.
// Complexity: O(n) time, O(1) space.
// Dry run: "MCMXCIV" -> 1000 -100 +1000 -10 +100 -1 +5 = 1994.
// Why this works: Subtractive pairs are exactly cases where a smaller value appears before a larger one.
// Mental Trigger (simple): Right-to-left: smaller before bigger means subtract; otherwise add.
// When to use: Symbol-to-value conversion with local compare-based sign decision.
// Failure mode: Left-to-right parsing without careful pair handling can double-count.
// Input edge cases: Single character, repeated symbols, all additive forms, subtractive forms.
// Brute -> Optimal jump: Replace pair-pattern branching with one reverse scan and prev tracking.
// Invariant break test: prevValue must always be last processed symbol value from right side.
// Complexity trigger: Each character visited exactly once with constant-time lookup.
// Common variant: Left-to-right with next-character lookahead.
// Flow Dry Run (same order as code below):
// A) Build char->value lookup table.
// B) Initialize total=0 and prevValue=0.
// C) Scan from right to left, decide add/subtract by comparing with prevValue.
// D) Update prevValue and return total.
public class RomanToInteger
{
    public static int romanToInt(String s)
    {
        // Direct lookup table for Roman symbols.
        int[] values = new int[128];
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;

        int total = 0;
        int prevValue = 0;

        // Traverse from right to left to naturally handle subtractive cases.
        for (int i = s.length() - 1; i >= 0; i--) {
            /*
             Loop Snapshot Example ("MCMXCIV") from right:
             V(5) add, I(1) subtract, C(100) add, X(10) subtract,
             M(1000) add, C(100) subtract, M(1000) add.
            */
            // O(1) value retrieval using ASCII index.
            int currentValue = values[s.charAt(i)];

            // If smaller than previous right symbol, it is subtractive.
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            // Update previous value for next comparison on the left.
            prevValue = currentValue;
        }

        return total;
    }

    public static void main(String[] args)
    {
        String test = "MCMXCIV";
        System.out.println("Roman: " + test + " -> Integer: " + romanToInt(test));
    }

}
