282. Expression Add Operators
Hard
Topics
Companies
Hint
Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

Note that operands in the returned expressions should not contain leading zeros.

 

Example 1:

Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]
Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
Example 3:

Input: num = "3456237490", target = 9191
Output: []
Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.
 

Constraints:

1 <= num.length <= 10
num consists of only digits.
-231 <= target <= 231 - 1

C++/Java/Python] Backtracking & Evaluate on the fly - Clean & Concise

hiepit
100 Days Badge 2022
50609
16901
Apr 10, 2020
✔️ Approach 1: Backtracking & Evaluate Expression

We use backtracking to generate all possible expressions by adding +, -, * to between the digits of s string.
Then write a function evaluate(string expression) to evaluate a string expression, if the evaluated result is equal to target, we add that expression string to our answer.
Click to see the implementation!


✔️ Approach 2: Backtracking & Evaluate on the fly (Best Solution)

We use backtracking to generate all possible expressions by adding +, -, * to between the digits of s string.
There is no priority since there are no parentheses ( and ) in our s string, so we can evaluate the expression on the fly to save time.
There are total 3 operators:
+ operator: newResult = resSoFar + num
- operator: newResult = resSoFar - num.
* operator: We need to keep the prevNum so that to calculate newResult we need to minus prevNum then plus with prevNum * num. So newResult = resSoFar - prevNum + prevNum * num.


class Solution {
    List<String> ans = new ArrayList<>();
    String s;
    int target;
    public List<String> addOperators(String s, int target) {
        this.s = s;
        this.target = target;
        backtrack( 0, "", 0, 0);
        return ans;
    }
    void backtrack(int i, String path, long resSoFar, long prevNum) {
        if (i == s.length()) {
            if (resSoFar == target) ans.add(path);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (j > i && s.charAt(i) == '0') break; // Skip leading zero number
            long num = Long.parseLong(s.substring(i, j + 1));
            if (i == 0) {
                backtrack(j + 1, path + num, num, num); // First num, pick it without adding any operator!
            } else {
                backtrack(j + 1, path + "+" + num, resSoFar + num, num);
                backtrack(j + 1, path + "-" + num, resSoFar - num, -num);
                backtrack(j + 1, path + "*" + num, resSoFar - prevNum + prevNum * num, prevNum * num); // Can imagine with example: 1-2*3
            }
        }
    }
}
