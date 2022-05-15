class Solution {
    public boolean isBalanced(TreeNode root) {
        return heightTree(root)!=-1;
    }
    public int heightTree(TreeNode root){
        if(root==null) return 0;
        else{
            int lheight=heightTree(root.left);
            int rheight=heightTree(root.right);
            if(lheight==-1 || rheight==-1) return -1;
            if(Math.abs(lheight-rheight)>1) return -1;
            return Math.max(lheight,rheight)+1;
        }
    }
}