class Tree
{
    //Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root)
    {
        ArrayList<Integer> postorder = new ArrayList<>();

        // Pointer to the current node,
        // starting with the root
        Node cur = root;

        // Iterate until the
        // current node becomes null
        while (cur != null) {
            // If the current node
            // has no right child
            if (cur.right == null) {
                // Add the value of the
                // current node to the postorder list
                postorder.add(cur.data);

                // Move to the left child
                cur = cur.left;
            } else {
                
                // If the current node has a right child
                // Create a pointer to traverse to the
                // leftmost node in the right subtree
                Node prev = cur.right;

                // Traverse to the leftmost node in the
                // left subtree or until we find a node
                // whose left child is not yet processed
                while (prev.left != null && prev.left != cur) {
                    prev = prev.left;
                }

                // If the left child of the
                // leftmost node is null
                if (prev.left == null) {
                    // Set the left child of the
                    // leftmst node to the current node
                    prev.left = cur;
                    // Add the value of the
                    // current node to the postorder list
                    postorder.add(cur.data);

                    // Move to the left child
                    cur = cur.right;
                } else {
                    // If the left child of the
                    // leftmost node is not null
                    // Reset the left child to null
                    prev.left = null;

                    

                    // Move to the left child
                    cur = cur.left;
                }
            }
        }

        // Return the resulting
        // postorder traversal list
        Collections.reverse(postorder);
        return postorder;
    }

}
