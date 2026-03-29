// Problem: LeetCode 20 - Valid Parentheses
// Pattern: Stack
// Core idea: Push opening brackets; on closing bracket, top must be matching opener.
// Invariant: Stack always stores unmatched opening brackets in correct order.
// Complexity: O(n) time, O(n) space.
// Dry run: "([{}])" -> push ( [ {, then pop on } ] ) -> stack empty -> true.
// Why this works: Every close bracket must match the most recent unmatched opener (LIFO rule).
// Mental Trigger (simple): Opening brackets go into stack; each closing bracket must close the latest opening one.
// When to use: Need nearest previous/next relation or properly nested structure checks.
// Failure mode: Pop conditions ordered incorrectly, causing missed matches.
// Input edge cases: Empty input, all increasing/decreasing values, unmatched symbols.
// Brute -> Optimal jump: Replace repeated backward checks with monotonic stack/history stack.
// Invariant break test: Stack ordering/property holds after every push/pop.
// Complexity trigger: Each element pushed and popped at most once.
// Common variant: monotonic stack for spans/next greater; bracket validation stack.
// Flow Dry Run (same order as code below):
// A) Start with empty stack.
// B) Push each opening bracket.
// C) On closing, verify stack top pair and pop.
// D) End with empty stack => true, otherwise false.
import java.util.Stack;

public class ValidParanthesis {
    public boolean isValid(String s) {
        // Stack holds unmatched opening brackets.
        Stack<Character> stack=new Stack<Character>();
        // i scans the string from left to right.
        int i=0;
         if(s.length()%2!=0){
            return false;
        }
        // Recall: push openings, match and pop on closings.
        while(i<s.length()){
            /*
             Loop Snapshot Example ("([{}])"):
             read '(' '[' '{' -> push all
             read '}' ']' ')' -> pop matching tops
            */
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[' ){
                stack.push(s.charAt(i));
            }
            else{ 
                if(stack.isEmpty()){
                    return false;
                }
                else if(s.charAt(i)==')' && stack.peek()=='('|| s.charAt(i)=='}'&& stack.peek()=='{' || s.charAt(i)==']' && stack.peek()=='['){
                // Invariant check: closing bracket must match stack top opener.
                stack.pop();
                
            }
            else if(s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}'){
                return false;

            }

            
        }   
        i++;                    
    }
        // Invariant check: valid expression leaves no unmatched opening brackets.
    return stack.isEmpty();
  }
}







// memory optimized 


// 41.7 mb
// public boolean isValid(String s) {
//         Stack<Character> stack = new Stack<>();
//         for(char c:s.toCharArray()){
//             if(c=='(') stack.push(')');
//             else if(c=='[') stack.push(']');
//             else if(c=='{') stack.push('}');
//             else{
//                 if(stack.isEmpty() || stack.pop() != c){
//                     return false;
//                 }
//             }
//         }
//         return stack.isEmpty();
//     }



// 40.2 mb
// class Solution {
//     public boolean check(char bh , char ch){
//         if(bh =='(' && ch == ')' || bh == '[' && ch == ']' || bh == '{' && ch == '}'){
//             return true;
//         }
//         return false;
//     }
//     public boolean isValid(String s) {
//         Stack<Character> st = new Stack<>();
//         for(int i=0; i<s.length(); i++){
//             char ch =  s.charAt(i);
//             if(ch == '(' || ch == '[' || ch == '{'){
//                 st.push(ch);
//             }
//             else{
//                 if(st.isEmpty()){
//                     return false;
//                 }
//                 else{
//                     char bh = st.peek();
//                     if(check(bh, ch) == true){
//                         st.pop();
//                     }
//                     else{
//                         return false;
//                     }
//                 }
//             }
//         }
//         if(!st.isEmpty()){
//             return false;
//         }
//         return true;
//     }
// }


