700. Search in a Binary Search Tree



You are given the root of a binary search tree (BST) and an integer val.
Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 
Example 1:
 
Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Example 2:
 
Input: root = [4,2,7,1,3], val = 5
Output: []
 
Constraints:
The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107


class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null && root.val!=val){
            root=(val<root.val)?root.left:root.right;
        }
        return root;
    }
}



Search a node in BST

Given a Binary Search Tree and a node value X, find if the node with value X is present in the BST or not.

Example 1:
Input:         2
                \
                 81 
               /    \ 
             42      87 
              \       \ 
               66      90 
              / 
            45
X = 87
Output: 1
Explanation: As 87 is present in the
given nodes , so the output will be
1.
Example 2:
Input:      6
             \ 
              8 
             / \ 
            7   9
X = 11
Output: 0
Explanation: As 11 is not present in 
the given nodes , so the output will
be 0.

Your Task:
You don't need to read input or print anything. Complete the function search()which returns true if the node with value x is present in the BSTelse returns false.

Expected Time Complexity: O(Height of the BST)
Expected Auxiliary Space: O(1).

Constraints:
1 <= Number of nodes <= 105

class BST {
    // Function to search a node in BST.
    boolean search(Node root, int x) {
        while(root!=null && root.data!=x){
            root=(x<root.data)?root.left:root.right;
        }
        if(root==null)return false;
        return root.data==x;
    }
}

