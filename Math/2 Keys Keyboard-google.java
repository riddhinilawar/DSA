650. 2 Keys Keyboard

There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:

Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.

 

Example 1:

Input: n = 3
Output: 3
Explanation: Initially, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
Example 2:

Input: n = 1
Output: 0
 

Constraints:

1 <= n <= 1000

class Solution {
    public int minSteps(int n) {
        if(n==1)return 0;
        int operations=0;

        while(true){
            
            for(int i=2;i<=(n/2);i++){
                if(n%i==0){
                    n=n/i;
                    operations+=(i);
                    //System.out.println(n+" "+operations+" "+i);
                    i=2;
                }
            }
            return operations+n;
        }

    }
}

/**
The time complexity of the provided minSteps method can be analyzed as follows:


The while loop iterates until n becomes 1, and within this loop:
The inner loop runs for each factorization of n, and it iterates up to n/2 which is approximately O(n) times in the worst case.
Inside this loop, the division operation n = n / i and addition operation operations += i are both constant time operations.
The loop might terminate earlier if n becomes 1.
Thus, the overall time complexity of the minSteps method is O(n), which simplifies to O(n).
 */
===============================================================================


 class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        int min = n;
        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                min = Math.min(min, n / i + minSteps(i));
            }
        }
        return min;
    }
}

TC:O(n!)roughly..as it won't goes in all the i
