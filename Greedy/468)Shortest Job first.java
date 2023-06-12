Geek is a software engineer. He is assigned with a task of calculating average waiting time of all the processes by following shortest job first policy.

The shortest job first (SJF) or shortest job next, is a scheduling policy that selects the waiting process with the smallest execution time to execute next.

Given an arrays of integers bt of size n. Array bt denotes burst time of each process. Calculate average waiting time of all the processes and return the nearest integer which is smaller or equal to the output.

Note: Consider all process are availiable at time 0.

Example 1:

Input:
n = 5
bt = [4,3,7,1,2]
Output: 4
Explanation: After sorting burst times by shortest job policy, calculated average waiting time is 4.
Example 2:

Input:
n = 4
arr = [1,2,3,4]
Output: 2
Explanation: After sorting burst times by shortest job policy, calculated average waiting time is 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function solve() which takes bt[] as input parameter and returns the average waiting time of all the processes.

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 100
1 <= arr[i] <= 100
  
class Solution {
    static int solve(int bt[] ) {
    
        Arrays.sort(bt);
        
        int totalWeightingTime=0;
        int sum=0;
        
        for(int i=0;i<bt.length-1;i++){
            sum+=bt[i];
            totalWeightingTime+=sum;
            //System.out.println(totalWeightingTime+" "+sum);
        }
        
        return totalWeightingTime/bt.length;

  }
}
     
