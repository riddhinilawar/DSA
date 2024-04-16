Minimum Time to Collect All Apples in a Tree
Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to collect all apples in the tree, starting at vertex 0 and coming back to this vertex.
The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.
 
Example 1:
 
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
Output: 8 
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.  
Example 2:
 
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
Output: 6
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.  
Example 3:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
Output: 0
 
Constraints:
1 <= n <= 105
edges.length == n - 1
edges[i].length == 2
0 <= ai < bi <= n - 1
hasApple.length == n

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer,ArrayList<Integer>> adjlist = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<edges.length;i++){
            
            if(set.contains(edges[i][0]) == true){
                adjlist.putIfAbsent(edges[i][0], new ArrayList<>());
                adjlist.get(edges[i][0]).add(edges[i][1]);
            }
            else if(set.contains(edges[i][1]) == true){
                adjlist.putIfAbsent(edges[i][1], new ArrayList<>());
                adjlist.get(edges[i][1]).add(edges[i][0]);
            }
            else{
                adjlist.putIfAbsent(edges[i][0], new ArrayList<>());
                adjlist.get(edges[i][0]).add(edges[i][1]);
            }

            set.add(edges[i][0]);
            set.add(edges[i][1]);
        }

        return helper(0,adjlist,hasApple,0);
    }
    public int helper(int node, HashMap<Integer,ArrayList<Integer>> adjlist, List<Boolean> hasApple,int root){

        if(adjlist.containsKey(node)==false && hasApple.get(node)==true)
            return 2;

        if(adjlist.containsKey(node)==false)
            return 0;

        int value=0;
        for(int i=0;i<adjlist.get(node).size();i++){
            value+=helper(adjlist.get(node).get(i),adjlist,hasApple,root);
        }

        //System.out.println(node+"-->"+value);

        if(node==root)
            return value;
        if(value>0)
            return value+2;
        if(hasApple.get(node)==true)
            return 2;
        return 0;
    }
}
