1235. Maximum Profit in Job Scheduling

We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

 

Example 1:



Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
Example 2:



Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.
Example 3:



Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6
 

Constraints:

1 <= startTime.length == endTime.length == profit.length <= 5 * 104
1 <= startTime[i] < endTime[i] <= 109
1 <= profit[i] <= 104


  class Solution {
    public int helper(int idx,int jobDetails[][],int dp[],int totalJobs){

        if(idx==totalJobs){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }

        int endTimeOfCurrJob=jobDetails[idx][1];
        //for getting next job which start at or after curr job ends//
        int low=0,high=totalJobs-1,nextJobIdx=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(jobDetails[mid][0]>=endTimeOfCurrJob){
                nextJobIdx=mid;
                high=mid-1;
            }
            else{
                nextJobIdx=mid+1;
                low=mid+1;
            }
        }
        
        int pick=jobDetails[idx][2]+helper(nextJobIdx,jobDetails,dp,totalJobs);
        int notPick=0+helper(idx+1,jobDetails,dp,totalJobs);

        return dp[idx]=Math.max(pick,notPick);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int totalJobs=startTime.length;
        int jobDetails[][]=new int[totalJobs][3];
        int dp[]=new int[totalJobs];
        Arrays.fill(dp,-1);
        
        for(int i=0;i<totalJobs;i++){
            jobDetails[i][0]=startTime[i];
            jobDetails[i][1]=endTime[i];
            jobDetails[i][2]=profit[i];
        }

        Arrays.sort(jobDetails,(j1,j2)->{
            if(j1[0]!=j2[0])
            {
                return j1[0]-j2[0];
            }
            else if(j1[1]!=j2[1]) { // then by end time
                return j1[1]-j2[1];
            }
            else { //then by profit
                return j2[2]-j1[2];
            }

        });
        return helper(0,jobDetails,dp,totalJobs);
    }
}
