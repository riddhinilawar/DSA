class Solution {
    int median(int[][] matrix, int R, int C) {
        int total = (R * C);
        int tar = total / 2;
        int l = 1, u = 2000, mid = (l + u) / 2;
        int ans = -1;
        while (l <= u) {
            int count = 0;
            for (int[] row : matrix) {
                count += getCountOfLTEElements(row, mid);
            }
            if (count > tar) {
                u = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
            mid = (l + u) / 2;
        }
        return ans;
    }

    int getCountOfLTEElements(int[] arr, int ele) {
        int l = 0, u = arr.length - 1, mid = (l + u) / 2;
        while (l <= u) {
            if (arr[mid] <= ele) {
                l = mid + 1;
            } else {
                u = mid - 1;
            }
            mid = (l + u) / 2;
        }
        return l;
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
