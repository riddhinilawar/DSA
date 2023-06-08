Finding the missing and repeating number,gfgLC-645
Tip:- For storing the sum and square sum  use long datatype
Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.
Example 1:
Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and 
smallest positive missing number is 1.
Example 2:
Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and 
smallest positive missing number is 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findTwoElement() which takes the array of integers arr and n as parameters and returns an array of integers of size 2 denoting the answer ( The first index contains B and second index contains A.)
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ N

Solution 1: Using Count Sort
Intuition + Approach: 
Since the numbers are from 1 to N in the array arr[]
1.	Take a substitute array of size N+1 and initalize it with 0.
2.	Traverse the given array and increase the value of substitute[arr[i]] by one .
3.	Then again traverse the substitute array starting from index 1 to N.
If you find any index value greater than 1 that is repeating element A.
If you find any index value = 0 then that is the missing element B.
Dry Run: lets take the example of array[] = {3,1,2,5,3}
The size of the array is 5
We initialize a substitute array of size 6 with elements 0.
Now traversing through the array 
1.	Found 3 at 0 indexes, increase the value of substitute array at index 3 by 1.
2.	Found 1 at 1 index, increase the value of substitute array at index 1 by 1.
3.	Found 2 at 2 indexes, increase the value of substitute array at index 2 by 1.
4.	Found 5 at 3 indexes, increase the value of substitute array at index 5 by 1.
5.	Found 3 at 4 indexes, increase the value of substitute array at index 3 by 1.
Now Traversing through the substitute array 
At index 3, the value is greater than 1 i.e 2. So A = 3.
At index 4, the value is 0 so B = 4.
Time Complexity: O(N)
Space Complexity: O(N) As we are making new substitute array
Solution 2: Using Maths 
Intuition + Approach: 
The idea is to convert the given problem into mathematical equations. Since we have two variables where one is missing and one is repeating, can we form two linear equations and then solve for the values of these two variables using the equations?
Let’s see how.
Assume the missing number to be X and the repeating one to be Y.
Now since the numbers are from 1 to N in the array arr[]. Let’s calculate sum of all integers from 1 to N and sum of squares of all integers from 1 to N. These can easily be done using mathematical formulae.
Therefore,
Sum of all elements from 1 to N:
S = N*(N+1)/2 ---- equation 1
And, Sum of squares of all elements from 1 to N:
P = N(N+1)(2N+1)/6. ----- equation 2
Similarly, find the sum of all elements of the array and sum of squares of all elements of the array respectively.
s1 = Sum of all elements of the array. —– equation 3
P1 = Sum of squares of all elements of the array. ——– equation 4
Now, if we subtract the sum of all elements of array from sum of all elements from 1 to N, that should give us the value for (X – Y).
Therefore,
(X-Y) = s – s1 = s’
Similarily,
X^2 – Y^2 = P – P1 = P’
or, (X + Y)(X – Y) = P’
or, (X + Y)*s’ = P’
or, X + Y = P’/s’
Great,
we have the two equations we needed:
(X – Y) = s’
(X + Y) = P’/s’
We can use the two equations to solve and find values for X and Y respectively.
Note: here s and P can be large so take long long int data type.
Time Complexity: O(N) 
Space Complexity: O(1) As we are NOT USING EXTRA SPACE

Solution 3: XOR
Intuition + Approach: 
Let x and y be the desired output elements.
Calculate the XOR of all the array elements.
xor1 = arr[0]^arr[1]^arr[2]…..arr[n-1]
XOR the result with all numbers from 1 to n
xor1 = xor1^1^2^…..^n
xor1 will have the result as (x^y), as others would get canceled. Since we are doing XOR, we know xor of 1 and 0, is only 1, so all the set bits in xor1, mean that the index bit is only set at x or y.

So we can take any set bit, in code we have taken the rightmost set bit, iterate over it, and divide the numbers into two hypothetical buckets.

If we check for numbers with that particular index bit set, we will get a set of numbers that belongs to the first bucket, also we will get another set of numbers belonging to the second bucket. The first bucket will be containing either x or y, similarly, the second bucket will also be containing either x or y. XOR of all elements in the first bucket will give X or Y, and XOR of all elements of the second bucket will give either X or Y since there will be double instances of every number in each bucket except the X or Y.

We just need to iterate again to check which one is X, and which one is y. Can be simply checked by linear iterations. For a better understanding, you can check the video explanation.
Note: This method doesn’t cause overflow, but it doesn’t tell which one occurs twice and which one is missing. We can add one more step that checks which one is missing and which one is repeating by iterating over the array. This can be easily done in O(N) time.
Time Complexity: O(N) 
Space Complexity: O(1) As we are NOT USING EXTRA SPACE

Approach 2: 
class Solution {
    public void sortColors(int[] nums) {
        int lo = 0; 
        int hi = nums.length - 1; 
        int mid = 0; 
        int temp; 
        while (mid <= hi) { 
            switch (nums[mid]) { 
                case 0: { 
                    temp = nums[lo]; 
                    nums[lo] = nums[mid]; 
                    nums[mid] = temp; 
                    lo++; 
                    mid++; 
                    break; 
                } 
                case 1: 
                    mid++; 
                    break; 
                case 2: { 
                    temp = nums[mid]; 
                    nums[mid] = nums[hi]; 
                    nums[hi] = temp; 
                    hi--; 
                    break; 
                } 
            } 
        }
    }
}
