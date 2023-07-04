297. Serialize and Deserialize Binary Tree
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 
Example 1:
 
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:
Input: root = []
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
public class Codec {

   int curr=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            
            if(temp.val==10001){
                sb.append("N#");
                continue;
            }
            sb.append(temp.val);
            sb.append("#");

            if(temp.left==null)
                q.offer(new TreeNode(10001));
            else
                q.offer(temp.left);

            if(temp.right==null)
                q.offer(new TreeNode(10001));
            else
                q.offer(temp.right);
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")return null;
        Queue<TreeNode> q =new LinkedList<>();
        int value=getValue(data);
        TreeNode root=new TreeNode(value);
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();

            value=getValue(data);
            if(value==1001){
                temp.left=null;
            }
            else{
                TreeNode left=new TreeNode(value);
                temp.left=left;
                q.offer(left);
            }

            value=getValue(data);
            if(value==1001){
                temp.right=null;
            }
            else{
                TreeNode right=new TreeNode(value);
                temp.right=right;
                q.offer(right);
            }
        }
        return root;
    }
    public int getValue(String data){
        String s="";
        while(data.charAt(curr)!='#'){
            s+=data.charAt(curr);
            curr++;
        }
        curr++;
        if(s.equals("N"))return 1001;
        return Integer.parseInt(s);
    }
}
