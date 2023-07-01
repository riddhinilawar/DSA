Vertical Order Traversal of a Binary Tree

Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
Return the vertical order traversal of the binary tree.
 
Example 1:
 

Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.


Example 2:
 

Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.


Example 3:
 

Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 
Constraints:
The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000


class Pair{
    TreeNode node;
    int level;
    int column;
    Pair(TreeNode node,int level,int column){
        this.node=node;
        this.level=level;
        this.column=column;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)return ans;
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,1,1));
        while(!q.isEmpty()){
            TreeNode node=q.peek().node;
            int level=q.peek().level;
            int column=q.peek().column;
            q.remove();
            
            if(!map.containsKey(column))
                map.put(column,new TreeMap<>());
            
            if(!map.get(column).containsKey(level))
                map.get(column).put(level,new PriorityQueue<Integer>());
            
            map.get(column).get(level).offer(node.val);
            
            if(node.left!=null)
                q.add(new Pair(node.left,level+1,column-1));
            
            if(node.right!=null)
                q.add(new Pair(node.right,level+1,column+1));
            
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> columnitr:map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq:columnitr.values()){
                while(!pq.isEmpty()){
                    ans.get(ans.size()-1).add(pq.poll());
                }
            }
        }
        return ans;
    }
}

