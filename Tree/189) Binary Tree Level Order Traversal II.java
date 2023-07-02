107. Binary Tree Level Order Traversal II
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
Example 1: Input: root = [3,9,20,null,null,15,7]
 
Output: [[15,7],[9,20],[3]]
Example 2: Input: root = [1]
Output: [[1]]
Example 3: Input: root = []
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000


class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> stack=new Stack<>();
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> arr=new ArrayList<>();
        if(root==null)return arr;
        q.add(root);
        while(!q.isEmpty()){
            int qsize=q.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<qsize;i++){
                if(q.peek().left!=null)q.add(q.peek().left);
                if(q.peek().right!=null)q.add(q.peek().right);
                temp.add(q.poll().val);
            }
            stack.push(temp);
        }
        while(!stack.isEmpty()){
            arr.add(stack.pop());
        }
        return arr;
    }}
