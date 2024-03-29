Count Leaves in Binary Tree
Given a Binary Tree of size N , You have to count leaves in it. For example, there are two leaves in following tree
        1
     /      \
   10      39
  /
5

 
Example 1:

Input:
Given Tree is 
               4
             /   \
            8     10
           /     /   \
          7     5     1
         /
        3 
Output:
3
Explanation: 
Three leaves are 3 , 5 and 1.
 
Your Task:
You don't have to take input. Complete the function countLeaves() that takes root node of given tree as parameter and returns the count of leaves in tree . The printing is done by the driver code.
 
Constraints:
1<= N <= 104
 
Note:The Input/Ouput format and Example given below is used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console, and should not print anything on stdout/console. The task is to complete the function specified, and not to write the full code.

class Tree
{
    int countLeaves(Node node) 
    {
        int ans[]=new int[1];
        if(node==null) return 0;
        helper(node,ans);
        return ans[0];
    }
    void helper(Node node,int ans[]){
        if(node==null)
            return;
        if(node.left==null && node.right==null)ans[0]++;
        helper(node.left,ans);
        helper(node.right,ans);
    }
}

