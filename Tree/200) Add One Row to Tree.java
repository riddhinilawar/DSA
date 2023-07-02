623. Add One Row to Tree
Medium
2.6K
223
Companies
Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.
Note that the root node is at depth 1.
The adding rule is:
Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
cur's original left subtree should be the left subtree of the new left subtree root.
cur's original right subtree should be the right subtree of the new right subtree root.
If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
 
Example 1:
 
Input: root = [4,2,6,3,1,5], val = 1, depth = 2
Output: [4,1,1,2,null,null,6,3,1,5]
Example 2:
 
Input: root = [4,2,null,3,1], val = 1, depth = 3
Output: [4,2,null,1,1,3,null,null,1]
 
Constraints:
The number of nodes in the tree is in the range [1, 104].
The depth of the tree is in the range [1, 104].
-100 <= Node.val <= 100
-105 <= val <= 105
1 <= depth <= the depth of tree + 1
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)return root;
        q.add(root);
        ArrayList<TreeNode> temp=new ArrayList<>();
        temp.add(root);
        if(depth==1){
                TreeNode newnode1= new TreeNode(val,root,null);
                return newnode1;
        }
        int d=2;
        boolean inserted=false;
        while(!q.isEmpty()){
            int qsize=q.size();
            temp=new ArrayList<>();
            for(int i=0;i<qsize;i++){
                if(q.peek().left!=null)q.add(q.peek().left);
                if(q.peek().right!=null)q.add(q.peek().right);
                temp.add(q.poll());
            }
            if (depth==d){
                for(TreeNode node : temp){
                        TreeNode t1=node.left;
                        TreeNode newnode1= new TreeNode(val,t1,null);
                        node.left=newnode1;
                    
                        TreeNode t2=node.right;
                        TreeNode newnode2= new TreeNode(val,null,t2);
                        node.right=newnode2;
                    
                }
                inserted=true;
                break;
            }
            d++;
        }
        return root;
    }
}
