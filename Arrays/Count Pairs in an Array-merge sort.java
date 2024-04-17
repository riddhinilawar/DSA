Count Pairs in an Array


Given an array arr of n integers, count all pairs (arr[i], arr[j]) in it such that i*arr[i] > j*arr[j] and 0 ≤ i < j < n.

Note: 0-based Indexing is followed.

Example 1:

Input :
n = 4
arr[] = {8, 4, 2, 1}
Output :
2
Explanation:
If we see the array after operations
[0*8, 1*4, 2*2, 3*1] => [0, 4, 4, 3]
Pairs which hold the condition i*arr[i] > j*arr[j] are (4,1) and (2,1), so in total 2 pairs are available.
Example 2:

Input :
n = 7
arr[] = {5, 0, 10, 2, 4, 1, 6}
Output:
5
Explanation :
Pairs which hold the condition i*arr[i] > j*arr[j] are (10,2), (10,4), (10,1), (2,1) and (4,1), so in total 5 pairs are there.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function countPairs() which takes the array arr[] and its size n as inputs and returns the required result.

Expected Time Complexity: O(n*log(n))
Expected Auxiliary Space: O(n*log(n))

Constraints:
1 ≤ n ≤ 104
0 ≤ arr[i] ≤ 104



class Solution {
    static int merging(int arr[], int low, int mid, int high){
        int i = low, j = mid + 1, count = 0, k = 0, n = high - low + 1;
        int temp[] = new int[n];
        
        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else {
                count += mid - i + 1;
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid)
            temp[k++] = arr[i++];
            
        while(j <= high)
            temp[k++] = arr[j++];
            
        for(i = 0, j = low; i < n; i++, j++)
            arr[j] = temp[i];
            
        return count;
    }
    static int mergeSort(int arr[], int low, int high) {
        int count = 0;
        if(low < high) {
            int mid = low + (high - low) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += merging(arr, low, mid, high);
        } 
        return count;
    }
    static int countPairs(int arr[] , int n ) {
        for(int i = 0; i < n; i++)
            arr[i] *= i;
        return mergeSort(arr, 0, n - 1);
    }
}
