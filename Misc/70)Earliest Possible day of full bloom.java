Earliest Possible day of full bloom, gfg                          LC-2136
You have n flower seeds. Every seed must be planted first before it can begin to grow, then bloom. Planting a seed takes time and so does the growth of a seed. You are given two 0-indexed integer arrays plantTime and growTime, of length n each:
•	plantTime[i] is the number of full days it takes you to plant the ith seed. Every day, you can work on planting exactly one seed. You do not have to work on planting the same seed on consecutive days, but the planting of a seed is not complete until you have worked plantTime[i] days on planting it in total.
•	growTime[i] is the number of full days it takes the ith seed to grow after being completely planted. After the last day of its growth, the flower blooms and stays bloomed forever.
From the beginning of day 0, you can plant the seeds in any order.
Return the earliest possible day where all seeds are blooming.
 
Example 1:
 
Input: plantTime = [1,4,3], growTime = [2,3,1]
Output: 9
Explanation: The grayed out pots represent planting days, colored pots represent growing days, and the flower represents the day it blooms.
One optimal way is:
On day 0, plant the 0th seed. The seed grows for 2 full days and blooms on day 3.
On days 1, 2, 3, and 4, plant the 1st seed. The seed grows for 3 full days and blooms on day 8.
On days 5, 6, and 7, plant the 2nd seed. The seed grows for 1 full day and blooms on day 9.
Thus, on day 9, all the seeds are blooming.
Example 2:
 
Input: plantTime = [1,2,3,2], growTime = [2,1,2,1]
Output: 9
Explanation: The grayed out pots represent planting days, colored pots represent growing days, and the flower represents the day it blooms.
One optimal way is:
On day 1, plant the 0th seed. The seed grows for 2 full days and blooms on day 4.
On days 0 and 3, plant the 1st seed. The seed grows for 1 full day and blooms on day 5.
On days 2, 4, and 5, plant the 2nd seed. The seed grows for 2 full days and blooms on day 8.
On days 6 and 7, plant the 3rd seed. The seed grows for 1 full day and blooms on day 9.
Thus, on day 9, all the seeds are blooming.
Example 3:
Input: plantTime = [1], growTime = [1]
Output: 2
Explanation: On day 0, plant the 0th seed. The seed grows for 1 full day and blooms on day 2.
Thus, on day 2, all the seeds are blooming.
 
Constraints:
•	n == plantTime.length == growTime.length
•	1 <= n <= 105
•	1 <= plantTime[i], growTime[i] <= 104
Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(N)
class Solution 
{
    public int earliestFullBloom(int[] plantTime, int[] growTime) 
    {
        int n = plantTime.length;
        int[][] pairs = new int[n][2];
        
        for (int i = 0; i < n; i++) 
        {
            pairs[i][0] = plantTime[i];
            pairs[i][1] = growTime[i];
        }
        
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        
        int ans = 0, sum = 0;
        
        for (int[] pair : pairs) 
        {
            sum += pair[0];
            ans = Math.max(ans, sum + pair[1]);
        }
        
        return ans;
    }
}




















O(logn) – accepted on Leetcode ,  Space complexity: O(2*N)

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {

        int n=plantTime.length;

        int arr[][] = new int[n][2] ;

        for(int i=0;i<n;i++)
        {
            arr[i][1]=plantTime[i];
            arr[i][0]=growTime[i];
        }

        Arrays.sort(arr,(a,b)->b[0]-a[0]);

        for(int i=0;i<n;i++)
        {
            plantTime[i]=arr[i][1];
            growTime[i]=arr[i][0];
        }

        int blooming_complete[] = new int[plantTime.length];

        int sum=0;
        for(int i=0;i<n;i++){
            sum+=plantTime[i];
            blooming_complete[i]=sum;
        }

        int max=0;
        for(int i=0;i<n;i++){
            blooming_complete[i]+=growTime[i];
            max=Math.max(max,blooming_complete[i]);
        }

        return max;
    }
}


















Time complexity: O(nlogn) – got TLE on Leetcode ,  Space complexity: O(N)
class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {

        int n=plantTime.length;

        for(int i=1;i<n;i++){
            for(int j=i;j>=1;j--)
            {
                if(growTime[j]<=growTime[j-1])
                    break;
                else {
                    int temp=growTime[j-1];
                    growTime[j-1]=growTime[j];
                    growTime[j]=temp;

                    temp=plantTime[j-1];
                    plantTime[j-1]=plantTime[j];
                    plantTime[j]=temp;
                }
            }
        }

        int blooming_complete[] = new int[plantTime.length];

        int sum=0;
        for(int i=0;i<n;i++){
            sum+=plantTime[i];
            blooming_complete[i]=sum;
        }

        int max=0;
        for(int i=0;i<n;i++){
            blooming_complete[i]+=growTime[i];
            max=Math.max(max,blooming_complete[i]);
        }

        return max;
    }
}

