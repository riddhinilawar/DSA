Program to generate Pascal’s Triangle    LC-118/119
Intuition: When you see the image above, you get a pretty good idea of what you are supposed to do here. Think about the image as a matrix now where each line is basically a row in the matrix. So, first things first, if you are at the edge of the matrix, the value is 1, that’s for sure. Now, what about the inner elements? Well, any inner element is obtained by doing the sum of the 2 values present in the row just above it, i.e., if the element is at index (i, j), then matrix[i][j] can be obtained by doing matrix[i – 1][j – 1] + matrix[i – 1][j].
Approach: To solve the problem, we need to first create an array of size N or numRows (input value). This array is used to store each of the rows expected in the output, so, for example, array[1] = [1,1]. In this array, the number of columns (say, numCols) is equal to the number of the i-th row + 1 (Since, 0-indexed), i.e., for 0-th row, numCols = 1. So, the number of columns is different for each row.
Next, we need to run a loop from i = 0 to numRows – 1 (inclusive) in order to store each row in our array. For each of iteration of this loop, we follow the below steps:
•	Create an array of size (i + 1) (For some languages such as C++, you need to create a 2D array at the start of the program and resize array[i] to (i + 1)).
•	Set the first and last value of array[i] to 1.
•	Run another loop from j = 1 to i – 1 (inclusive) and for each iteration put array[i][j] = array[i – 1][j – 1] + array[i – 1][j].
After iterating numRows times, you return the array.
Dry Run: Let’s do a dry run to understand it in a much better way.
Input: numRows = 5
•	Step – I: Initialized an array of size numRows, array = [[],[],[],[],[]]
•	Step – II: Run a loop from i = 0 to numRows – 1
•	At i = 0:
•	We resize the first row of the array to (i + 1) = (0 + 1) = 1, so array = [[0],[],[],[],[]].
•	Set the first and last value of array[i] = 1, so, array[0][0] = 1 and array[0][i] = 1. Therefore, array = [[1],[],[],[],[]]
•	Since, i = 0, the nested for loop does not satisfy the running criteria and hence does not get executed.
•	At i = 1:
•	We resize the second row of the array to (i + 1) = (1 + 1) = 2, so array = [[1],[0,0],[],[],[]].
•	Set the first and last value of array[i] = 1, so, array[1][0] = 1 and array[1][i] = 1. Therefore, array = [[1],[1,1],[],[],[]]
•	Since, i = 1, the nested for loop does not satisfy the running criteria and hence does not get executed.
•	At i = 2:
•	We resize the third row of the array to (i + 1) = (2 + 1) = 3, so array = [[1],[1,1],[0,0,0],[],[]].
•	Set the first and last value of array[i] = 1, so, array[2][0] = 1 and array[2][i] = 1. Therefore, array = [[1],[1,1],[1,0,1],[],[]]
•	Run a loop from j = 1 to i – 1:
•	At j = 1:
•	array[i][j] = array[i – 1][j – 1] + array[i – 1][j]
   = array[1][0] + array[1][1] = 1 + 1 = 2
So, array = [[1],[1,1],[1,2,1],[],[]]
•	At i = 3 and i = 4, we follow the same approach to fill the two rows of the array and get array = [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]].
•	Step – III: Return array.

Pascal’s Triangle – Striver, LC-118
Example 1:
Input Format: N = 5

Result:
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1

Explanation: There are 5 rows in the output matrix. Each row corresponds to each one of the rows in the image shown above.
Example 2:
Input Format: N = 1

Result: 
    1
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> row, pre = null;
		for (int i = 0; i < numRows; ++i) {
			row = new ArrayList<Integer>();
			for (int j = 0; j <= i; ++j)
				if (j == 0 || j == i)
					row.add(1);
				else
					row.add(pre.get(j - 1) + pre.get(j));
			pre = row;
			res.add(row);
		}
		return res;
    }
}
Note (gfg): 
public static ArrayList<Long> nthRowOfPascalTriangle(int n) {
		int numRows=n;
        if(numRows==0)
        {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Long>> res = new ArrayList<>();
        
        for(int i=1;i<=numRows;i++)
        {
            ArrayList<Long> row = new ArrayList<>();
            for(int j=0;j<i;j++)
            {
                if(j==0 || j==i-1) //first and last element of every row is always 1
                {
                     row.add((long)1);
                }
                else
                {
                    // adding jth and j-1th element of previous row
                    long num = (res.get(i-2).get(j)+res.get(i-2).get(j-1))%1000000007;
                    row.add(num);
                }
            }
            res.add(row);
        }
        return res.get(numRows-1);
    }
Time Complexity: We are creating a 2D array of size (numRows * numCols) (where 1 <= numCols <= numRows), and we are traversing through each of the cells to update it with its correct value, so Time Complexity = O(numRows2).
Space Complexity: Since we are creating a 2D array, space complexity = O(numRows2).

Pascal’s Triangle –  LC-119
 optimize  algorithm to use only O(rowIndex) extra space
Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:
Input: rowIndex = 0
Output: [1]
Example 3:
Input: rowIndex = 1
Output: [1,1]

public List<Integer> getRow(int n) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans=new ArrayList<Integer>();
        if(n==0)
        {
            ans.add(1);
            return ans;
        }
        if(n==1)
        {
            ans.add(1);
            ans.add(1);
            return ans;
        }
        else
        {
            List<Integer> prev=new ArrayList<Integer>();
            prev.add(1);prev.add(1);
            
            for(int i=3;i<n+2;i++)
            {
                ans=new ArrayList<Integer>();
                for(int j=0;j<i;j++)
                {
                    if(j==0||j==i-1)
                    {
                        ans.add(1);
                    }
                    else
                    {
                        ans.add(prev.get(j-1)+prev.get(j));
                    }
                }
                prev=ans;
            }
        }
        return ans;
    }
    
