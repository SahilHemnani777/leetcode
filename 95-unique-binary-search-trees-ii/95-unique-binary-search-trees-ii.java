class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    public List<TreeNode> helper(int st, int end){
        if(st>end){
            List<TreeNode> base = new ArrayList<>();
            base.add(null);
            return base;
        }// base case
        ArrayList<TreeNode> ans = new ArrayList<>();
        for(int i=st; i<=end;i++){
            List<TreeNode> left = helper(st, i-1);
            List<TreeNode> right = helper(i+1, end);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode node = new TreeNode(i);
                    node.left=l;
                    node.right=r;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}