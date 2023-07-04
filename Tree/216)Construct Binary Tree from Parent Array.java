Construct Binary Tree from Parent Array
Given an array of size N that can be used to represents a tree. The array indexes are values in tree nodes and array values give the parent node of that particular index (or node). The value of the root node index would always be -1 as there is no parent for root. Construct the standard linked representation of Binary Tree from this array representation.
Note: If two elements have the same parent, the one that appears first in the array will be the left child and the other is the right child. 

Example 1:
Input:
N = 7
parent[] = {-1,0,0,1,1,3,5}
Output: 0 1 2 3 4 5 6
Explanation: the tree generated
will have a structure like 
          0
        /   \
       1     2
      / \
     3   4
    /
   5
 /
6
Example 2:
Input:
N = 3
parent[] = {2, 0, -1}
Output: 2 0 1
Explanation: the tree generated will
have a sturcture like
               2
             /   
            0      
          /   
         1     

Your Task:
You don't need to read input or print anything. The task is to complete the function createTree() which takes 2 arguments parent[] and N and returns the root node of the constructed tree.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 103

class Solution
{
    //Function to construct binary tree from parent array.
    public static Node createTree(int parent[], int N)
    {
        HashMap<Integer,ArrayList<Integer>> adjlist = new HashMap<>();
        for(int i=0;i<N;i++){
            adjlist.putIfAbsent(parent[i],new ArrayList<>());
            adjlist.get(parent[i]).add(i);
        }
        
        Queue<Node> q = new LinkedList<>();
        Node root=new Node(adjlist.get(-1).get(0)); 
        q.add(root);
        
        while(!q.isEmpty()){
            Node temp= q.poll();
            if(adjlist.containsKey(temp.data)==true){
                
                Node left=new Node(adjlist.get(temp.data).get(0));
                temp.left=left;
                q.add(left);
                
                if(adjlist.get(temp.data).size()>1){
                    Node right=new Node(adjlist.get(temp.data).get(1));
                    temp.right=right;
                    q.add(right);
                }
                
            }
        }
        
        return root;
        
    }
    
}
