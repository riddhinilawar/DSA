117. Populating Next Right Pointers in Each Node II
Medium
5K
292
Companies
Given a binary tree
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
 
Example 1:
 
Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
Example 2:
Input: root = []
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 6000].
-100 <= Node.val <= 100
 
Follow-up:
You may only use constant extra space.
The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.


class Solution {
    public Node connect(Node root) {
        Queue<Node> q=new LinkedList<>();
        if(root==null)return root;
        q.add(root);
        while(!q.isEmpty()){
            int qsize=q.size();
            Node prev=null;
            for(int i=0;i<qsize;i++){
                if(q.peek().left!=null)q.add(q.peek().left);
                if(q.peek().right!=null)q.add(q.peek().right);
                if(i==0){
                    prev=q.peek();
                }
                else{
                    prev.next=q.peek();
                    prev=prev.next;
                }
                q.poll();
            }
        }
        return root;
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------
public class Solution {
    
    //based on level order traversal
    public void connect(TreeLinkNode root) {

        TreeLinkNode head = null; //head of the next level
        TreeLinkNode prev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level

        while (cur != null) {
            
            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            
            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
        
    }
}
===============================ZERO SPACE SOLUTION==============================
