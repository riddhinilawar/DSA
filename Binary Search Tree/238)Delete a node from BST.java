Delete a node from BST
Given a Binary Search Tree and a node value X. Delete the node with the given value X from the BST. If no node with value x exists, then do not make any change. 
Example 1:
Input:
      2
    /   \
   1     3
X = 12
Output: 1 2 3
Explanation: In the given input there
is no node with value 12 , so the tree
will remain same.
Example 2:
Input:
            1
             \
              2
                \
                 8 
               /    \
              5      11
            /  \    /  \
           4    7  9   12
X = 9
Output: 1 2 4 5 7 8 11 12
Explanation: In the given input tree after
deleting 9 will be
             1
              \
               2
                 \
                  8
                 /   \
                5     11
               /  \     \
              4    7     12
Your Task:
You don't need to read input or print anything. Your task is to complete the function deleteNode() which takes two arguments. The first being the root of the tree, and an integer 'X' denoting the node value to be deleted from the BST. Return the root of the BST after deleting the node with value X. Do not make any update if there's no node with value X present in the BST.
Note: The generated output will be the inorder traversal of the modified tree.
 
Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(Height of the BST).
 
Constraints:
1 <= N <= 105
 



class Tree {
    // Function to delete a node from BST.
    static Node prev;
    static Node target;
    public static Node deleteNode(Node root, int key) {
        if(root==null)return null;

        if(root.data==key){
            if(root.left==null && root.right==null)
                return null;
            if(root.left==null)
                return root.right;
            if(root.right==null)
                return root.left;

            Node temp=root.right;
            while(temp.left!=null)
                temp=temp.left;

            temp.left=root.left;

            return root.right;
        }

        getNode(root,key);

        if(target==null)return root;

        //System.out.println(target.data+" "+prev.data);

        if(target.left==null){
            if(prev.left==target)
                prev.left=target.right;
            else
                prev.right=target.right;
        }
        else if(target.right==null){
            if(prev.left==target)
                prev.left=target.left;
            else
                prev.right=target.left;
        }
        else{
            if(prev.left==target)
                prev.left=target.right;
            else
                prev.right=target.right;

            while(prev.left!=null)
                prev=prev.left;

            prev.left=target.left;
            
        }
        return root;
    }
    public static void getNode(Node root,int key){
        while(root!=null && root.data!=key){
            prev=root;
            root=(key<root.data)?root.left:root.right;
        }
        if(root!=null)
            target=root;
    }
}

