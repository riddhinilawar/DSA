A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
Return the index of the celebrity, if there is no celebrity return -1.
Note: Follow 0 based indexing.
Follow Up: Can you optimize it to O(N)
 

Example 1:

Input:
N = 3
M[][] = {{0 1 0},
         {0 0 0}, 
         {0 1 0}}
Output: 1
Explanation: 0th and 2nd person both
know 1. Therefore, 1 is the celebrity. 

Example 2:

Input:
N = 2
M[][] = {{0 1},
         {1 0}}
Output: -1
Explanation: The two people at the party both
know each other. None of them is a celebrity.

Your Task:
You don't need to read input or print anything. Complete the function celebrity() which takes the matrix M and its size N as input parameters and returns the index of the celebrity. If no such celebrity is present, return -1.


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	int iknows[]=new int[n];
    	int jknownto[]=new int[n];
    	
    	for(int i=0;i<n;i++){
    	    for(int j=0;j<n;j++){
    	        
    	        if(M[i][j]==1){
    	            iknows[i]++;
    	            jknownto[j]++;
    	        }
    	        
    	    }
    	}
    	
    	for(int i=0;i<n;i++){
    	    if(iknows[i]==0 && jknownto[i]==n-1)
    	        return i;
    	}
    	
    	return -1;
    }
}
