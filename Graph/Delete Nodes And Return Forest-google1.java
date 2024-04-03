1110. Delete Nodes And Return Forest
=====================================================Approach 1=====================================
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:to_delete){
            set.add(num);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        addInQueue(root,queue,set);
        List<TreeNode> ans = new ArrayList<>();


        while(!queue.isEmpty()){
            TreeNode curr=queue.remove();
            helper(curr,queue,set);
            ans.add(curr);
        }
        
        return ans;
    }
    public TreeNode helper(TreeNode currNode,Queue<TreeNode> queue,HashSet<Integer> set){
        if(currNode==null){
            return null;
        }
        if(set.contains(currNode.val)){
            addInQueue(currNode,queue,set);
            return null;
        }

        currNode.left=helper(currNode.left,queue,set);
        currNode.right=helper(currNode.right,queue,set);

        return currNode;

    }
    public void addInQueue(TreeNode curr,Queue<TreeNode> queue,HashSet<Integer> set){
        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(curr);

        while(!temp.isEmpty()){
            TreeNode node=temp.remove();
            if(set.contains(node.val)){

                if(node.left!=null)temp.add(node.left);
                if(node.right!=null)temp.add(node.right);
            }
            else{
                queue.add(node);
            }
        }
    }
}
========================================Approach 2=========================================

class Solution {
  
      public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }

        List<TreeNode> forest = new ArrayList<>();
        root = processNode(root, toDeleteSet, forest);
        if (root != null) {
            forest.add(root);
        }

        return forest;
    }

    private TreeNode processNode(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }

        node.left = processNode(node.left, toDeleteSet, forest);
        node.right = processNode(node.right, toDeleteSet, forest);

        if (toDeleteSet.contains(node.val)) {
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            return null;
        }

        return node;
    }
}
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.

 

Example 1:


Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
Example 2:

Input: root = [1,2,4,null,3], to_delete = [3]
Output: [[1,2,4]]
 

Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.
