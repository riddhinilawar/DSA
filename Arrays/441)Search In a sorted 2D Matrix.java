Search In a sorted 2D Matrix,gfg               LC-74,240

Solution 1: Naive approach
Approach: We can traverse through every element that is present in the matrix and return true if we found any element in the matrix is equal to the target integer. If the traversal is finished we can directly return false as we did not find any element in the matrix to be equal to the target integer.
Time complexity: O(m*n)
Space complexity: O(1)

Solution 2: Better Approach 
Approach: Perform the binary search on each rows. And if found then return true else if the travels on each wow gets over then return false.
Time complexity: O(m*logn)
Space complexity: O(1)
Solution 3: [Efficient] – Binary search
Intuition: As it is clearly mentioned that the given matrix will be row-wise and column-wise sorted, we can see that the elements in the matrix will be in a monotonically increasing order. So we can apply binary search to search the matrix. Consider the 2D matrix as a 1D matrix having indices from 0 to (m*n)-1 and apply binary search. Below the available image is the visual representation of the indices of 3*4 matrix.
 
Approach: 
i) Initially have a low index as the first index of the considered 1D matrix(i.e: 0) and high index as the last index of the considered 1D matrix(i.e: (m*n)-1).
int low = 0;
int  high = (m*n)-1;
ii) Now apply binary search. Run a while loop with the condition low<=high. Get the middle index as (low+high)/2.We can get the element at middle index using matrix[middle/m][middle%m].
while(low<=high)
    int middle = (low+high)/2;
iii) If the element present at the middle index is greater than the target, then it is obvious that the target element will not exist beyond the middle index. So shrink the search space by updating the high index to middle-1. 
if(matrix[middle/m][middle%m]<target)
    high = middle-1;
iv) If the middle index element is lesser than the target, shrink the search space by updating the low index to middle+1.
if(matrix[middle/m][middle%m]>target)
    low = middle+1;
v) If the middle index element is equal to the target integer, return true.
if(matrix[middle/m][middle%m]==target)
    return true;
vi) Once the loop terminates we can directly return false as we did not find the target element.
Time complexity: O(log(m*n)) , Space complexity: O(1)

74. Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
•	Integers in each row are sorted from left to right.
•	The first integer of each row is greater than the last integer of the previous row.
Example 1:
 
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3 Output: true
Example 2:
 
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13 Output: false
Constraints:
•	m == matrix.length
•	n == matrix[i].length
•	1 <= m, n <= 100
•	-104 <= matrix[i][j], target <= 104
class Solution {
     public boolean searchMatrix(int[][] matrix, int target) {
        int lo = 0;
        if(matrix.length == 0) return false;
        int n = matrix.length; 
        int m = matrix[0].length; 
        int hi = (n * m) - 1;
        
        while(lo <= hi) {
            int mid = (lo + (hi - lo) / 2);
            if(matrix[mid/m][mid % m] == target) {
                return true;
            }
            if(matrix[mid/m][mid % m] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
240. Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
•	Integers in each row are sorted in ascending from left to right.
•	Integers in each column are sorted in ascending from top to bottom.
Example 1:
 
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:
 
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
Constraints:
•	m == matrix.length
•	n == matrix[i].length
•	1 <= n, m <= 300
•	-109 <= matrix[i][j] <= 109
•	All the integers in each row are sorted in ascending order.
•	All the integers in each column are sorted in ascending order.
•	-109 <= target <= 109
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
          try
        {
        int i=0;
        int j=matrix[0].length-1;
        while(true)
        {
        
            if(matrix[i][j]==target)return true;
            if(matrix[i][j]>target)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
    }
}
