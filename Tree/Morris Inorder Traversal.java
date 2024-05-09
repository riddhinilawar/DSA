class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();

        // Pointer to the current node,
        // starting with the root
        Node cur = root;

        // Iterate until the
        // current node becomes null
        while (cur != null) {
            // If the current node
            // has no left child
            if (cur.left == null) {
                // Add the value of the
                // current node to the inorder list
                inorder.add(cur.data);

                // Move to the right child
                cur = cur.right;
            } else {
                
                // If the current node has a left child
                // Create a pointer to traverse to the
                // rightmost node in the left subtree
                Node prev = cur.left;

                // Traverse to the rightmost node in the
                // left subtree or until we find a node
                // whose right child is not yet processed
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                // If the right child of the
                // rightmost node is null
                if (prev.right == null) {
                    // Set the right child of the
                    // rightmost node to the current node
                    prev.right = cur;
                   

                    // Move to the left child
                    cur = cur.left;
                } else {
                    // If the right child of the
                    // rightmost node is not null
                    // Reset the right child to null
                    prev.right = null;
                     // Add the value of the
                    // current node to the inorder list
                    inorder.add(cur.data);
                    

                    // Move to the right child
                    cur = cur.right;
                }
            }
        }

        // Return the resulting
        // inorder traversal list
        return inorder;
    }

}
