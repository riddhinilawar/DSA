743. Network Delay Time

You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int minTime[]=new int[n+1];
        Arrays.fill(minTime,Integer.MIN_VALUE);
        minTime[k]=0;

        HashMap<Integer,ArrayList<Pair>> adjList = new HashMap<>();

        for(int time[]:times){
            int from=time[0];
            int to=time[1];
            int currTime=time[2];

            adjList.putIfAbsent(from,new ArrayList<>());
            adjList.get(from).add(new Pair(to,currTime));
        }

        dijkstrasAlgo(k,adjList,minTime);

        minTime[0]=0;
        if(Arrays.stream(minTime).anyMatch(num -> num == Integer.MIN_VALUE))return -1; 
        return Arrays.stream(minTime).max().getAsInt();
    }
    public void dijkstrasAlgo(int node,HashMap<Integer,ArrayList<Pair>> adjList,int minTime[]){
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(node,0));

        while(!q.isEmpty()){

            Pair p=q.remove();
            int currNode=p.to;
            int currTime=p.time;

            if(adjList.get(currNode)==null)continue;
            for(Pair neg:adjList.get(currNode)){
                int negNode=neg.to;
                int negTime=neg.time;

                if(minTime[negNode] == Integer.MIN_VALUE || currTime+negTime < minTime[negNode]){
                    minTime[negNode]=currTime+negTime;
                    q.add(new Pair(negNode,currTime+negTime));
                }
            }
        }
    }
}
class Pair{
    int to;
    int time;
    Pair(int to,int time){
        this.to=to;
        this.time=time;
    }
}
