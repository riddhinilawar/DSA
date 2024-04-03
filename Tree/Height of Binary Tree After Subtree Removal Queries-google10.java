2458. Height of Binary Tree After Subtree Removal Queries
Node:play along leve,heights
precompute the heights of all the nodes through dfs
find the level of each node thriugh bfs
then find group the nodes belong to same level, and then sort
now just check the dependencies.

You are given the root of a binary tree with n nodes. Each node is assigned a unique value from 1 to n. You are also given an array queries of size m.

You have to perform m independent queries on the tree where in the ith query you do the following:

Remove the subtree rooted at the node with the value queries[i] from the tree. It is guaranteed that queries[i] will not be equal to the value of the root.
Return an array answer of size m where answer[i] is the height of the tree after performing the ith query.

Note:

The queries are independent, so the tree returns to its initial state after each query.
The height of a tree is the number of edges in the longest simple path from the root to some node in the tree.
 

Example 1:


Input: root = [1,3,4,2,null,6,5,null,null,null,null,null,7], queries = [4]
Output: [2]
Explanation: The diagram above shows the tree after removing the subtree rooted at node with value 4.
The height of the tree is 2 (The path 1 -> 3 -> 2).
Example 2:


Input: root = [5,8,9,2,1,3,7,4,6], queries = [3,2,4,8]
Output: [3,2,3,2]
Explanation: We have the following queries:
- Removing the subtree rooted at node with value 3. The height of the tree becomes 3 (The path 5 -> 8 -> 2 -> 4).
- Removing the subtree rooted at node with value 2. The height of the tree becomes 2 (The path 5 -> 8 -> 1).
- Removing the subtree rooted at node with value 4. The height of the tree becomes 3 (The path 5 -> 8 -> 2 -> 6).
- Removing the subtree rooted at node with value 8. The height of the tree becomes 2 (The path 5 -> 9 -> 3).
 

Constraints:

The number of nodes in the tree is n.
2 <= n <= 105
1 <= Node.val <= n
All the values in the tree are unique.
m == queries.length
1 <= m <= min(n, 104)
1 <= queries[i] <= n
queries[i] != root.val

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
        HashMap<Integer,Integer> heights = new HashMap<>();
        getHeights(heights,root);
        int ans[]=new int[queries.length];
        
        //System.out.println(heights);

        //level -> List<Pair<node,height>>
        HashMap<Integer,ArrayList<Pair>> adjList = new HashMap<>();
        //node,level
        HashMap<Integer,Integer> levels=new HashMap<>();

        getHeightsByLevel(root,adjList,heights,levels);

        //System.out.println(levels);

        for(ArrayList<Pair> bucket:adjList.values()){
            Collections.sort(bucket,(a,b)->b.height-a.height);
        }

        // for(int ll:adjList.keySet()){
        //     System.out.println("level::"+ll);
        //     ArrayList<Pair> bucket=adjList.get(ll);

        //     for(Pair p:bucket){
        //         System.out.println(p.node+" "+p.height);
        //     }
        // }

        for(int i=0;i<queries.length;i++){
            int q=queries[i];
            int level=levels.get(q);
            ArrayList<Pair> bucket=adjList.get(level);
            
            if(bucket.get(0).node!=q){
                ans[i]=heights.get(root.val)-1;
            }
            else if(bucket.get(0).node==q && bucket.size()==1){
                ans[i]=level-1;
            }
            else if(bucket.get(0).node==q){
                ans[i]=level+bucket.get(1).height-1;
            }
        }

        return ans;
    }
    public int getHeights(HashMap<Integer,Integer> heights, TreeNode curr){
        if(curr==null){
            return 0;
        }

        int left=getHeights(heights,curr.left);
        int right=getHeights(heights,curr.right);

        heights.put(curr.val,Math.max(left,right)+1);

        return Math.max(left,right)+1;
    }
    public void getHeightsByLevel(TreeNode root,HashMap<Integer,ArrayList<Pair>> adjList,HashMap<Integer,Integer> heights,HashMap<Integer,Integer> levels){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                
                
                TreeNode curr=queue.remove();
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }

                adjList.putIfAbsent(level,new ArrayList<>());
                adjList.get(level).add(new Pair(curr.val,heights.get(curr.val)));
                levels.put(curr.val,level);
            }
            level++;
        }
    }
}
class Pair{
    int node;
    int height;
    Pair(int node,int height){
        this.node=node;
        this.height=height;
    }
}
