class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)return 0;
        return pathSum(root.left, targetSum) + includePathSum(root, targetSum) + pathSum(root.right, targetSum);
    }
    
    private int includePathSum(TreeNode root, int targetSum){
        if(root==null)return 0;
        int res =0;
        if(root.val==targetSum) res++;
        res+= includePathSum(root.left, targetSum- root.val);
        res+= includePathSum(root.right, targetSum- root.val);
        return res;
    }
}