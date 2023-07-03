105. Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 
Example 1:
 
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
 
Constraints:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1,map);
    }

    public TreeNode helper(int preorder[], int inorder[], int ps, int pe, int is,int ie,HashMap<Integer,Integer> map){

        if(is>ie || ps>pe)
            return null;

        int rootVal = preorder[ps];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = map.get(rootVal);
        
        int lSize = rootIndex - is;
        int rSize = ie - rootIndex;

        root.left = helper(preorder,inorder, ps+1,  ps+lSize, is, rootIndex-1,map);
        root.right = helper(preorder,inorder, pe - rSize+1, pe,rootIndex + 1, ie ,map);
        
        return root;
    }
}
