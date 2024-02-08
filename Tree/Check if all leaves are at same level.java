Check if all leaves are at same level

Given a binary tree with n nodes, check if all leaves are at same level or not. Return true/false depending on whether all the leaf nodes are at the same level or not.

Example 1:

Input: 
            1
          /   \
         2     3
Output: 
true
Explanation: 
Leaves 2 and 3 are at same level.
Example 2:

Input:
            10
          /    \
        20      30
       /  \        
     10    15
Output: 
false
Explanation:
Leaves 10, 15 and 30 are not at same level.
Your Task: 
You dont need to read input or print anything. Complete the function check() which takes root node as input parameter and returns true/false depending on whether all the leaf nodes are at the same level or not.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(height of tree)

Constraints:
1 ≤ n ≤ 105



class Solution{
    int level=-1;
    boolean check(Node root){
        return helper(root,0);
    }
    boolean helper(Node root,int curr){
        if(root==null){
            return true;
        }
	    if(root.left==null && root.right==null){
	        if(level==-1 || level==curr){
	            level=curr;
	            return true;
	        }
	        else{
	            return false;
	        }
	    }
	    boolean left=helper(root.left,curr+1);
	    boolean right=helper(root.right,curr+1);
	    return left&&right;
    }
}
