class Solution {
    public HashMap<TreeNode, TreeNode> prevMap = new HashMap<>();
    public List<Integer> result = new ArrayList<>();
    public HashMap<TreeNode , Boolean> visited = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        addPrevValues(root, null);
        findNodes(target, k);
        return result;
    }
    public void addPrevValues(TreeNode node, TreeNode prev){
        if(node==null) return;
        prevMap.put(node, prev);
        addPrevValues(node.left, node);
        addPrevValues(node.right, node);
    }
    public void findNodes(TreeNode node, int height){
        if (node==null || visited.get(node)!=null) return;
        if(height==0){
            result.add(node.val);
            return;
        }
        visited.put(node, true);
        findNodes(prevMap.get(node), height-1);
        findNodes(node.left, height-1);
        findNodes(node.right, height-1);
    }
}