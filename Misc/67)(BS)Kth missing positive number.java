Kth missing positive number                                           LC-1539
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
•	1 <= arr.length <= 1000
•	1 <= arr[i] <= 1000
•	1 <= k <= 1000
•	arr[i] < arr[j] for 1 <= i < j <= arr.length
Follow up: Could you solve this problem in less than O(n) complexity?
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)


class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int n=arr.length;
        if(k<arr[0]){
            return k;
        }
        else if(k> (arr[n-1] -n)){
            return arr[n-1] + k - (arr[n-1] -n);
        }
        else
        {
            int start=0,end=n-1;
            int mid=0;
            int pos=0;
            while(start<=end)
            {
                mid=start+(end-start)/2;

                if((arr[mid]-(mid+1))<k)
                {
                    pos=mid;
                    start=mid+1;
                }
                else
                {
                    end=mid-1;
                }
            }
            //System.out.println(pos);
            return arr[pos]+k-(arr[pos]-(pos+1));
            
            
        }
    }
}
