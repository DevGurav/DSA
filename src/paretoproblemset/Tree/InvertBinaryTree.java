package paretoproblemset.tree;

import java.util.LinkedList;
import java.util.Queue;

// Problem: LeetCode 226 - Invert Binary Tree
// Pattern: Tree BFS (Level Order Traversal)
// Core idea: Visit every node and swap its left and right child pointers.
// Invariant: Every node already popped from queue has its children inverted exactly once.
// Complexity: O(n) time, O(w) space (w = max width of tree).
// Dry run: [4,2,7,1,3,6,9] -> after swaps becomes [4,7,2,9,6,3,1].
// Why this works: Inverting at each node is independent; visiting all nodes guarantees full inversion.
// Mental Trigger (simple): For each node: swap left-right, then continue.
// When to use: Need to transform all nodes level-by-level or avoid recursion depth issues.
// Failure mode: Forgetting to enqueue children after swap can skip parts of tree.
// Input edge cases: Empty tree, single node, skewed tree.
// Brute -> Optimal jump: Avoid rebuilding a new tree; swap pointers in-place.
// Invariant break test: No node should be swapped twice or missed.
// Complexity trigger: One queue pass over all nodes.
// Common variant: Recursive DFS inversion with post/pre-order traversal.
// Flow Dry Run (same order as code below):
// A) Guard null root.
// B) Push root into queue.
// C) Pop node, swap children, enqueue non-null children.
// D) Repeat until queue empty and return root.

public class InvertBinaryTree 
{
    public TreeNode invertTree(TreeNode root) {
        // Empty tree remains empty after inversion.
        if(root == null)
        {
            return null;
        }

        // Queue for level-order traversal.
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            /*
             Loop Snapshot Example ([4,2,7,1,3,6,9]):
             pop 4 -> swap to (7,2)
             pop 7 -> swap to (9,6)
             pop 2 -> swap to (3,1)
            */
            TreeNode node = queue.poll();
            // Swap left and right pointers in-place.
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            // Continue traversal for next level.
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);

        }

        return root;
    }    
}


