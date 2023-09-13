437. Path Sum III

Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

 

Example 1:


Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
 

Constraints:

The number of nodes in the tree is in the range [0, 1000].
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000


class Solution {
    int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return ans;
    }

    public void dfs(TreeNode root,long targetSum){
        if(root==null)
            return;
        helper(root,targetSum,0l);
        //System.out.println(root.val+" "+ans);
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
    }
    public void helper(TreeNode root, long targetSum,long  sum){

        if(root==null){
            return;
        }

        if(sum+root.val==targetSum)ans++;

        helper(root.left,targetSum,sum+root.val);
        helper(root.right,targetSum,sum+root.val);

    }
}
