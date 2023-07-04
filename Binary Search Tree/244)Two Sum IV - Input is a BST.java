653. Two Sum IV - Input is a BST
Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
 
Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:
 
Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
 
Constraints:
The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105

class Solution {
    HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
            return false;
        
        boolean left = findTarget(root.left,k);
        if(left==true)return true;

        if(set.contains(k-root.val))
            return true;
        else
            set.add(root.val);

        boolean right= findTarget(root.right,k);
        if(right==true)return true;

        return false;
    }
}
