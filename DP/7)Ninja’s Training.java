Ninja’s Training


Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?

You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.

For Example
If the given ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will be 11 as 5 + 3 + 3.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 100000.
1 <= values of POINTS arrays <= 100 .

Time limit: 1 sec
Sample Input 1:
2
3
1 2 5 
3 1 1
3 3 3
3
10 40 70
20 50 80
30 60 90
Sample Output 1:
11
210
Explanation of sample input 1:
For the first test case,
One of the answers can be:
On the first day, Ninja will learn new moves and earn 5 merit points. 
On the second day, Ninja will do running and earn 3 merit points. 
On the third day, Ninja will do fighting and earn 3 merit points. 
The total merit point is 11 which is the maximum. 
Hence, the answer is 11.

For the second test case:
One of the answers can be:
On the first day, Ninja will learn new moves and earn 70 merit points. 
On the second day, Ninja will do fighting and earn 50 merit points. 
On the third day, Ninja will learn new moves and earn 90 merit points. 
The total merit point is 210 which is the maximum. 
Hence, the answer is 210.
Sample Input 2:
2
3
18 11 19
4 13 7
1 8 13
2
10 50 1
5 100 11
Sample Output 2:
45
110


==================================================Recursive Approach===============================

public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        int ans=0;

        ans=Math.max(ans,helper(0,0,n,points));
        ans=Math.max(ans,helper(1,0,n,points));
        ans=Math.max(ans,helper(2,0,n,points));
        return ans;
    }
    public static int helper(int currActivity,int day,int total,int points[][]){
        if(day==total){
            return 0;
        }

        int totalCost=0;

        if(currActivity!=0)
            totalCost=Math.max(totalCost,points[day][currActivity]+helper(0,day+1,total,points));

        if(currActivity!=1)
            totalCost=Math.max(totalCost,points[day][currActivity]+helper(1,day+1,total,points));

        if(currActivity!=2)
            totalCost=Math.max(totalCost,points[day][currActivity]+helper(2,day+1,total,points));

        return totalCost;
    }

}

TC:O(2^N)
SC:O(N)-->stack space
============================================Memoization==============================
import java.util.*;
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int dp[][]=new int[n+1][4];
        for(int temp[]:dp)Arrays.fill(temp,-1);
        return helper(n-1,3,points,dp);
    }
    public static int helper(int day, int last, int points[][],int dp[][]) {
        if(day<0){
            return 0;
        }
        if(dp[day][last]!=-1){
            return dp[day][last];
        }
        int totalCost=0;
        for(int i=0;i<=2;i++){
            if(i!=last){
                totalCost=Math.max(totalCost,points[day][i]+helper(day-1,i,points,dp));
            }
        }
        return dp[day][last]=totalCost;
    }

}
TC:O(3*N)
SC:O(3*N)
==========================================Tabulation==================================
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        int dp[][]=new int[n][3];
        int ans=0;
        for(int i=0;i<n;i++){
            if(i==0){

                for(int j=0;j<3;j++){
                    dp[i][j]=points[i][j];
                }

            }
            else{
                for(int j=0;j<3;j++){
                    if(j==0)dp[i][j]=points[i][j]+Math.max(dp[i-1][1],dp[i-1][2]);
                    else if(j==1)dp[i][j]=points[i][j]+Math.max(dp[i-1][0],dp[i-1][2]);
                    else if(j==2)dp[i][j]=points[i][j]+Math.max(dp[i-1][0],dp[i-1][1]);

                    if(i==n-1)ans=Math.max(ans,dp[i][j]);
                }
            }

        }

        return ans;
    }

}


TC:O(N*3)
SC:O(N*3)

======================================Space Optimization==============================

Just need last 2 arrays to get the last max values and keep the current computed values. 
  
TC:O(N*3)
SC:O(3*2)~o(6)~O(1)
