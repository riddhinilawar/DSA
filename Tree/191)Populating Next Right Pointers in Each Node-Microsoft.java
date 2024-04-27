116. Populating Next Right Pointers in Each Node
Medium
8.1K
272
Companies
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
 
Example 1:
 
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
Example 2:
Input: root = []
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 212 - 1].
-1000 <= Node.val <= 1000
 
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
================================================MOST OPTIMAL(WON'T RUN IF TREE ISN'T COMPLETELY FILLED)====================================
  class Solution {
    public Node connect(Node root) {

        if(root == null)return null;

        Node l = root.left;
        Node c = root;

        while(c!= null && l!=null)
        {
            c.left.next = c.right;

            if(c.next != null)
            {
                c.right.next = c.next.left;
            }

            c=c.next;

            if(c==null)
            {
                c = l;
                l = c.left;
            }
        }

        return root;
        
    }
}
