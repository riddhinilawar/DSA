84. Largest Rectangle in Histogram


Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104

class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int maxArea = 0;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        prevSmaller[0] = -1;
        nextSmaller[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int p = i - 1;

            while (p >= 0 && heights[p] >= heights[i]) {
                p = prevSmaller[p];
            }

            prevSmaller[i] = p;
        }

        for (int i = n - 1; i >= 0; i--) {
            int p = i + 1;

            while (p < n && heights[p] >= heights[i]) {
                p = nextSmaller[p];
            }

            nextSmaller[i] = p;
        }

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nextSmaller[i] - prevSmaller[i] - 1));
        }

        return maxArea;  
    }
}
