Maximum Path Sum in Binary Tree

Problem Statement: Write a program to find the maximum sum path in a binary tree from root to leaf.



    public void getMaxPathSum(Node root, int sum){
        if(root==null){ 
          ans=Math.max(ans,sum);
          return;
        }
        getPath(root.left,sum+root.val);
        getPath(root.right,sum+root.val);
    }
    


