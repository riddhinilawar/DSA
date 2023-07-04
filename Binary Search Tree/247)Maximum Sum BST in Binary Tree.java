1373. Maximum Sum BST in Binary Tree
Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 
Example 1:
 
Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
Output: 20
Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.
Example 2:
 
Input: root = [4,3,null,1,2]
Output: 2
Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.
Example 3:
Input: root = [-4,-2,-5]
Output: 0
Explanation: All values are negatives. Return an empty BST.
 
Constraints:
The number of nodes in the tree is in the range [1, 4 * 104].
-4 * 104 <= Node.val <= 4 * 104
class Solution {
    int ans=0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
    }
    public Pair helper(TreeNode root){
        if(root==null)
            return new Pair(Integer.MIN_VALUE,Integer.MAX_VALUE,0);

        if(root.left==null && root.right==null){
            ans=Math.max(ans,root.val);
            return new Pair(root.val,root.val,root.val);
        }

        Pair l=helper(root.left);
        Pair r=helper(root.right);

        //System.out.println(root.val+" "+l.lbound+" "+l.ubound+" "+r.lbound+" "+r.ubound+" "+(root.val+l.sum+r.sum));
        
        if(l.ubound>=root.val || root.val>=r.lbound){
            //System.out.println(root.val);
            return new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }

        ans=Math.max(ans,root.val+l.sum+r.sum);
        
        return new Pair(Math.max(root.val,r.ubound),Math.min(root.val,l.lbound),root.val+l.sum+r.sum);
    }
    private class Pair{
        int ubound;
        int lbound;
        int sum;
        Pair(int ubound,int lbound,int sum){
            this.ubound=ubound;
            this.lbound=lbound;
            this.sum=sum;
        }
    }
}
