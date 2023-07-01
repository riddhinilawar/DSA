Binary Tree Zig-Zag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 
Example 1:
 
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:
Input: root = [1]
Output: [[1]]
Example 3:
Input: root = []
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> traversal=new LinkedList<>();
        if(root==null)return traversal;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean flag=true;
        
        while(!q.isEmpty()){
            List<Integer> temp=new LinkedList<>();
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                temp.add(node.val);
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            if(flag==true){
                traversal.add(temp);
                flag=false;
            }
            else
            {
                Collections.reverse(temp);
                traversal.add(temp);
                flag=true;
            }
        }
        return traversal;
    }
}
