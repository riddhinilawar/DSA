515. Find Largest Value in Each Tree Row
Medium
2.5K
92
Companies
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 
Example 1:
 
Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:
Input: root = [1,2,3]
Output: [1,3]
 
Constraints:
The number of nodes in the tree will be in the range [0, 104].
-231 <= Node.val <= 231 - 1

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (queue.size() > 0) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode n = queue.pollFirst();
                max = Math.max(max, n.val);
                if (n.left != null) {
                    queue.addLast(n.left);
                }
                if (n.right != null) {
                    queue.addLast(n.right);
                }
                size--;
            }
            result.add(max);
        }
        return result;
    }
}
