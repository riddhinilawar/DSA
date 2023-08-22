Find XOR of Numbers from range 1 TO N                                                                       
Find the XOR of the numbers from 1 to n in O(n) time complexity
Example 1:
Input: n=4
Output: 4

Example 2:
Input: n=0
Output: 0

Example 1:
Input: n=7
Output: 0

Example 1:
Input: n=6
Output: 7

public static int NRange(int n)
	{
		if(n%4==0) return n;
		else if(n%4==1) return 1;
		else if(n%4==2) return n+1;
		else return 0;
		
	}
 
Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)
