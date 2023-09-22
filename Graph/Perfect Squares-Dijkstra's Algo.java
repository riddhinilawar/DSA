279. Perfect Squares

Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 

Constraints:

1 <= n <= 104

class Solution {
    public int numSquares(int n) {
        
        int[] squares = new int[100];
        int steps[]=new int[10000];
        Arrays.fill(steps,Integer.MAX_VALUE);

        for(int i=1;i<=100;i++){
            squares[i-1]=i*i;
        }

        Queue<Integer> queue = new LinkedList<>();

        int step=0;

        queue.add(0);

        while(!queue.isEmpty()){
            step++;
            int size=queue.size();
            for(int s=0;s<size;s++){

                int temp=queue.remove();

                for(int i=0;i<100;i++){
                    if((squares[i]+temp) == n){
                        return step;
                    }
                    if((squares[i]+temp) < n && steps[squares[i]+temp]>step){
                        steps[squares[i]+temp]=step;
                        queue.add(squares[i]+temp);
                    }
                }

            }
        }
        return -1;
    }
}
