404. Sum of Left Leaves
Easy
4.1K
265
Companies
Given the root of a binary tree, return the sum of all left leaves.
A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 
Example 1:
 
Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
Example 2:
Input: root = [1]
Output: 0
 
Constraints:
The number of nodes in the tree is in the range [1, 1000].
-1000 <= Node.val <= 1000

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum[]=new int[1];
        if(root==null)return sum[0];
        helper(root,sum);
        return sum[0];
    }
    public void helper(TreeNode root, int sum[]){
        if(root==null)
            return;
        if(root.left!=null && root.left.left==null && root.left.right==null){
            sum[0]+=root.left.val;
            //System.out.print(root.left.val+" ");
        } 
        helper(root.left,sum);
        helper(root.right,sum);
    }
}

