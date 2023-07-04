106. Construct Binary Tree from Inorder and Postorder Traversal

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 
Example 1:
 
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]
 
Constraints:
1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.


class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return helper(inorder,postorder,0,inorder.length-1,0,postorder.length-1,map);
    }
    public TreeNode helper(int inorder[], int postorder[], int is,int ie, int ps, int pe,HashMap<Integer,Integer> map){
        if(is>ie || ps>pe)
            return null;

        int rootVal = postorder[pe];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        

        int lSize = rootIndex - is;
        int rSize = ie - rootIndex;

        root.left = helper(inorder,postorder, is, rootIndex - 1, ps, ps + lSize - 1,map);
        root.right = helper(inorder,postorder, rootIndex + 1, ie , pe - rSize, pe - 1,map);
        
        return root;
    }
}
