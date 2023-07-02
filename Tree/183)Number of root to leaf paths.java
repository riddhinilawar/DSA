Number of root to leaf paths

Given a binary tree, you need to find the number of all root to leaf paths along with their path lengths.
Example 1:
Input:
      3
    /   \
   2     4
Output:
2 2 $

Explanation :
There are 2 roots to leaf paths
of length 2(3 -> 2 and 3 -> 4)
Example 2:
Input:
        10
     /   \
    20    30
   / \    
  40  60

Output:
2 1 $3 2 $

Explanation:
There is 1 root leaf paths of
length 2 and 2 roots to leaf paths
of length 3.
Your Task:
Your task is to complete the function pathCounts that prints the number of all root to leaf paths along with their path length separated by space and "$".
Constraints:
1 <= T <= 30
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000








class GfG
{
    void countPaths(Node root)
    {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        ArrayList<Integer> temp=new ArrayList<>();
        if(root==null)return;
        getPath(root,map,temp);
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
            System.out.print(entry.getKey()+" "+entry.getValue()+" $");
        
    }

    public void getPath(Node root, TreeMap<Integer,Integer> map, ArrayList<Integer> temp){

        if(root==null) return;
        temp.add(root.data);
        if(root.left==null&&root.right==null){
            map.put(temp.size(),map.getOrDefault(temp.size(),0)+1);
        }

        getPath(root.left,map,temp);
        getPath(root.right,map,temp);
        temp.remove(temp.size()-1);
    }
    
}
