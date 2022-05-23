class Solution {
    class Pair{
        TreeNode node;
        int index;
        
        public Pair(TreeNode _node, int _index){
            node=_node;
            index=_index;
        }
    }
    int max = Integer.MIN_VALUE;
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root, 0));
        while(que.size()!=0){
            int size = que.size();
            int min = que.peek().index;
            int first=0;
            int last=0;;
            for(int i =0;i <size;i++){
                int curr_id = que.peek().index - min;
                TreeNode node = que.peek().node;
                que.remove();
                if(i==0)first=curr_id;
                if(i==size-1)last=curr_id;
                if(node.left!=null)que.add(new Pair(node.left, 2*curr_id +1));
                if(node.right!=null)que.add(new Pair(node.right, 2*curr_id +2));
            }
            max = Math.max(max, last-first+1);
        }
        return max;
    }
}