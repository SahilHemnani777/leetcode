class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    public boolean validate(TreeNode root,long leftRange,long rightRange){
        if(root==null) return true;
        
        if(leftRange>=root.val || rightRange<=root.val) return false;
        
        return validate(root.left,leftRange,root.val) && validate(root.right,root.val,rightRange);
    }
}