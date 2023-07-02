113. Path Sum II
Medium
6.5K
135
Companies
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 
Example 1:
 
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:
 
Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:
Input: root = [1,2], targetSum = 0
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        int sum[]=new int[1];
        if(root==null)return ans;
        getPath(root,targetSum,sum,temp,ans);
        return ans;
    }
    public void getPath(TreeNode root, int targetSum, int sum[], List<Integer> temp, List<List<Integer>> ans){
        if(root==null)
            return;
        temp.add(root.val);  
        sum[0]+=root.val;
        if(sum[0]==targetSum && root.left==null && root.right==null){
            ArrayList<Integer> list=new ArrayList<>(temp);
            ans.add(list);
        }
        getPath(root.left,targetSum,sum,temp,ans);
        getPath(root.right,targetSum,sum,temp,ans);
        temp.remove(temp.size()-1);
        sum[0]-=root.val;
    }
}
