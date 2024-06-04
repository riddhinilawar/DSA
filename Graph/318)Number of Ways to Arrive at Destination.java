1976)Number of Ways to Arrive at Destination
You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.
You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.
Example 1:
Input:
n=7, m=10
edges= [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]

Output:
4
Explaination:

The four ways to get there in 7 minutes are:
- 0  6
- 0  4  6
- 0  1  2  5  6
- 0  1  3  5  6
 
Example 2:
Input:
n=6, m=8
edges= [[0,5,8],[0,2,2],[0,1,1],[1,3,3],[1,2,3],[2,5,6],[3,4,2],[4,5,2]]

Output:
3
Explaination:

The three ways to get there in 8 minutes are:
- 0  5
- 0  2  5
- 0  1  3  4  5
 
Constraints:
1 <= n <= 200
n - 1 <= roads.length <= n * (n - 1) / 2
roads[i].length == 3
0 <= ui, vi <= n - 1
1 <= timei <= 109
ui != vi
There is at most one road connecting any two intersections.
You can reach any intersection from any other intersection.

Expected Time Complexity: O(M * logN + N)
Expected Space Complexity: O(M+N)

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        
        HashMap<Integer,ArrayList<Pair>> adjlist = new HashMap<>();
        
        for(List list : roads){
            adjlist.putIfAbsent((Integer)list.get(0), new ArrayList<>());
            adjlist.putIfAbsent((Integer)list.get(1), new ArrayList<>());
            
            adjlist.get((Integer)list.get(0)).add(new Pair((Integer)list.get(1),(Integer)list.get(2)));
            adjlist.get((Integer)list.get(1)).add(new Pair((Integer)list.get(0),(Integer)list.get(2)));
        }
        
        long dist[]=new long[n+1];
        int ways[]=new int[n+1];
        
        int mod=1000000007;
        
        Arrays.fill(dist,Long.MAX_VALUE);
        ways[0]=1;
        dist[0]=0l;
        
        PriorityQueue<Pair1> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Pair1 p1, Pair1 p2) {
                return Long.compare(p1.distance, p2.distance);
            }
        });
        
        pq.add(new Pair1((long)0,0));
        
        while(!pq.isEmpty()){
            Pair1  p1 = pq.poll();
            
            int node = p1.node;
            long distance = p1.distance;
            
            if(adjlist.get(node)!=null){
                for(Pair p : adjlist.get(node)){
                    int nnode = p.to;
                    long ndistance = p.distance;
                
                    if(dist[nnode] > distance + ndistance){
                        dist[nnode] = distance + ndistance;
                        ways[nnode] = ways[node];
                        pq.add(new Pair1(dist[nnode],nnode));
                    }
                    else if(dist[nnode] == distance + ndistance){
                        ways[nnode] = (ways[nnode]+ways[node])%mod;
                    }
                }
            }
            
        }
        
        return ways[n-1]%mod;
    }
}
class Pair{
    int to;
    long distance;
    Pair(int to,long distance){
        this.to=to;
        this.distance=distance;
    }
}
class Pair1{
    long distance;
    int node;
    Pair1(long distance, int node){
        this.distance=distance;
        this.node=node;
    }
}



