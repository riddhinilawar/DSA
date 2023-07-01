class BinaryTree
{
    //Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> preorderTraversal=new ArrayList<>();
        if(root==null)
            return preorderTraversal;
        else
            traversal(root,preorderTraversal);
        return preorderTraversal;
    }
    static void traversal(Node node,ArrayList<Integer> preorderTraversal)
    {
        if(node==null)return;
        preorderTraversal.add(node.data);
        traversal(node.left,preorderTraversal);
        traversal(node.right,preorderTraversal);
    }

}
