class Solution {
  private int prevVal = Integer.MAX_VALUE;
    private int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null)
            return 0;
        
        getMinimumDifference(root.left);
        minDiff = Math.min(minDiff, Math.abs(prevVal-root.val));
        prevVal = root.val;
        getMinimumDifference(root.right);
        
        return minDiff;
    }
}