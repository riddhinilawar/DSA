337. House Robber III

Note: post order traversal, get the last and second last node values , return the max(curr value + second last values, last values) to get the best possible answer 

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

 

Example 1:


Input: root = [3,2,3,null,3,null,1]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:


Input: root = [3,4,5,1,3,null,1]
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 104


class Solution {
    public int rob(TreeNode root) {
        int temp[]=helper(root);     
        return Math.max(temp[0],temp[1]);   
    }
    public int[] helper(TreeNode root){
        
        if(root==null){
            return new int[]{0,0};
        }

        int left[]=helper(root.left);
        int right[]=helper(root.right);

        int directlyConnected=Math.max(left[1]+right[1]+root.val,left[0]+right[0]);
        int notDirectlyConnected=left[0]+right[0];

        return new int[]{directlyConnected,notDirectlyConnected};
        //[connected,next to connected]
    }
}
//edge case::[4,1,null,2,null,3]
