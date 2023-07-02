863. All Nodes Distance K in Binary Tree

Medium	
7.8K
156
Companies
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.
 
Example 1:
 
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:
Input: root = [1], target = 1, k = 3
Output: []
 
Constraints:
The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000
class Solution {
    public void getParent(TreeNode root, Map<TreeNode,TreeNode> map){
        if(root==null)
            return;
        if(root.left!=null) map.put(root.left,root);
        if(root.right!=null) map.put(root.right,root);
        getParent(root.left,map);
        getParent(root.right,map);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    {
        Map<TreeNode, TreeNode> map=new HashMap<>();
        map.put(root,null);
        Map<TreeNode,Boolean> vis= new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> result=new ArrayList<>();
        getParent(root,map);
        q.offer(target);
        vis.put(target,true);
        int curr_level=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(curr_level==k)break;
            curr_level++;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && vis.containsKey(curr.left)==false){
                    q.offer(curr.left);
                    vis.put(curr.left,true);
                }
                if(curr.right!=null && vis.containsKey(curr.right)==false){
                    q.offer(curr.right);
                    vis.put(curr.right,true);
                }
                if(map.get(curr)!=null && vis.containsKey(map.get(curr))==false){
                    q.offer(map.get(curr));
                    vis.put(map.get(curr),true);
                }
            }
        }
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            result.add(node.val);
        }
        Collections.sort(result);
        return result;   
    }
}
}
