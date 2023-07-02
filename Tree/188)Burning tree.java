Burning tree

Given a binary tree and a node called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.

Example 1:
Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      6
       / \      \
      7   8      9
                   \
                   10
Target Node = 8
Output: 7
Explanation: If leaf with the value 
8 is set on fire. 
After 1 sec: 5 is set on fire.
After 2 sec: 2, 7 are set to fire.
After 3 sec: 4, 1 are set to fire.
After 4 sec: 3 is set to fire.
After 5 sec: 6 is set to fire.
After 6 sec: 9 is set to fire.
After 7 sec: 10 is set to fire.
It takes 7s to burn the complete tree.
Example 2:
Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      7
  /    / 
 8    10
Target Node = 10
Output: 5

Your Task:  
You don't need to read input or print anything. Complete the function minTime() which takes the root of the tree and target as input parameters and returns the minimum time required to burn the complete binary tree if the target is set on fire at the 0th second.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)

Constraints:
1 ≤ N ≤ 104

    
    public static int minTime(Node root, int target) 
    {
        Map<Node, Node> map=new HashMap<>();
        map.put(root,null);
        Map<Node,Boolean> vis= new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        Node[] targetNode=new Node[1];
        getParent(root,map,targetNode,target);
        q.offer(targetNode[0]);
        vis.put(targetNode[0],true);
        int curr_level=0;
        while(!q.isEmpty() && vis.size()<map.size()){
            int size=q.size();
            curr_level++;
            
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                if(curr.left!=null && vis.containsKey(curr.left)==false){
                    q.offer(curr.left);
                    vis.put(curr.left,true);
                }
                if(curr.right!=null && vis.containsKey(curr.right)==false){
                    q.offer(curr.right);
                    vis.put(curr.right,true);
                }
                if(map.get(curr)!=null && vis.containsKey(map.get(curr))==false){
                    q.offer(map.get(curr));
                    vis.put(map.get(curr),true);
                }
            }
            
        }
       
        return curr_level;
        
    }
    public static void getParent(Node root, Map<Node,Node> map, Node targetNode[], int target){
        if(root==null)
            return;
        if(root.data==target)targetNode[0]=root;
        if(root.left!=null) map.put(root.left,root);
        if(root.right!=null) map.put(root.right,root);
        getParent(root.left,map,targetNode,target);
        getParent(root.right,map,targetNode,target);
    }
}






