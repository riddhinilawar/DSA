Construct tree from Inorder and LevelOrder
Given inorder and level-order traversals of a Binary Tree, construct the Binary Tree and return the root Node. 
Input:
First line consists of T test cases. First line of every test case consists of N, denoting number of elements is respective arrays. Second and third line consists of arrays containing Inorder and Level-order traversal respectively.
Output:
Single line output, print the preOrder traversal of array.
Constraints:
1<=T<=100
1<=N<=100
Example:
Input:
2
3
1 0 2 
0 1 2 
7
3 1 4 0 5 2 6 
0 1 2 3 4 5 6 
Output:
0 1 2
0 1 3 4 2 5 6
class GfG
{
    Node buildTree(int inord[], int level[])
    {
        Node node=new Node(level[0]);
        helper(node,0,level,level.length);
        return node;
    }
    public void helper(Node node,int lvl,int[] level,int n){
        if(2*lvl+1<n){
            Node tmp=new Node(level[2*lvl+1]);
            node.left=tmp;
            helper(tmp,2*lvl+1,level,n);
        }
        if(2*lvl+2<n){
            Node tmp=new Node(level[2*lvl+2]);
            node.right=tmp;
            helper(tmp,2*lvl+2,level,n);
        }
    }
}
