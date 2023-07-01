class Level_Order_Traverse
{
    //Function to return the level order traversal line by line of a tree.
    static ArrayList<ArrayList<Integer>> levelOrder(Node node) 
    {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        if(node==null)return arr;
        q.add(node);
        while(!q.isEmpty()){
            int qsize=q.size();
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0;i<qsize;i++){
                if(q.peek().left!=null)q.add(q.peek().left);
                if(q.peek().right!=null)q.add(q.peek().right);
                temp.add(q.poll().data);
            }
            arr.add(temp);
        }
        return arr;
    }
}


