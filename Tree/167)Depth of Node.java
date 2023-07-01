Depth of Node

Given a binary tree, find the depth of the deepest odd level leaf node in a binary tree. If there is no leaf at odd level then return 0. Consider that level starts with 1. Depth of a leaf node is number of nodes on the path from root to leaf (including both leaf and root).
Example 1: Input: 
          1
        /    \
       2      3
      / \    / \
     4   5  6   7
Output: 3 Explanation: In the above tree 4,5,6 and 7 are odd level leaf nodes at depth 3.So the answer is 3.
Example 2: Input: 
     1
    / \
    2   4
Output: 0
Your task:
You don't need to read input or print anything. Your task is to complete the function depthOfOddLeaf() which takes root node of the tree as input parameter and returns an integer denoting the maximum depth of a odd level leaf node of the tree. If there is no such leaf node return 0.
Expected Time Complexity: O(N)     Expected Auxiliary Space: O(N)
Constraints:
1<=T<=1000
1<=n<=1000
1<=data of node<=1000

class Solution{
    public static int depthOfOddLeaf(Node root)
    {
        if(root==null)
            return 0;
        int depth[]=new int[1];
        getdepth(root,depth,0);
        return depth[0];
    }
    public static void getdepth(Node node, int depth[],int currdepth){
        if(node==null)
            return;
        currdepth++;
        if(node.left==null && node.right==null && currdepth>depth[0] && currdepth%2!=0){
            depth[0]=currdepth;
        }
        getdepth(node.left,depth,currdepth);
        getdepth(node.right,depth,currdepth);
        currdepth--;
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
	 public static int depthOfOddLeaf(Node root)
	{
	    Queue<Pair> q=new LinkedList<>();
	    q.add(new Pair(root,1));
	    int levelmax=0;
	    int flag=0;
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
	        if(ans==0 && level%2!=0){
	            if(levelmax<level)
	            levelmax=level;
	            flag=1;
	        }
	    }
	    if(flag==0)
	    return 0;
	    else
	    return levelmax;  }}
