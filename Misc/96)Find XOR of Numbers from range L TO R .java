Find XOR of Numbers from range L TO R                                                                       
Find the XOR of the numbers from the range l to r, including l and r in O(n) time complexity
Example 1:
Input: l=4, r=7
Output: 0

Example 2:
Input: l=6, r=6
Output: 6

Example 1:
Input: l=1, r=7
Output: 0

Example 1:
Input: l=2, r=3
Output: 1

public static int leftToRightRange(int l,int r)
	{
		if(l==0) return NRange(r);
		else return (NRange(r)^NRange(l-1));
	}
	public static int NRange(int n)
	{
		if(n%4==0) return n;
		else if(n%4==1) return 1;
		else if(n%4==2) return n+1;
		else return 0;
		
	}
Edge case: when left is 0.
Tip: (XOR(1 to R))  XOR  ( XOR(1 to L-1))
Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)
