// Problem: LeetCode 155 - Min Stack
// Pattern: Stack + Auxiliary Min Stack
// Core idea: Normal stack stores all values; minStack stores current minimum history.
// Invariant: Top of minStack is always minimum of current stack.
// Complexity: O(1) for push/pop/top/getMin, O(n) space.
// Dry run: push -2,0,-3 -> min=-3; pop -> top=0, min=-2.
// Why this works: Every minimum candidate is tracked in sync, so minimum retrieval never needs full scan.
// Mental Trigger (simple): Keep a second stack of minima; whenever value is new minimum, push it there too.
// Flow Dry Run (same order as code below):
// A) push: add value to main stack, also to minStack if <= current min.
// B) pop: if popped value equals minStack top, pop minStack too.
// C) top: return main stack top.
// D) getMin: return minStack top.
import java.util.Stack;

public class MinStack {
    // Main stack keeps all values.
    private Stack<Integer> stack = new Stack<>();
    // minStack keeps only minimum history.
    private Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        // Always push to main stack.
        stack.push(val);
        // Push to minStack when val is new minimum (or first value).
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    public void pop() {
        // If current top is also current minimum, pop from minStack too.
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        // Pop actual value from main stack.
        stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
}
