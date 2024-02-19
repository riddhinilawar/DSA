441. Arranging Coins
Solved
Easy
Topics
Companies
You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

 

Example 1:


Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.
Example 2:


Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.


  class Solution {
    public int arrangeCoins(int n) {
    int start=1;
	int end=n;
	int ans=-1;
	
	while(start<=end){
		int mid=start+(end-start)/2;
		
		long coinsReqToFill = (long)((long)mid*((long)mid+1l))/2l;

		if(coinsReqToFill<=n){
			ans=mid;
			start=mid+1;
		}
		else{
			end=mid-1;
		}	
	}	

	return ans;
    }
}
 

Constraints:

1 <= n <= 231 - 1
