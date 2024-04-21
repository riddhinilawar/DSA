655. Print Binary Tree

Given the root of a binary tree, construct a 0-indexed m x n string matrix res that represents a formatted layout of the tree. The formatted layout matrix should be constructed using the following rules:

The height of the tree is height and the number of rows m should be equal to height + 1.
The number of columns n should be equal to 2height+1 - 1.
Place the root node in the middle of the top row (more formally, at location res[0][(n-1)/2]).
For each node that has been placed in the matrix at position res[r][c], place its left child at res[r+1][c-2height-r-1] and its right child at res[r+1][c+2height-r-1].
Continue this process until all the nodes in the tree have been placed.
Any empty cells should contain the empty string "".
Return the constructed matrix res.

 

Example 1:


Input: root = [1,2]
Output: 
[["","1",""],
 ["2","",""]]
Example 2:


Input: root = [1,2,3,null,4]
Output: 
[["","","","1","","",""],
 ["","2","","","","3",""],
 ["","","4","","","",""]]
 

Constraints:

The number of nodes in the tree is in the range [1, 210].
-99 <= Node.val <= 99
The depth of the tree will be in the range [1, 10].


class Solution {
    public List<List<String>> printTree(TreeNode root) {
        
        int height=getHeight(root)-1;//height of tree//
        int m=height+1;//rows//
        int n=(int)Math.pow(2,height+1) - 1;//cols//

        int[][] res= new int[m][n];
        for(int d[]:res)Arrays.fill(d,Integer.MIN_VALUE);
        helper(root,res,0,(n-1)/2,height);
        
        return constructAns(res);
    }
    public void helper(TreeNode curr,int res[][],int row,int col,int height){
        if(curr==null){
            return;
        }
        res[row][col]=curr.val;
        helper(curr.left,res,row+1,col-(int)Math.pow(2,height-row-1),height);
        helper(curr.right,res,row+1,col+(int)Math.pow(2,height-row-1),height);
    }
    public int getHeight(TreeNode curr){
        if(curr==null){
            return 0;
        }
        int left=getHeight(curr.left);
        int right=getHeight(curr.right);
        return 1+Math.max(left,right);
    }
    public List<List<String>> constructAns(int[][] res){
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<res.length;i++){
            List<String> temp = new ArrayList<>();
            for(int j=0;j<res[0].length;j++){
                if(res[i][j]!=Integer.MIN_VALUE){
                    temp.add(String.valueOf(res[i][j]));
                }
                else{
                    temp.add(new String());
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
