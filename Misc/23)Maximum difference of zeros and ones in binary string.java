Maximum difference of zeros and ones in binary string, gfg
class Solution {
    int maxSubstring(String S) {
        int MaxSum = -1;
        int sum=0;
        
        for(int i=0; i<S.length(); i++)
        {
            int val = 0;
            if(S.charAt(i) == '0') val = 1;
            else val = -1;
            sum+=val;
            if(sum<0)
            sum=0;
            else 
            MaxSum=Math.max(MaxSum,sum);
        }
        return MaxSum;
    }

}
Kadanes algo application
Given a binary string S consisting of 0s and 1s. The task is to find the maximum difference of the number of 0s and the number of 1s (number of 0s – number of 1s) in the substrings of a string.
Note: In the case of all 1s, the answer will be -1.
Example 1:
Input : S = "11000010001" 
Output : 6 
Explanatio: From index 2 to index 9, 
there are 7 0s and 1 1s, so number 
of 0s - number of 1s is 6. 
Example 2:
Input: S = "111111"
Output: -1
Explanation: S contains 1s only 

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)
