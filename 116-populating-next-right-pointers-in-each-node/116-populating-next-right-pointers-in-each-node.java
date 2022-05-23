class Solution {
    
    class ds{
        Node node;
        int height;
        
        ds(Node _node, int _h){
            node= _node;
            height=_h;
        }
    }
    
    public Node connect(Node root) {
        if(root==null)return root;
        Queue<ds> que = new LinkedList<>();
        que.add(new ds(root,0));
        while(que.size()!=0){
            int size = que.size();
            for(int i =0 ; i < size; i++){
                ds dds = que.remove();
                if(que.peek()!=null && que.peek().height==dds.height)dds.node.next=que.peek().node;
                if(dds.node.left!=null)que.add(new ds(dds.node.left,dds.height+1));
                if(dds.node.right!=null)que.add(new ds(dds.node.right,dds.height+1));
            }
        }
        return root;
    }
}