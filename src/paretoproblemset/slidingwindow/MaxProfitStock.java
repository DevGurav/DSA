package paretoproblemset.slidingwindow;

// Problem: LeetCode 121 - Best Time to Buy and Sell Stock
// Pattern: Two Pointers / One Pass
// Core idea: Track lowest buy index so far and update max profit using current sell day.
// Invariant: i always points to best buy day seen before current j.
// Complexity: O(n) time, O(1) space.
// Dry run: [7,1,5,3,6,4] -> best profit updates to 5 (buy 1, sell 6).
// Why this works: Optimal sell on day j only depends on minimum price before j.
// Mental Trigger (simple): Keep cheapest buy seen so far, and at each day ask: if I sell today, is profit best yet?
// When to use: Need optimal subarray/substring over contiguous range.
// Failure mode: Expanding/shrinking conditions out of sync with window state.
// Input edge cases: Empty string/array, all same chars, k=0, window larger than input.
// Brute -> Optimal jump: Replace restarting scans with rolling expand-contract window.
// Invariant break test: Window always satisfies validity rule after adjustment.
// Complexity trigger: Each index enters/leaves window at most once (amortized O(n)).
// Common variant: fixed-size window sum vs variable-size constraint windows.
// Flow Dry Run (same order as code below):
// A) Start i=0, j=1, maxprofit=0.
// B) If prices[j] < prices[i], shift i to j as better buy day.
// C) Else compute currentprofit and update maxprofit.
// D) Increment j until end, then return maxprofit.
class MaxProfitStock {
    public int maxProfit(int[] prices) 
      {
                // maxprofit tracks best answer, currentprofit tracks current i-j gain.
        int maxprofit = 0,currentprofit;
                // i = buy pointer, j = sell pointer.
        int i = 0,j = 1,len = prices.length;

        if(len < 1)
        {
            return maxprofit;
        }

        else{
             // Recall: i is best buy day so far, j scans possible sell days.
             while(i < len && j < len)
                {
                      /*
                        Loop Snapshot Example ([7,1,5,3,6,4]):
                        j=1 -> price 1 < 7, set i=1
                        j=2 -> profit=5-1=4
                        j=4 -> profit=6-1=5 (best)
                      */
                 if(prices[i] > prices[j])
                    {
                   // Invariant check: found cheaper buy day, shift i to j.
                      i = j;
                      j++;
                      continue;
                    }
                 currentprofit = prices[j] - prices[i];
                 if(currentprofit > maxprofit)
                    {
                   // Invariant check: maxprofit always keeps best seen gain.
                      maxprofit = currentprofit;
                    }
                 j++;
                }
            }
        return maxprofit;
    }
    public static void main(String args[])
    {
        MaxProfitStock obj = new MaxProfitStock();
        int prices[] = {3,2};
        //System.out.println(prices.length <= 2);
        int maxprofit = obj.maxProfit(prices);
        System.out.print("maxprofit is "+maxprofit);
    }
}


// class Solution {
//     public int maxProfit(int[] prices) {
//         int min_price=Integer.MAX_VALUE;
//         int max_profit=0;
//         for(int i=0;i<prices.length;i++){
//             if(prices[i]<min_price){
//                 min_price=prices[i];
//             }
//             else if(prices[i]-min_price>max_profit){
//                 max_profit=prices[i]-min_price;
//             }
//         }
//         return max_profit;
//     }
// }

