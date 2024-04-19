Note:: Same as matrix median problem..

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int R=matrix.length;
        int C=matrix[0].length;
        int total = (R * C); //total element//
        int target = k-1; //position of element to be find//
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;//get max and min range of answer//
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                left=Math.min(left,matrix[i][j]);
                right=Math.max(right,matrix[i][j]);
            }
        }
        
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int count = 0;
            for (int[] row : matrix) {
                count += getCountOfLTEElements(row, mid);//to get the elemets less than or equal to mid//
            }
            
            if (count > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    int getCountOfLTEElements(int[] arr, int ele) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            
            int mid = (left + right) / 2;
            
            if (arr[mid] <= ele) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        return left;
    }
}


378. Kth Smallest Element in a Sorted Matrix

Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
 

Follow up:

Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may find reading this paper fun.
