Number of common factors                                         LC-2427
Given two positive integers a and b, return the number of common factors of a and b.
An integer x is a common factor of a and b if x divides both a and b.
 
Example 1:
Input: a = 12, b = 6
Output: 4
Explanation: The common factors of 12 and 6 are 1, 2, 3, 6.
Example 2:
Input: a = 25, b = 30
Output: 2
Explanation: The common factors of 25 and 30 are 1, 5.
 
Constraints:
•	1 <= a, b <= 1000
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
class Solution {
    public int commonFactors(int a, int b) {
        int max=Math.max(a,b);
        max=max/2;
        int ans=0;
        for(int i=1;i<=max;i++)
            if(a%i==0 && b%i==0)ans++;

        if(a==b)return ans+1;
        return ans;
    }
}


================================================================

import java.util.stream.*;

class Solution {
    public int commonFactors(int a, int b) {
        return (int)Stream.iterate(1, n -> n + 1)
            .limit(Math.min(a, b))
            .filter(n -> a % n == 0 && b % n == 0)
            .count();
    }
}
