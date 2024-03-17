Given two Binary Trees. Check whether they are Isomorphic or not.

Note: 
Two trees are called isomorphic if one can be obtained from another by a series of flips, i.e. by swapping left and right children of several nodes. Any number of nodes at any level can have their children swapped. Two empty trees are isomorphic.
For example, the following two trees are isomorphic with the following sub-trees flipped: 2 and 3, NULL and 6, 7 and 8.
ISomorphicTrees

Example 1:

Input:
 T1    1     T2:   1
     /   \        /  \
    2     3      3    2
   /            /
  4            4
Output: No

Example 2:

Input:
T1    1     T2:    1
    /  \         /   \
   2    3       3     2
  /                    \
  4                     4
Output: Yes
Your Task:
You don't need to read input or print anything. Your task is to complete the function isomorphic() that takes the root nodes of both the Binary Trees as its input and returns True if the two trees are isomorphic. Else, it returns False. (The driver code will print Yes if the returned values are true, otherwise false.)

Expected Time Complexity: O(min(M, N)) where M and N are the sizes of the two trees.
Expected Auxiliary Space: O(min(H1, H2)) where H1 and H2 are the heights of the two trees.

Constraints:
1<=Number of nodes<=105


  class Solution {
    boolean isIsomorphic(Node root1, Node root2) {
        // If both trees are empty, they are isomorphic
        if (root1 == null && root2 == null)
            return true;
        
        // If one of the trees is empty, they are not isomorphic
        if (root1 == null || root2 == null)
            return false;
        
        // Check if the data of the current nodes is the same
        if (root1.data != root2.data)
            return false;
        
        // Check for isomorphism recursively by considering two cases:
        // 1. The subtrees of root1 map to the subtrees of root2
        boolean swap=isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right);
        // 2. The subtrees of root1 map to the mirrored subtrees of root2
        boolean notswap=isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);
        return swap||notswap;
    }
}
