Find Bottom Left Tree Value

Given the root of a binary tree, return the leftmost value in the last row of the tree.
 
Example 1:
 
Input: root = [2,1,3]            Output: 1
Example 2:
 
Input: root = [1,2,3,4,null,5,6,null,null,7]             Output: 7
 
Constraints:
The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.peek();
                q.remove();
                list.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            ans=list.get(0);
        }
        return ans;
    }
}

Gfg:
class Solution
{
  static ArrayList < Integer > verticalOrder(Node root) {
  ArrayList < Integer > integerArrayList = new ArrayList < > ();
  TreeMap < Integer, ArrayList < Integer >> treeMap = new TreeMap < > ();
  Queue < Node > queue = new LinkedList < > ();
  queue.add(root);
  Queue < Integer > indeces = new LinkedList < > ();
  indeces.add(0);

  while (!queue.isEmpty() && !indeces.isEmpty()) {
    int size = queue.size();
    for (int i = 0; i < size; i++) {
      Node current = queue.poll();
      Integer index = indeces.poll();
      treeMap.putIfAbsent(index, new ArrayList < > ());
      if (current != null) {
        treeMap.get(index).add(current.data);
      }

      if (current != null && index != null && current.left != null) {
        queue.add(current.left);
        indeces.add(index - 1);
      }

      if (current != null && index != null && current.right != null) {
        queue.add(current.right);
        indeces.add(index + 1);
      }

    }
  }

  for (Map.Entry < Integer, ArrayList < Integer >> integerVector: treeMap.entrySet()) {
    integerArrayList.addAll(integerVector.getValue());
  }

  return integerArrayList;
}
}


------------------------------------------------------------------------------------------------------------------------------------------------------------------
Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 
Example 1:
 
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:
Input: root = [1,null,3]
Output: [1,3]
Example 3:
Input: root = []
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null)return ans;
        helper(root,ans,0);
        return ans;
    }
    public void helper(TreeNode node,List<Integer> ans,int level){
        if(node==null)
            return;
        if(level==ans.size())ans.add(node.val);
        if(node.right!=null) helper(node.right,ans,level+1);
        if(node.left!=null) helper(node.left,ans,level+1);
    }
}

