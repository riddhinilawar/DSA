class Pair{
    Node node;
    int num;
    Pair(Node node,int num){
        this.node=node;
        this.num=num;
    } }
class BinaryTree
{
    static void traversal(Node root)
    {
        ArrayList<Integer> preordertraversal=new ArrayList<>();
        ArrayList<Integer> inordertraversal=new ArrayList<>();
        ArrayList<Integer> postordertraversal=new ArrayList<>();
                
        Stack<Pair> stack=new Stack<>();
        stack.push(new Pair(root,1));
        
        while(!stack.isEmpty()){
            Node temp=stack.peek().node;
            int num=stack.peek().num;
            stack.pop();
            
            switch(num){
                case 1:
                    preordertraversal.add(temp.data);
                    stack.push(new Pair(temp,num+1));
                    if(temp.left!=null)
                    stack.push(new Pair(temp.left,1));
                    break;
                case 2:
                    inordertraversal.add(temp.data);
                    stack.push(new Pair(temp,num+1));
                    if(temp.right!=null)
                    stack.push(new Pair(temp.right,1));
                    break;
                    
                case 3:
                    postordertraversal.add(temp.data);
                    break;
            }}
        System.out.println(preordertraversal+” “+inordertraversal+” “+postordertraversal);
}
}
