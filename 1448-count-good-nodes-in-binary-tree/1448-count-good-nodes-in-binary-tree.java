/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result=0;
    public int goodNodes(TreeNode root) {
        if(root==null)return result;
        findGoodNodes(root, root.val);
        return result;
    }
    public void findGoodNodes(TreeNode node, int maxSoFar){
        if(node==null)return;
        if(node.val>=maxSoFar){
            result++;
            maxSoFar = node.val;
        }
        findGoodNodes(node.left, maxSoFar);
        findGoodNodes(node.right, maxSoFar);
    }
}