1539. Kth Missing Positive Number

Node: Find the missing numbers at given index and then find the ceil of k for all.
edge case when the missing number is less than first given number in array
          when the missing number is greater than last given number in array
  
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

 

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 

Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
arr[i] < arr[j] for 1 <= i < j <= arr.length
 

Follow up:

Could you solve this problem in less than O(n) complexity?

  class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;

        if(k<arr[0]){
            return k;
        }
        else if(k > (arr[n-1]-n)){
            return arr[n-1] + (k-(arr[n-1]-n));
        }

        int start=0;
        int end=n-1;

        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            if((arr[mid]-mid-1)<k){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return arr[ans] + (k-(arr[ans]-ans-1));
    }
}
