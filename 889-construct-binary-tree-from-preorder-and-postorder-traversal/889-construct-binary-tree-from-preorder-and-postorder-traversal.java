class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return createTree(preorder, postorder, 0, n-1, 0, n-1);
    }
    
    public TreeNode createTree(int[] preorder, int[] post, int prs, int pre, int pos, int poe){
        if(prs>pre){
            return null;
        }
        if(prs==pre){
            return new TreeNode(preorder[prs]);
        }
        TreeNode node = new TreeNode(preorder[prs]);
        int val = preorder[prs+1];
        int idx = -1;
        for(int i=pos; i<=poe; i++){
            if(post[i]==val){
                idx = i;
                break;
            }
        }
        // colse - count of left subtree elements
        int colse = idx - pos + 1;
        node.left = createTree(preorder, post, prs+1, prs+colse, pos, idx);
        node.right = createTree(preorder, post, prs+colse+1, pre, idx+1, poe-1);
        return node;
    }
}