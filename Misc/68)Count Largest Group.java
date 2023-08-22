Count Largest Group                                                         LC-1399
You are given an integer n.
Each number from 1 to n is grouped according to the sum of its digits.
Return the number of groups that have the largest size.
 
Example 1:
Input: n = 13
Output: 4
Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
[1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
There are 4 groups with largest size.
Example 2:
Input: n = 2
Output: 2
Explanation: There are 2 groups [1], [2] of size 1.
 
Constraints:
•	1 <= n <= 104
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
class Solution {
    public int countLargestGroup(int n) {
        
        int arr[]= new int[37];
        int max=0;

        for(int i=1;i<=n;i++)
        {
            arr[count(i)]++;
            if(arr[count(i)] > max)max= arr[count(i)];
        }

        int ans=0;
        for(int i=1;i<arr.length;i++)
            if(max==arr[i])ans++;

        return ans;
    }
    public int count(int n) {
        int c=0;
        while(n>0)
        {
            c+=n%10;
            n=n/10;
        }
        return c;
    }
}
