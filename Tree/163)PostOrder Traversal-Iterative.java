class Tree
{
    //Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root)
    {
       ArrayList<Integer> postordertraversal=new ArrayList<>();
        if(root==null) 
            return postordertraversal;
        
        Stack<Node> stack=new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node temp=stack.pop();
            if(temp.left!=null)stack.add(temp.left);
            if(temp.right!=null)stack.add(temp.right);
            postordertraversal.add(temp.data);
        }
        Collections.reverse(postordertraversal);
        return postordertraversal;
    }
}
------------------------------------------------------------------------------------------------------------------------------------------
POSTORDER TRAVERSAL – ITERARTIVE USING 1 STACKS

class Tree
{
    //Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root)
    {
       ArrayList<Integer> postordertraversal=new ArrayList<>();
        if(root==null) 
            return postordertraversal;
        
        Stack<Node> stack=new Stack<>();
        Node node=root;
        
        while((!stack.isEmpty()) || node!=null){
            if(node!=null){
                stack.add(node);
                node=node.left;
            }
            else{
                Node temp=stack.peek().right;
                if(temp==null){
                    temp=stack.pop();
                    postordertraversal.add(temp.data);
                    while((!stack.isEmpty()) && temp == stack.peek().right){
                        temp=stack.pop();
                        postordertraversal.add(temp.data);
                    }
                }
                else 
                    node=temp;
            }
        }
        return postordertraversal;
    }
}


