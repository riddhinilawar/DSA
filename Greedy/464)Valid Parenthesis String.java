Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
 

Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'.

class Solution {
    public boolean checkValidString(String s) {
        int openMax = 0;
        int openMin = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openMin++;
                openMax++;
            } else if (c == ')') {
                openMin--;
                openMax--;
            }
            else{
                openMin--;
                openMax++;
            }
            if (openMax < 0) return false; 
            if (openMin < 0) openMin=0;
        }
        return openMin==0;
    }
}
