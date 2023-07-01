Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.
Example 1: Input:
            1
          /   \
         3     2
        /
       4           

Output: 2 Explanation:
Minimum depth is between nodes 1 and 2 since minimum depth is defined as  the number of  nodes along the shortest path from the root  node down to the nearest leaf node.

Example 2: Input:
             10
          /     \
        20       30
          \        \   
          40        60 
                   /
                  2 

Output: 3 Explanation:
Minimum depth is between nodes 10,20 and 40.

Your Task:  
You don't need to read input or print anything. Complete the function minDepth() which takes the root node as an input parameter and returns the minimum depth. 
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of the tree)
 
Constraints:
1 ≤ N ≤ 10^5



class Solution
{
 int minDepth(Node root)
 {
     if(root==null)return 0;
     int l=minDepth(root.left);
     int r=minDepth(root.right);

     if(l==0 || r==0){
         return 1+Math.max(l,r);
     }
     return 1+Math.min(l,r);
 }
}
--------------------------------------------------------------------------------------------------------------------------
class Pair{
    Node node;
    int num;
    Pair(Node node,int num){
        this.node = node;
        this.num=num;
    }
}
class Solution
{
	int minDepth(Node root)
	{
	    Queue<Pair> q=new LinkedList<>();
	    q.add(new Pair(root,1));
	    while(!q.isEmpty()){
	        Node curr=q.peek().node;
	        int level=q.peek().num;
	        q.remove();
	        int ans=0;
	        if(curr.left!=null){
	            q.add(new Pair(curr.left,level+1));
	            ans++;
	        }
	        if(curr.right!=null){
	            q.add(new Pair(curr.right,level+1));
	            ans++;
	        }
	        if(ans==0)return level;
	    }
	    return 0;
	}
}

