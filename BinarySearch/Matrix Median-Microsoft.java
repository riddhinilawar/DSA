class Solution {
    int median(int[][] matrix, int R, int C) {
        int total = (R * C);
        int target = total / 2; //position of median element//
        int left = 1, right = 2000;
        
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


Given a row wise sorted matrix of size R*C where R and C are always odd, find the median of the matrix.

Example 1:

Input:
R = 3, C = 3
M = [[1, 3, 5], 
     [2, 6, 9], 
     [3, 6, 9]]
Output: 5
Explanation: Sorting matrix elements gives 
us {1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
 

Example 2:

Input:
R = 3, C = 1
M = [[1], [2], [3]]
Output: 2
Explanation: Sorting matrix elements gives 
us {1,2,3}. Hence, 2 is median.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function median() which takes the integers R and C along with the 2D matrix as input parameters and returns the median of the matrix.

Expected Time Complexity: O(32 * R * log(C))
Expected Auxiliary Space: O(1)


Constraints:
1 <= R, C <= 400
1 <= matrix[i][j] <= 2000
