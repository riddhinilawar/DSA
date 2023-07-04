Largest BST in BT
Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
Note: Here Size is equal to the number of nodes in the subtree.
Example 1:
Input:
        1
      /   \
     4     4
   /   \
  6     8
Output: 1
Explanation: There's no sub-tree with size
greater than 1 which forms a BST. All the
leaf Nodes are the BSTs with size equal
to 1.
Example 2:
Input: 6 6 3 N 2 9 3 N 8 8 2
            6
        /       \
       6         3
        \      /   \
         2    9     3
          \  /  \
          8 8    2 
Output: 2
Explanation: The following sub-tree is a
BST of size 2: 
       2
    /    \ 
   N      8
Your Task:
You don't need to read input or print anything. Your task is to complete the function largestBst() that takes the root node of the Binary Tree as its input and returns the size of the largest subtree which is also the BST. If the complete Binary Tree is a BST, return the size of the complete Binary Tree. 
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).
Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 106

class Solution{
    static int max_size=1;
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        max_size=1;
        helper(root);
        return max_size;
    }
    static Pair helper(Node root){
        if(root==null)
            return new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        
        if(root.left==null && root.right==null)
            return new Pair(root.data,root.data,1);
        
        Pair l=helper(root.left);
        Pair r=helper(root.right);
        //System.out.println(root.data+" "+l.lbound+" "+l.ubound+" "+r.lbound+" "+r.ubound+" "+(l.size+r.size+1));
        
        if(l.ubound>=root.data || root.data>=r.lbound)
            return new Pair(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
    
        max_size=Math.max(max_size,l.size+r.size+1);
        
        return new Pair(Math.min(root.data,l.lbound),Math.max(root.data,r.ubound),l.size+r.size+1);
    }
}
class Pair{
    int lbound;
    int ubound;
    int size;
    Pair(int lbound,int ubound,int size){
        this.lbound=lbound;
        this.ubound=ubound;
        this.size=size;
    }
}

