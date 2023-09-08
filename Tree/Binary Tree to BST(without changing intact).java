Given a Binary Tree, convert it to Binary Search Tree in such a way that keeps the original structure of Binary Tree intact.
 Example 1:

Input:
      1
    /   \
   2     3
Output: 
1 2 3
Explanation:
The converted BST will be 
      2
    /   \
   1     3

Example 2:

Input:
          1
       /    \
     2       3
   /        
 4       
Output: 
1 2 3 4
Explanation:
The converted BST will be

        3
      /   \
    2     4
  /
 1
Your Task:
You don't need to read input or print anything. Your task is to complete the function binaryTreeToBST() which takes the root of the Binary tree as input and returns the root of the BST. The driver code will print inorder traversal of the converted BST.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 105

class Solution{
    Node binaryTreeToBST(Node root){
       LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
       helper(map,root);
       //System.out.println(map);
       ArrayList<Integer> list = new ArrayList<>(map.keySet());
       Collections.sort(list);
       int listIdx=0;
       for(int key:map.keySet()){
           map.put(key,list.get(listIdx++));
       }
       return generateBST(map,root);
    }
    void helper(LinkedHashMap<Integer,Integer> map, Node root){
        if(root==null)return;
        helper(map,root.left);
        map.put(root.data,-1);
        helper(map,root.right);
    }
    Node generateBST(LinkedHashMap<Integer,Integer> map, Node root){
        if(root==null)return null;
        Node newNode=new Node(map.get(root.data));
        newNode.left=generateBST(map,root.left);
        newNode.right=generateBST(map,root.right);
        return newNode;
    }
}
 
