/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class SideNode{
        int side;
        TreeNode node;
        
        public SideNode(int _side, TreeNode _node){
            side= _side;
            node=_node;
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        int sum=0;
        Queue<SideNode> que = new LinkedList();
        que.add(new SideNode(1, root)); // root is always right
        while(que.size()!=0){
            SideNode sn = que.remove();
            if(sn.node.left==null && sn.node.right==null && sn.side==0){
                // leaf node
                System.out.println(sn.node.val);
                sum+=sn.node.val;
            }
            if(sn.node.left!=null)que.add(new SideNode(0, sn.node.left));
            if(sn.node.right!=null)que.add(new SideNode(1, sn.node.right));
        }
        return sum;
    }
}