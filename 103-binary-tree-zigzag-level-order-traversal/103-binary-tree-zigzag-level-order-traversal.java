class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList();
        Boolean leftToRight = true; 
        Queue<TreeNode> que = new LinkedList();
        que.add(root);
        while(que.size()!=0){
            var size = que.size();
            List<Integer> arr = new LinkedList();
            for(int i=0; i<size; i++){
                TreeNode node = que.remove();
                if(leftToRight)arr.add(node.val);
                else arr.add(0, node.val);
                if(node.left!=null)que.add(node.left);
                if(node.right!=null)que.add(node.right);
            }
            leftToRight=!leftToRight;
            result.add(arr);
        }
        return result;
    }
}