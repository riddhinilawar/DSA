99. Recover Binary Search Tree
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 
Example 1:
 
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:
 
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 
Constraints:
The number of nodes in the tree is in the range [2, 1000].
-231 <= Node.val <= 231 - 1
 
Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?

class Solution {
    TreeNode first=null;
    TreeNode first_prev=null;
    TreeNode second=null;
    TreeNode prev=new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);     
        //System.out.println(first_prev.val+" "+first.val);
        if(second==null){
            int temp=first.val;
            first.val=first_prev.val;
            first_prev.val=temp;
        }  
        else if(first_prev.val>second.val){
            int temp=second.val;
            second.val=first_prev.val;
            first_prev.val=temp;
        }
        else{
            int temp=first.val;
            first.val=second.val;
            second.val=temp;
        }
    }
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        
        if(root.val>=prev.val)
            prev=root;
        else if(first==null){
            first=root;
            first_prev=prev;
            prev=root;
        }
        else{
            second=root;
            return;
        }

        inorder(root.right);
    }
}

