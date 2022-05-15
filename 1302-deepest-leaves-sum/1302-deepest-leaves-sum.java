class Solution {
    class HeightNode{
        int height;
        TreeNode node;
        
        public HeightNode(int h, TreeNode n){
            height= h;
            node = n;
        }
    }
    
    public int deepestLeavesSum(TreeNode root) {
        Queue<HeightNode> que = new LinkedList();
        que.add(new HeightNode(0, root)); // initial height =0
        int sum = 0;
        int prevHeight=0;
        while(que.size()!=0){
            HeightNode heightNode = que.remove();
            if(heightNode.node.left==null && heightNode.node.left==null){
                if(heightNode.height==prevHeight)
                    sum= sum+heightNode.node.val;
                else
                    sum=heightNode.node.val;
            }
            prevHeight= heightNode.height;
            if(heightNode.node.left!=null)que.add(new HeightNode(prevHeight+1, heightNode.node.left));
            if(heightNode.node.right!=null)que.add(new HeightNode(prevHeight+1, heightNode.node.right));
        }
        return sum;
    }
}