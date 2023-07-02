637. Average of Levels in Binary Tree
Easy
4.4K
277
Companies
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 
Example 1:
 
Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
Example 2:
 
Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
 
Constraints:
The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)return ans;
        q.add(root);
        while(!q.isEmpty()){
            int qsize=q.size();
            double sum=0;
            int count=0;
            for(int i=0;i<qsize;i++){
                if(q.peek().left!=null)q.add(q.peek().left);
                if(q.peek().right!=null)q.add(q.peek().right);
                sum+=(q.poll().val);
                count++;
            }
            double avg=sum/count;
            ans.add(avg);
        }
        return ans;
    }
}


