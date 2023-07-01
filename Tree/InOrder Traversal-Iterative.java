class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> inordertraversal = new ArrayList<>();
        if(root==null) 
            return inordertraversal;
        Stack<Node> stack = new Stack<>();
        Node node=root;
        while(true){
            if(node!=null){
                stack.add(node);
                node=node.left;
            }
            else{
                if(stack.isEmpty()==true)
                    break;
                node=stack.pop();
                inordertraversal.add(node.data);
                node=node.right;
            }
        }
        return inordertraversal;
    }
}


