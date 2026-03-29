// Problem: LeetCode 728 - Self Dividing Numbers
// Pattern: Digit Extraction
// Core idea: For each number, test every digit: non-zero and divides original number.
// Invariant: Number is valid iff all extracted digits pass both checks.
// Complexity: O((right-left+1) * digits) time, O(output) space.
// Dry run: 36 -> digits 6 and 3 both divide 36 -> include 36.
// Why this works: Base-10 decomposition checks exactly the local condition required for every digit.
// Mental Trigger (simple): Every digit must be non-zero and must divide the full number without remainder.
// Flow Dry Run (same order as code below):
// A) Pick num=36, set x=36, flag=true.
// B) digit=6 -> valid (36%6==0), update x=3.
// C) digit=3 -> valid (36%3==0), update x=0.
// D) Loop ends with flag=true, add 36 to result.
import java.util.List;
import java.util.ArrayList;
//import java.util.Arrays;

public class SelfDivide {
    public List<Integer> selfDividingNumbers(int left, int right) 
    {
        // Stores all valid self-dividing numbers.
        List<Integer> result = new ArrayList<>();
        // x is working copy of num; digit is extracted last digit.
        int x , digit;   //for operation
        
        
        // 1-9 all 35 35 % 10 = 5 and 35 / 10 = 3
        // 1234 1234 % 10 = 4 , n /= 10 -> 123 123 % 10 = 3 goes on 

        // Invalid range guard.
        if (left > right) return new ArrayList<>();

        // Recall: validate each number independently by scanning its digits.
        for(int num = left;num <= right; num++ )
            {
                if (num <= 0)
                {
                    continue;
                }
                // Becomes false as soon as one digit violates rule.
                boolean flag =true;
                x = num;
                while(x > 0)
                {
                    /*
                     Loop Snapshot Example (num = 36):
                     x=36 -> digit=6, valid, x becomes 3
                     x=3  -> digit=3, valid, x becomes 0 (add 36)
                    */
                    // Extract last digit for validation.
                    digit = x % 10;
                    // Invariant check: every digit must be non-zero and divide original num.
                    if( digit == 0 || num % digit != 0)
                    {
                        flag = false;
                        break;
                    }
                    x /= 10;
                }
                if(flag == true) //if number is self divided , adds in the result 
                result.add(num);
            }
        return result;
    }

    public static void main (String args[])
    {
        SelfDivide obj = new SelfDivide();
        List <Integer> selfdivide = new ArrayList<>();
        selfdivide = obj.selfDividingNumbers(47,85);
        System.out.print(selfdivide);
        //System.out.println("result is "+ Arrays.asList(selfdivide));
    }
}
