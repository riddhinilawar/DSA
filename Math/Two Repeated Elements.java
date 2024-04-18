Two Repeated Elements
MediumAccuracy: 28.95%Submissions: 91K+Points: 4
You are given an integer n and an integer array arr of size n+2. All elements of the array are in the range from 1 to n. Also, all elements occur once except two numbers which occur twice. Find the two repeating numbers.
Note: Return the numbers in their order of appearing twice. So, if X and Y are the repeating numbers, and X's second appearance comes before second appearance of Y, then the order should be (X, Y).

Example 1:

Input:
n = 4
arr[] = {1,2,1,3,4,3}
Output: 
1 3
Explanation: 
In the given array, 1 and 3 are repeated two times and as 1's second appearance occurs before 2's second appearance, so the output should be 1 3.
Example 2:

Input:
n = 2
arr[] = {1,2,2,1}
Output: 
2 1
Explanation: 
In the given array, 1 and 2 are repeated two times and second occurence of 2 comes before 1. So the output is 2 1.
Your Task:
The task is to complete the function repeatedElements() which takes an integer array arr[] and an integer n as inputs (the size of the array is n + 2 and elements are in the range [1, n]) and finds the two repeated elements in the array and return them in an array.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1). 

Constraints:
2 ≤ n ≤ 105
1 ≤ arr[i] ≤ n

class Solution{
    //Function to find two repeated elements.
    public int[] twoRepeated(int arr[], int n){
        int ans[]=new int[2];
        int ansIdx=0;
        
        for(int i=0;i<n+2;i++){
            
            if(Math.abs(arr[i])>0 && Math.abs(arr[i])<=n && arr[Math.abs(arr[i])] < 0){
                ans[ansIdx++]=Math.abs(arr[i]);
            }
            
            arr[Math.abs(arr[i])]=-arr[Math.abs(arr[i])];
            
        }
        
        
        return ans;
    }
    
}
