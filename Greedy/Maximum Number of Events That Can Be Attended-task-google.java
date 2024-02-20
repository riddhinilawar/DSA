1353. Maximum Number of Events That Can Be Attended

Note:: 
 
Create the array of (max+2 size) to know on which day that event can be attanded. 
Find the next day from the start on that event can be attended.
if the event day is greater than end day then do nothing
else count++, and mark the [event attend] day which the next possible day on which event can be attended.
 
You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

Return the maximum number of events you can attend.

 

Example 1:


Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.
Example 2:

Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4
 

Constraints:

1 <= events.length <= 105
events[i].length == 2
1 <= startDayi <= endDayi <= 105

class Solution {
    public int maxEvents(int[][] events) {
        
        int n=events.length;
        int count=0;
       
        Arrays.sort(events,(a,b)->a[1]-b[1]);
        
        int last=events[n-1][1];
        int[] parent=new int[last+2];
        for(int i=0;i<last+2;i++){
            parent[i]=i;
        }

        for(int[] event:events){ 
            System.out.println(event[0]+" "+event[1]);
            int parent_event=find(parent,event[0]);
            System.out.println(parent_event);
            if(parent_event<=event[1]){
                count++;
                parent[parent_event]=find(parent,parent_event+1);
                System.out.println("count::"+count+" "+parent[parent_event]);
            }
        }
        return count;
    }
    
    private int find(int[] parent,int x){
        if(parent[x]!=x){
            parent[x]=find(parent,parent[x]);
        }
        return parent[x];
    }
}


events =
[[1,5],[1,5],[1,5],[2,3],[2,3]]
Stdout
2 3
2
count::1 3
2 3
3
count::2 4
1 5
1
count::3 4
1 5
4
count::4 5
1 5
5
count::5 6

========================================================================================================================

class Solution {
        public int maxEvents(int[][] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, res = 0, n = A.length;
        for (int d = 1; d <= 100000; ++d) {
            while (!pq.isEmpty() && pq.peek() < d)
                pq.poll();
            while (i < n && A[i][0] == d)
                pq.offer(A[i++][1]);
            if (!pq.isEmpty()) {
                pq.poll();
                ++res;
            }
        }
        return res;
    }
}
