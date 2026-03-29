// Problem: LeetCode 739 - Daily Temperatures
// Pattern: Monotonic Stack (decreasing temperatures)
// Core idea: Store indices of unresolved days; when warmer day appears, resolve waiting days.
// Invariant: Stack indices always point to temperatures in decreasing order.
// Complexity: O(n) time, O(n) space.
// Dry run: [73,74,75,71,69,72,76,73] -> answers [1,1,4,2,1,1,0,0].
// Why this works: Each index is pushed once and popped once when next warmer day is found.
// Mental Trigger (simple): Stack keeps days still waiting for a warmer day; current warmer day clears them.
// When to use: Need nearest previous/next relation or properly nested structure checks.
// Failure mode: Pop conditions ordered incorrectly, causing missed matches.
// Input edge cases: Empty input, all increasing/decreasing values, unmatched symbols.
// Brute -> Optimal jump: Replace repeated backward checks with monotonic stack/history stack.
// Invariant break test: Stack ordering/property holds after every push/pop.
// Complexity trigger: Each element pushed and popped at most once.
// Common variant: monotonic stack for spans/next greater; bracket validation stack.
// Flow Dry Run (same order as code below):
// A) Iterate each day index i.
// B) While current temperature is warmer than stack top day, pop and fill answer.
// C) Push current index as unresolved day.
// D) Remaining indices in stack have answer 0.
import java.util.Stack;

public class DailyTemp {

    public int[] dailyTemperatures(int[] temperatures) {
        // Total number of days.
        int n = temperatures.length;
        // answer[i] = days until warmer temperature.
        int[] answer = new int[n];
        // Stack stores indices of unresolved colder days.
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            /*
             Loop Snapshot Example ([73,74,75]):
             i=0 push 0
             i=1 (74>73) pop 0 -> answer[0]=1, push 1
             i=2 (75>74) pop 1 -> answer[1]=1, push 2
            */
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;
    }
}



//runtime 8ms
// public class DailyTemp 
// {
//     public int[] dailyTemperatures(int[] temperatures) 
//     {
//         int n = temperatures.length;
//         int[] result = new int[n];
        
//         int[] stack = new int[n];
//         int top = -1; 
        
//         for (int i = n - 1; i >= 0; i--) 
//         {
            
//             while (top >= 0 && temperatures[stack[top]] <= temperatures[i]) 
//             {
//                 top--;
//             }
            
//             if (top == -1) {
//                 result[i] = 0;
//             } else {
//                 result[i] = stack[top] - i;
//             }
            
//             stack[++top] = i;
//         }
        
//         return result;
//     }
// }

