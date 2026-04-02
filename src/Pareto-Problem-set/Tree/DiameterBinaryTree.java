
// Problem: LeetCode 543 - Diameter of Binary Tree
// Pattern: Tree DFS (Post-order)
// Core idea: At each node, compute left/right heights and update diameter with leftHeight + rightHeight.
// Invariant: height(node) returns correct subtree height; maxDiameter stores best edge-count seen so far.
// Complexity: O(n) time, O(h) recursion stack space (h = tree height).
// Dry run: [1,2,3,4,5] -> best path 4-2-1-3 has 3 edges.
// Why this works: The longest path through any node is exactly sum of left and right subtree heights.
// Mental Trigger (simple): Height comes up from children; diameter is best left+right split.
// When to use: Need longest path/edge-count in tree while doing one DFS pass.
// Failure mode: Mixing node-count and edge-count conventions.
// Input edge cases: Empty tree, single node, skewed tree.
// Brute -> Optimal jump: Avoid recomputing subtree heights for each node separately.
// Invariant break test: maxDiameter never decreases; returned height is always 1 + max(child heights).
// Complexity trigger: Each node visited once in post-order recursion.
// Common variant: Tree height/balance/maximum path style problems with one traversal.
// Flow Dry Run (same order as code below):
// A) Initialize maxDiameter=0.
// B) DFS height(root).
// C) At node, compute leftHeight and rightHeight.
// D) Update maxDiameter with leftHeight+rightHeight, return 1+max(leftHeight,rightHeight).
public class DiameterBinaryTree 
{
    // Tracks maximum diameter in edge count across all nodes.
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // Fill maxDiameter via post-order height DFS.
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode node) {
        // Empty subtree has height 0.
        if (node == null) return 0;

        // Recursive calls to get heights of left and right subtrees.
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Invariant check: path through current node uses left edges + right edges.
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return current subtree height to parent.
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

//Definition for a binary tree node.
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}