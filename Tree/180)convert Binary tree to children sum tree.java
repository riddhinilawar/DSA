Code to convert Binary tree to children sum tree
class Tree
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static void isSumProperty(Node root)
    {
        if(root==null)return;
        
        int child=0;
        if(root.left!=null)child+=root.left.data;
        if(root.right!=null)child+root.right.data;
        
        if(child>=root)root.data=child;
        else{
            if(root.left!=null)root.left.data=root.data;
            if(root.right!=null)root.right.data=root.data;
        }
        
        isSumProperty(root.left);
        isSumProperty(root.right);
        
        int total=0;
        if(root.left!=null)total+=root.left.data;
        if(root.right!=null)total+=root.right.data;
        if(root.left!=null||root.right!=null)root.data=total;
    }
}
