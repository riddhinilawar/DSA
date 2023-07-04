572. Subtree of Another Tree
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 
Example 1:
 
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:
 
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 
Constraints:
The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104


class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) 
            return false;
        if (isIdentical(root, subRoot)) 
            return true;
    
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNode node1, TreeNode node2) {

        if (node1 == null || node2 == null) 
            return node1 == node2;
    
        return node1.val == node2.val && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }
}



class Solution {
    boolean ans=false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String subTree=getStringforsubRoot(subRoot);
        //System.out.println(subTree);
        check(root,subTree);
        return ans;
    }
    public String getStringforsubRoot(TreeNode subRoot){
        if(subRoot==null)
            return "#";
        String temp=subRoot.val+getStringforsubRoot(subRoot.left)+getStringforsubRoot(subRoot.right);
        return temp;
    }
    public  String check(TreeNode root,String subTree){
        if(root==null)
            return "#";
        String temp=root.val+check(root.left,subTree)+check(root.right,subTree);
        if(temp.equals(subTree))
            ans=true;
        return temp;
    }
}



