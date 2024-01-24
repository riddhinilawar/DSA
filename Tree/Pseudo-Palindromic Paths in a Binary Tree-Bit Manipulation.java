1457. Pseudo-Palindromic Paths in a Binary Tree

Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.

Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

 

Example 1:



Input: root = [2,3,1,3,1,null,1]
Output: 2 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
Example 2:



Input: root = [2,1,1,1,3,null,null,null,null,null,1]
Output: 1 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
Example 3:

Input: root = [9]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 105].
1 <= Node.val <= 9


class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int freq[]=new int[10];
        freq[root.val]++;
        return helper(root,freq);
    }
    public int helper(TreeNode root,int[] freq){
        if(root.left==null && root.right==null){
            int pos=0;
            boolean allEven=true;
            boolean lessThanOneOdd=true;
            for(int f:freq){
                pos+=f;
                if(allEven==true && f%2!=0)allEven=false;
                else if(f%2!=0)lessThanOneOdd=false;
            }
            
            if(pos%2==0){
                return allEven?1:0;
            }
            else{
                return lessThanOneOdd?1:0;
            }
            
        }
        int ans=0;
        if(root.left!=null){
            freq[root.left.val]++;
            ans+=helper(root.left,freq);
            freq[root.left.val]--;
        }
        if(root.right!=null){
            freq[root.right.val]++;
            ans+=helper(root.right,freq);
            freq[root.right.val]--;
        }
        return ans;
    }
}

===================================================================================

class Solution {
    int ans =0;
    public int pseudoPalindromicPaths (TreeNode root) {
        helper(root, 0);
        return ans;
    }
    public void helper(TreeNode node, int seen){
        if(node == null) return;

        // System.out.println("before" + Integer.toBinaryString(seen));
        seen^=(1<<node.val);
        // System.out.println("after" + Integer.toBinaryString(seen));

        if(node.left == null && node.right == null){
            if((seen & (seen-1)) == 0){
                ans++;
            }
            return;
        }
        helper(node.left, seen);
        helper(node.right, seen);

    }
}
