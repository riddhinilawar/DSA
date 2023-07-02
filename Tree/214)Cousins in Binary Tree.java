993. Cousins in Binary Tree
Easy
3.4K
173
Companies
Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
Two nodes of a binary tree are cousins if they have the same depth with different parents.
Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
 
Example 1:
 
Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:
 
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:
 
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 
Constraints:
The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.




class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        int xdepth[]=new int[1];
        int ydepth[]=new int[1];
        boolean flag[]=new boolean[1];
        flag[0]=true;
        helper(root,xdepth,ydepth,flag,x,y,0);
        System.out.println(flag[0]);
        return xdepth[0]==ydepth[0] && flag[0];
    }
    public void helper(TreeNode curr, int xdepth[],int ydepth[],boolean flag[],int x,int y,int depth){
        if(curr==null)
            return;
        if(curr.val==x)
            xdepth[0]=depth;
        if(curr.val==y)
            ydepth[0]=depth;
        if(curr.left!=null && curr.right!=null &&(( curr.left.val==x && curr.right.val==y)||( curr.left.val==y && curr.right.val==x)))
            flag[0]=false;
        helper(curr.left,xdepth,ydepth,flag,x,y,depth+1);
        helper(curr.right,xdepth,ydepth,flag,x,y,depth+1);
    }
}


