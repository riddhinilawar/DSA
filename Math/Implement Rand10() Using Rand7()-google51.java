470. Implement Rand10() Using Rand7()

Given the API rand7() that generates a uniform random integer in the range [1, 7], write a function rand10() that generates a uniform random integer in the range [1, 10]. You can only call the API rand7(), and you shouldn't call any other API. Please do not use a language's built-in random API.

Each test case will have one internal argument n, the number of times that your implemented function rand10() will be called while testing. Note that this is not an argument passed to rand10().

 

Example 1:

Input: n = 1
Output: [2]
Example 2:

Input: n = 2
Output: [2,8]
Example 3:

Input: n = 3
Output: [3,8,10]
 

Constraints:

1 <= n <= 105
 

Follow up:

What is the expected value for the number of calls to rand7() function?
Could you minimize the number of calls to rand7()?

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
 /*
rand7() will get random 1 ~ 7
(rand7() - 1) * 7 + rand7() - 1 will get random 0 ~ 48
We discard 40 ~ 48, now we have rand40 equals to random 0 ~ 39.
We just need to return rand40 % 10 + 1 and we get random 1 ~ 10.

In 9/49 cases, we need to start over again.
In 40/49 cases, we call rand7() two times.

Overall, we need 49/40*2 = 2.45 calls of rand7() per rand10().
 
 */
class Solution extends SolBase {
        public int rand10() {
        int rand40 = 40;
        while (rand40 >= 40) {
            //8 can be written 6 cann't be written in place of 7 for multiplication, reason min possible should be 0 only max possible can be any thing
            rand40 = (rand7() - 1) * 7 + rand7() - 1;
        }
        return rand40 % 10 + 1;
    }
}
