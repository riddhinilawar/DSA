You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
  
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res=new ArrayList<>();
        
        //If no intervel is present//
        if(intervals.length==0){
            res.add(newInterval);
            return res.toArray(new int[0][]); 
        }


        //If the range is before all intervals//
        if(newInterval[1]<intervals[0][0]){
            res.add(newInterval);
            for(int[] interval: intervals)
                res.add(interval);
            return res.toArray(new int[0][]); 
        }
        
        int start=intervals[0][0];
        int end=intervals[0][1];
        boolean interval_insertes=false;


        //traverse and try to merge intervals//
        for(int i=0;i<intervals.length;i++){
            if(interval_insertes==false && newInterval[0] <= intervals[i][0]){
                if(newInterval[0] <= end){
                    start=Math.min(start,newInterval[0]);
                    end=Math.max(end,newInterval[1]);
                }
                else{
                    res.add(new int[]{start,end});
                    start=newInterval[0];
                    end=newInterval[1];
                }
                i--;
                interval_insertes=true;
            }
            else if(intervals[i][0]<=end){
                end=Math.max(end,intervals[i][1]);
            }
            else{
                res.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        res.add(new int[]{start,end});


        //If the interval is present at the last//
        if(interval_insertes==false){
            int temp[]=res.get(res.size()-1);
            if(temp[1]>=newInterval[0]){
                res.remove(res.size()-1);
                res.add(new int[]{Math.min(temp[0],newInterval[0]),Math.max(temp[1],newInterval[1])});
            }
            else{
                res.add(newInterval);
            }
        }
        
        return res.toArray(new int[0][]);
    }
}
