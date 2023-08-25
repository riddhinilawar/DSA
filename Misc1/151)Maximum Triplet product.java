628. Maximum Triplet product

Given an array arr of size n, the task is to find the maximum triplet product in the array.


Example 1:

Input:
n = 4
arr[] = {1, 2, 3, 5}
Output:
30
Explanation:
5*3*2 gives 30. This is the maximum possible
triplet product in the array.
Example 2:

Input:
n = 7
arr[] = {-3, -5, 1, 0, 8, 3, -2} 
Output:
120
Explanation: 
-3*-5*8 gives 120. This is the maximum possible triplet product in the array.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxTripletProduct() which takes an integer n and an array arr and returns the maximum triplet product in the array.


Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)


Constraints:
3 ≤ N ≤ 5*105
-106 ≤ A[i] ≤ 106

class Solution {
    Long maxTripletProduct(Long arr[], int n)
    {
        long ans=0;
        long posans=0;
        long negans=0;
        long big=Long.MIN_VALUE;
        long mid=Long.MIN_VALUE;
        long small=Long.MIN_VALUE;
        
        long s_big=Long.MAX_VALUE;
        long s_mid=Long.MAX_VALUE;
        
        for(int i=0;i<arr.length;i++){
            //for positive numbers
            if(big <= arr[i]){
                small=mid;
                mid=big;
                big=arr[i];
            }
            else if(mid<= arr[i]){
                small=mid;
                mid=arr[i];
            }
            else if(small<=arr[i]){
                small=arr[i];
            }
            
            //for negative numbers
            if(s_big >= arr[i]){
                s_mid=s_big;
                s_big=arr[i];
            }
            else if(s_mid>=arr[i]){
                s_mid=arr[i];
            }
        }
        posans=big*mid*small;
        negans=big*s_big*s_mid;
        ans=(posans>=negans)?posans:negans;
        return ans;
    }
}
