Root to Leaf Paths
Given a Binary Tree of size N, you need to find all the possible paths from root node to all the leaf node's of the binary tree.
Example 1:
Input:
       1
    /     \
   2       3
Output: 1 2 #1 3 #
Explanation: 
All possible paths:
1->2
1->3

Example 2:
Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 10 20 40 #10 20 60 #10 30 #

Your Task:
Your task is to complete the function Paths() that takes the root node as an argument and return all the possible path. (All the path are printed '#' separated by the driver's code.)
Note: The return type
cpp: vector
java: ArrayList>
python: list of list
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree.
Constraints:
1<=N<=103
Note: The Input/Ouput format and Example given, are used for the system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from the stdin/console. The task is to complete the function specified, and not to write the full code





class Tree{
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        if(root==null)return ans;
        getPath(root,ans,temp);
        return ans;
    }
    public void getPath(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp){
        if(root==null) return;
        temp.add(root.data);
        if(root.left==null&&root.right==null){
            ArrayList<Integer> list=new ArrayList<>(temp);
            ans.add(list);
        }
        getPath(root.left,ans,temp);
        getPath(root.right,ans,temp);
        temp.remove(temp.size()-1);
    }
    
}
