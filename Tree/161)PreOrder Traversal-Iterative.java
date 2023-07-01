class BinaryTree
{
    //Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> preordertraversal=new ArrayList<>();
        if(root==null) 
            return preordertraversal;
        
        Stack<Node> stack=new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node temp=stack.pop();
            if(temp.right!=null)stack.add(temp.right);
            if(temp.left!=null)stack.add(temp.left);
            preordertraversal.add(temp.data);
        }
        return preordertraversal;
    }

}
