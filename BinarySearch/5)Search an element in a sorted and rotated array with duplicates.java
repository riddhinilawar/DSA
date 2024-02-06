Given an array arr[] which is sorted and rotated, the task is to find an element in the rotated array (with duplicates) in O(log n) time. 
Note: Print the index where the key exists. In case of multiple answer print any of them

Examples: 

Input: arr[] = {3, 3, 3, 1, 2, 3}, key = 3 
Output: 0 
arr[0] = 3

Input: arr[] = {3, 3, 3, 1, 2, 3}, key = 11 
Output: -1 
11 is not present in the given array. 

class Solution{
    int search(int A[], int low, int high, int key){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(A[mid]==key){
                return mid;
            }
            if(A[low]==A[mid] && A[mid]==A[high]){
                low++;
                high--;
                continue;
            }
            else if(A[low]<=A[mid]){
                if(A[low]<=key && A[mid]>=key){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(A[mid]<=key && A[high]>=key){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
