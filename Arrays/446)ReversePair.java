Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].
 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
 

Constraints:

1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    public int merge(int arr[], int l, int m, int r)
    {
        int count=0;
        int j=m+1;
        for(int i=l;i<=m;i++){
            while(j<=r && arr[i] > 2 * (long)arr[j]){
                j++;
            }
            count+=(j-(m+1));
        }

        int left[]=new int[m-l+1];
        int right[]=new int[r-m];
        
        j=0;
        int i=0,k=l;
        
        for(int x=l;x<=m;x++)
            left[i++]=arr[x];
        for(int x=m+1;x<=r;x++)
            right[j++]=arr[x];
            
        i=0;j=0;
        
        while(i<left.length && j<right.length){
            if(left[i]<=right[j])
                arr[k++]=left[i++];
            else
                arr[k++]=right[j++];
        }
        
        while(i<left.length)
            arr[k++]=left[i++];
        
        while(j<right.length)
            arr[k++]=right[j++];
        return count;
    }
    int mergeSort(int arr[], int l, int r)
    {
        int rp=0;
        if(l<r){
            int mid=l+(r-l)/2;
            rp+=mergeSort(arr,l,mid);
            rp+=mergeSort(arr,mid+1,r);
            rp+=merge(arr,l,mid,r);
        }
        return rp;
    }
}
[ 6,13,21,25]  [1,2,3,5,7,9]
 if i is at 6(0th index of first arr) and j is at 3(2nd index of second array) then ->
6 is not greater than 3×2 but later elements are ..
so we will miss out to count the pairs that are valid with 3 ...
if we go with count inversion method
