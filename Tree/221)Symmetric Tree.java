Symmetric Tree

Given a Binary Tree. Check whether it is Symmetric or not, i.e. whether the binary tree is a Mirror image of itself or not.
Example 1: Input:
         5
       /   \
      1     1
     /       \
    2         2
Output: True
Explanation: Tree is mirror image of itself i.e. tree is symmetric
Example 2: Input:
         5
       /   \
      10     10
     /  \     \
    20  20     30
Output: False
Your Task:
You don't need to read input or print anything. Your task is to complete the function isSymmetric() which takes the root of the Binary Tree as its input and returns True if the given Binary Tree is the same as the Mirror image of itself. Else, it returns False.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).
Constraints:
0<=Number of nodes<=100

class GfG
{
    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(Node root)
    {
        if(root==null) return true;
        if(root.left==null && root.right==null)return true;
        if(root.left==null || root.right==null)return false;
        return helper(root.left,root.right);
    }
    public static boolean helper(Node p,Node q){
        if(p==null||q==null)
            return(p==q);
        return (p.data==q.data) &&(helper(p.left,q.right)) &&(helper(p.right,q.left));
    }
}

