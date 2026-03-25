// Problem: LeetCode 2485 - Find the Pivot Integer
// Pattern: Math / Arithmetic Sum
// Core idea: For each i, compare sum(1..i) and sum(i..n) using formulas.
// Invariant: A pivot exists only when both computed sums are exactly equal.
// Complexity: O(n) time, O(1) space.
// Dry run: n=8 -> i=6 gives left=21 and right=21 -> return 6.
// Why this works: Formula-based sums are exact, so equality directly verifies pivot definition.
// Mental Trigger (simple): Try each center value i and compare left sum and right sum formulas; equal means pivot found.
// Flow Dry Run (same order as code below):
// A) Start n=8.
// B) i=2 -> lsum=3, rsum=35 (not equal), continue.
// C) i=6 -> lsum=21, rsum=21 (equal).
// D) Return 6.
class SumPivotInteger {
    public int pivotInteger(int n) {
        // Base case where pivot is trivially 1.
        if(n==1)
        {
            return 1;
        }
        // lsum: sum(1..i), rsum: sum(i..n).
        int lsum,rsum;
        // Recall: try each candidate pivot i and compare exact formula sums.
        for(int i=2;i<n;i++)
        {
            /*
             Loop Snapshot Example (n = 8):
             i=2 -> lsum=3, rsum=35 (not pivot)
             i=6 -> lsum=21, rsum=21 (pivot found)
            */
            lsum = (i*(i+1)/2);
            rsum = ((n-i+1)*(i+n)/2);
            // Invariant check: pivot exists only when left sum equals right sum.
            if(lsum==rsum)
            {
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[])
    {
       SumPivotInteger obj = new SumPivotInteger();
       int pivot = obj.pivotInteger(49);
       System.out.print("sum pivot element is "+pivot);
    }
}