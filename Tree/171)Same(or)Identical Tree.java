Same Tree

Given the roots of two binary trees p and q, write a function to check if they are the same or not. Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 
Example 1:
 
Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:
 
Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:
 
Input: p = [1,2,1], q = [1,1,2]
Output: false
 
Constraints:
The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104

Recursive:
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null)
            return(p==q);
        return (p.val==q.val)&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
Iterative:
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        stack1.push(p);
        stack2.push(q);
        
        while(!stack1.isEmpty()){
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            
            if(node1.val!=node2.val)return false;
            
            if(node1.left!=null){
                stack1.push(node1.left);
                if(node2.left!=null){
                    stack2.push(node2.left);
                }
                else return false;
            }
            else if(node1.left==null){
                if(node2.left!=null)return false;
            }
           
            
            if(node1.right!=null){
                stack1.push(node1.right);
                if(node2.right!=null){
                    stack2.push(node2.right);
                }
                else return false;
            }
             else if(node1.right==null){
                if(node2.right!=null)return false;
            }
        }
        if(stack2.isEmpty()==false)return false;
        return true;
    }
}
