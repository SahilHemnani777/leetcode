class Solution {
    class obj{
        TreeNode node;
        int height;
        
        public obj(TreeNode _node, int _height){
            node=_node;
            height=_height;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root==null)return result;
        
        Queue<obj> que = new LinkedList();
        que.add(new obj(root, 0)); // root at height 0
        
        while(que.size() != 0){
            obj n = que.remove();
            if(que.size() != 0){
                obj next = que.peek();
                if(next.height != n.height){
                    // last element
                    result.add(n.node.val);
                }
            }else{
                result.add(n.node.val);
            }
            if(n.node.left!=null)que.add(new obj(n.node.left, n.height+1));
            if(n.node.right!=null)que.add(new obj(n.node.right, n.height+1));
        }
        return result;
    }
}