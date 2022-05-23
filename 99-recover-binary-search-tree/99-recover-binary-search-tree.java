class Solution {
    private TreeNode prev;
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    public void recoverTree(TreeNode root) {
        middle = last= first=null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last!=null){
            // two elements found which are non adjecent
            int temp=first.val;
            first.val=last.val;
            last.val=temp;
        }else if(first!=null && middle!=null){
            int temp=first.val;
            first.val=middle.val;
            middle.val=temp;            
        }
        
    }
    
    private void inorder(TreeNode node){
        if(node.left!=null){
            inorder(node.left);
        }
        // Business
        if(prev!=null && prev.val>node.val){
            if(first==null){
                first=prev;
                middle=node;   
            }else{
                last=node;
            }
        }
        prev=node;
        if(node.right!=null){
            inorder(node.right);
        }
    }
}