662. Maximum Width of Binary Tree
Given the root of a binary tree, return the maximum width of the given tree.
The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
It is guaranteed that the answer will in the range of a 32-bit signed integer.
 
Example 1:
 
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
Example 2:


Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:
 
Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).
 
Constraints:
The number of nodes in the tree is in the range [1, 3000].
-100 <= Node.val <= 100

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        long maxWidth=1;
        Queue<Pair> q = new LinkedList<>();
        
        if(root==null)return 0; 
        if(root.left==null && root.right==null)return 1; 
        
        q.offer(new Pair(root,0));
        
        while(!q.isEmpty()){
            int size=q.size();
            long firstNodePos=-1;
            long lastNodePos=-1;
           
            for(int i=0;i<size;i++){

                Pair p=q.poll();
                //System.out.println(p.index);

                if(firstNodePos==-1)firstNodePos=p.index;
                if(firstNodePos!=-1)lastNodePos=p.index;

                if(p.root.left!=null)q.offer(new Pair(p.root.left,(2*p.index)));
                if(p.root.right!=null)q.offer(new Pair(p.root.right,(2*p.index)+1));
            }
            //System.out.println(firstNodePos + " "+ lastNodePos);
            if(firstNodePos!=lastNodePos)
                maxWidth=Math.max(maxWidth,lastNodePos-firstNodePos+1);
        }
        return (int)maxWidth;
    }
}
class Pair{
    TreeNode root;
    long index;
    Pair(TreeNode root,long index){
        this.root=root;
        this.index=index;
    }
}

Maximum Width of Tree-gfg
Given a Binary Tree, find the maximum width of it. Maximum width is defined as the maximum number of nodes at any level.
For example, the maximum width of the following tree is 4 as there are 4 nodes at the 3rd level.
          1
       /     \
     2        3
   /    \    /    \
  4    5   6    7
    \
      8
Example 1:
Input:
       1
     /    \
    2      3
Output: 2
On the first level there is only
one node 1
On the second level there are
two nodes 2, 3 clearly it is the 
maximum number of nodes at any level

Example 2:
Input:
        10
      /     \
    20      30
   /    \
  40    60
Output: 2
There is one node on level 1(10)
There is two node on level 2(20, 30)
There is two node on level 3(40, 60)
Hence the answer is 2

Your Task:
You don't have to read any input. Complete the function getMaxWidth() that takes the node as a parameter and returns the maximum width. The driver code does the printing.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Width of the tree).
Constraints:
1 <= Number of Nodes<= 105
0 <= nodes values <= 105


class Solution {
   
    int getMaxWidth(Node root) {
      
        int maxWidth=1;
        Queue<Node> q = new LinkedList<>();
        
        if(root==null)return 0; 
        if(root.left==null && root.right==null)return 1; 
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int size=q.size();
           
            for(int i=0;i<size;i++){
                Node temp=q.poll();
                if(temp.left!=null)q.offer(temp.left);
                if(temp.right!=null)q.offer(temp.right);
            }
           
            maxWidth=Math.max(maxWidth,size);
        }
        return maxWidth;
    }
}

