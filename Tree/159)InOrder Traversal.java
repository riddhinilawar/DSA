class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> inorderTraversal=new ArrayList<>();
        if(root==null)
            return inorderTraversal;
        else
            traversal(root,inorderTraversal);
        return inorderTraversal;
    }
    static void traversal(Node node,ArrayList<Integer> inorderTraversal)
    {
        if(node==null)return;
      
        traversal(node.left,inorderTraversal);
        inorderTraversal.add(node.data);
        traversal(node.right,inorderTraversal);
        
    }

}
