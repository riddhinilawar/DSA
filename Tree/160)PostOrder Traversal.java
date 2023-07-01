class Tree
{
    //Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root)
    {
        ArrayList<Integer> postorderTraversal=new ArrayList<>();
        if(root==null)
            return postorderTraversal;
        else
            traversal(root,postorderTraversal);
        return postorderTraversal;
    }
    static void traversal(Node node,ArrayList<Integer> postorderTraversal)
    {
        if(node==null)return;
      
        traversal(node.left,postorderTraversal);
        traversal(node.right,postorderTraversal);
        postorderTraversal.add(node.data);
    }

}
