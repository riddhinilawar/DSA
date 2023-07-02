513. Find Bottom Left Tree Value
Medium
2.7K
237
Companies
Given the root of a binary tree, return the leftmost value in the last row of the tree.
 
Example 1:
 
Input: root = [2,1,3]
Output: 1
Example 2:
 
Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
 
Constraints:
The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 – 1



class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.peek();
                q.remove();
                list.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            ans=list.get(0);
        }
        return ans;
    }
}
