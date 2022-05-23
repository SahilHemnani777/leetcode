class Solution {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        dfs(root);
    }
    
    void  dfs(TreeNode root) {
        if(root == null)
            return;
        if(pre == null)
            pre = root;
        else {
            pre.right = root;
            pre.left = null;
            pre = root;
        }
        TreeNode next = root.right;
        
        dfs(root.left);
        dfs(next);
        
    }
}