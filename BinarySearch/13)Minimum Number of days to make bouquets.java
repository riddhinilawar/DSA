Minimum Number of days to make bouquets      LC-1482

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if((long)bloomDay.length<((long)m*(long)k))
            return -1;
        
        int low=1;
        int high=bloomDay[0];
        int ans=1;
        
        for(int day:bloomDay)
            high=Math.max(high,day);
        
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(bouquets(bloomDay,m, k,mid)<m){
                low=mid+1;
            }
            else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
    public int bouquets(int[] bloomDay, int m, int k,int day){
        if(k==1){
            int ans=0;
            for(int d:bloomDay)
                if(d<=day)ans++;            
            return ans;
        }
        
        int count=1,ans=0;
        for(int i=1;i<bloomDay.length;i++){
            if(bloomDay[i]<=day&&bloomDay[i-1]<=day){
                count++;
                if(count==k){
                    ans++;
                    count=0;
                }
            }
            else if(bloomDay[i]<=day)
                count=1;
        }
        return ans;
    }
}
        

  
You are given an integer array bloomDay, an integer m and an integer k.
You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
 
Example 1:
Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
Example 2:
Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
Output: -1
Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
Example 3:
Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
Output: 12
Explanation: We need 2 bouquets each should have 3 flowers.
Here is the garden after the 7 and 12 days:
After day 7: [x, x, x, x, _, x, x]
We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
After day 12: [x, x, x, x, x, x, x]
It is obvious that we can make two bouquets in different ways.
 
Constraints:
•	bloomDay.length == n
•	1 <= n <= 105
•	1 <= bloomDay[i] <= 109
•	1 <= m <= 106
•	1 <= k <= n•	
Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)


    class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)bloomDay.length<((long)m*(long)k))
            return -1;
        
        int low=1;
        int high=bloomDay[0];
        int ans=1;
        
        for(int day:bloomDay)
            high=Math.max(high,day);

        while(low<=high){
            int mid=low+(high-low)/2;
 
            if(helper(bloomDay,k,mid)>=m){
                //System.out.println("In 1");
                high=mid-1;
                ans=mid;
            }
            else{
                //System.out.println("In 2");
                low=mid+1;
            }
        }
        return low;
    }
    public int helper(int[] bloomDay, int adjFlow,int mid){
        int bouquets=0;
        int count=0;
        for(int i=0;i<bloomDay.length;i++){
            if(i==0 && bloomDay[i]<=mid){
                count=1;
                if(count==adjFlow){
                    count=0;
                    bouquets++;
                }
            }
            else if(bloomDay[i]<=mid && bloomDay[i-1]<=mid){
                count++;
                if(count==adjFlow){
                    count=0;
                    bouquets++;
                }
            }
            else if(bloomDay[i]<=mid){
                count=1;
                if(count==adjFlow){
                    count=0;
                    bouquets++;
                }
            }
        }
        //System.out.println(mid+" "+bouquets);
        return bouquets;
    }
}
