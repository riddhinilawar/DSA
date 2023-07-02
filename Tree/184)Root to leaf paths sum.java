Root to leaf paths sum

Given a binary tree of N nodes, where every node value is a number. Find the sum of all the numbers which are formed from root to leaf paths.
Example 1:
Input :      
           6                               
         /   \                          
        3     5                      
      /   \     \
     2    5      4             
        /  \                        
       7    4  

Output: 13997

Explanation :
There are 4 leaves, hence 4 root to leaf paths:
Path                      Number
6->3->2                   632
6->3->5->7                6357
6->3->5->4                6354
6->5>4                    654   
Answer = 632 + 6357 + 6354 + 654 = 13997 
Example 2:
Input :    
           10                               
         /   \                          
        20     30                      
      /   \     
     40       60    

Output :  2630

Explanation:
Path                      Number
10->20->40                1240
10->20->60                1260
10->30                    130
1240+1260+130 = 2630

Your Task:  
You dont need to read input or print anything. Complete the function treePathsSum() which takes root node as input parameter and returns the sum of all the numbers formed by the root to leaf paths in the given Binary Tree.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of Tree)

Constraints:
1 ≤ N ≤ 12

class Tree1
{
	public static long treePathsSum(Node root)
    {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        if(root==null)return 0;
        getPath(root,ans,temp);
        
        long answer=0;
        for(ArrayList<Integer> list:ans){
            long t=0;
            for(int element:list){
                t=(t*10)+element;
            }
            answer+=t;
        }
        return answer;
    }
    public static void getPath(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp){
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
