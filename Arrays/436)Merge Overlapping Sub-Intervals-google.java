Merge Overlapping Sub-Intervals                    LC-56
Solution 1: Brute force
Approach: First check whether the array is sorted or not.If not sort the array. Now linearly iterate over the array and then check for all of its next intervals whether they are overlapping with the interval at the current index. Take a new data structure and insert the overlapped interval. If while iterating if the interval lies in the interval present in the data structure simply continue and move to the next interval.
be adjacent. We kept on merging simultaneously as we were traversing through the array and when the element was non-overlapping we simply inserted the element in our data structure.

Time Complexity: O(NlogN)+O(N*N). O(NlogN) for sorting the array, and O(N*N) because we are checking to the right for each index which is a nested loop.
Space Complexity: O(N), as we are using a separate data structure.

Solution 2: Optimal approach
Approach: Linearly iterate over the array if the data structure is empty insert the interval in the data structure. If the last element in the data structure overlaps with the current interval we merge the intervals by updating the last element in the data structure, and if the current interval does not overlap with the last element in the data structure simply insert it into the data structure.
Intuition: Since we have sorted the intervals, the intervals which will be merging are bound to
Time Complexity: O(NlogN) + O(N). O(NlogN) for sorting and O(N) for traversing through the array.
Space Complexity: O(N) to return the answer of the merged intervals.
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 
Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 
Constraints:
•	1 <= intervals.length <= 104
•	intervals[i].length == 2
•	0 <= starti <= endi <= 104
Leetcode:
class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res=new ArrayList<>();
        
        if(intervals.length==0||intervals==null)
        {
            return (new int[0][]);
        }
        if(intervals.length==1)
        {
            return intervals;
        }
        
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        int start=intervals[0][0];
        int end=intervals[0][1];
        
        for(int[] i:intervals)
        {
            if(i[0]<=end)
            {
                end=Math.max(end,i[1]);
            }
            else
            {
                res.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
        }
         res.add(new int[]{start,end});
         return res.toArray(new int[0][]);
    }
}
public static int[][] overlappedInterval(int[][] Intervals)
    {
       
        Stack<int[]> stack = new Stack<>();
        
        Arrays.sort(Intervals, (a, b) -> {return a[0] - b[0];});       
        
        stack.push(Intervals[0]);
        
        for(int i = 1; i < Intervals.length; i++){
            int[] top = stack.peek();
            if(Intervals[i][0] > top[1]) stack.push(Intervals[i]);
            else{
                top[1] = Math.max(Intervals[i][1], top[1]);
                stack.pop();
                stack.push(top);
            }
        }
   
        int[][] result = new int[stack.size()][2];
        int i = stack.size() -1;
        
        while(!stack.isEmpty()){
            result[i--] = stack.pop();
        }
        
        return result;}
