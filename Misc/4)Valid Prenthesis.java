LC 20-Valid Prenthesis
class Solution {
    public boolean isValid(String s) {
        Stack<Character> S=new Stack<Character>();
        if(s.length()==1)return false;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='(')
            {
                S.push(s.charAt(i));
            }
            else
            {
                if(S.isEmpty()==true)
                {
                    return false;
                }
                else 
                {
                if(s.charAt(i)=='}'&&S.peek()=='{')
                {
                    S.pop();
                }
                else if(s.charAt(i)==')'&&S.peek()=='(')
                {
                    S.pop();
                }
                else if(s.charAt(i)==']'&&S.peek()=='[')
                {
                    S.pop();
                }
                else
                {
                    S.push(s.charAt(i));
                }
                }
            }
        }
        if(S.isEmpty()==true)return true;
        else return false;
    }
}
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
1.	Open brackets must be closed by the same type of brackets.
2.	Open brackets must be closed in the correct order.
3.	Every close bracket has a corresponding open bracket of the same type.
 
Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{}"
Output: true
Example 3:
Input: s = "(]"
Output: false
 
Constraints:
•	1 <= s.length <= 104
•	s consists of parentheses only '()[]{}'.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
Note: Exceptions
] – only 1 chracter can not form parenthesis
( ] ) - ] should be pushed in the stack if [ is not found
){ -can not compate 0 with the peek element because stack is empty

class Solution {
    public boolean isValid(String s) {
        Stack<Character> S=new Stack<Character>();
        if(s.length()%2==1)return false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='('){
                S.push(s.charAt(i));
            }
            else{
                if(S.isEmpty()==true){
                    return false;
                }
                else if(s.charAt(i)=='}'&&S.peek()=='{'){
                    S.pop();
                }
                else if(s.charAt(i)==')'&&S.peek()=='('){
                    S.pop();
                }
                else if(s.charAt(i)==']'&&S.peek()=='['){
                    S.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(S.isEmpty()==true)return true;
        else return false;
    }
}
