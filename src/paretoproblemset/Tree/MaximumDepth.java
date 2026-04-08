package paretoproblemset.tree;

// Problem: LeetCode 104 - Maximum Depth of Binary Tree
// Pattern: Tree DFS (Recursion)
// Core idea: Depth of current node = 1 + max(depth of left subtree, depth of right subtree).
// Invariant: Each recursive call returns correct depth for its subtree root.
// Complexity: O(n) time, O(h) recursion stack space (h = tree height).
// Dry run: [3,9,20,null,null,15,7] -> left depth 1, right depth 2 -> answer 3.
// Why this works: Depth definition is naturally recursive and combines child answers optimally.
// Mental Trigger (simple): Node depth is one more than its deeper child.
// When to use: Rooted tree asks for height/depth/aggregate from children.
// Failure mode: Missing null base case leads to wrong depth or stack overflow.
// Input edge cases: Empty tree, single node, skewed tree.
// Brute -> Optimal jump: Avoid level simulation when recursive structure gives direct formula.
// Invariant break test: Returned value must equal exact subtree height at every node.
// Complexity trigger: Visit each node exactly once.
// Common variant: Min depth, balanced tree check, diameter with post-order DFS.
// Flow Dry Run (same order as code below):
// A) If node is null, return 0.
// B) Recursively compute left subtree depth.
// C) Recursively compute right subtree depth.
// D) Return 1 + max(leftDepth, rightDepth).
public class MaximumDepth
{

    public int maxDepth(TreeNode root)
    {
        // Empty subtree contributes depth 0.
        if(root==null)
        {
            return 0;
        }

        // Invariant check: node depth is one plus deeper child depth.
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));        
    }
}

