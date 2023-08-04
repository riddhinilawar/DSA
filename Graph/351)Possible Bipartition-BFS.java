886. Possible Bipartition
We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.
Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
 
Example 1:
Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: The first group has [1,4], and the second group has [2,3].
Example 2:
Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Explanation: We need at least 3 groups to divide them. We cannot put them in two groups.
 
Constraints:
1 <= n <= 2000
0 <= dislikes.length <= 104
dislikes[i].length == 2
1 <= ai < bi <= n
All the pairs of dislikes are unique.

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, ArrayList<Integer>> adjlist = new HashMap<>();
        for(int i=0;i<=n;i++)adjlist.put(i,new ArrayList<>());
        for(int i=0;i<dislikes.length;i++){
            adjlist.get(dislikes[i][0]).add(dislikes[i][1]);
            adjlist.get(dislikes[i][1]).add(dislikes[i][0]);
        }

        int vis[]=new int[n+1];
        Queue<Integer> q= new LinkedList<>();
        int flag=1;
        
        for(int i=1;i<=n;i++){
        if(vis[i]!=0)continue;
        q.add(i);
        vis[i]=1;
       
        while(!q.isEmpty()){
            int curr=q.remove();
            for(int neighbour:adjlist.get(curr)){
                if(vis[neighbour]==0){
                    vis[neighbour]= -vis[curr];
                    q.add(neighbour);
                }
                else if(vis[neighbour] != -vis[curr])
                    flag=0;
            }
        }
        if(flag==0)return false;
        }
        return true;
    }
}
