227. Basic Calculator II

Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.


class Solution {
    public int calculate(String s) {
        Stack <Integer> stack=new Stack<>();
        int flag=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ')continue;
            if(Character.isDigit(s.charAt(i))){
                int val=0;
                while(i<s.length()&&Character.isDigit(s.charAt(i))){
                    val=(val*10)+(s.charAt(i)-'0');
                    i++;
                }
                i--;

                if(flag==1){
                    int temp=stack.pop();
                    stack.push(temp*val);
                }
                else if(flag==2){
                    int temp=stack.pop();
                    stack.push(temp/val);
                }
                else
                    stack.push(val);
            }
            else{
                if(s.charAt(i)=='*') flag=1;
                else if(s.charAt(i)=='/') flag=2;
                else if(s.charAt(i)=='-'){
                    stack.push(-1);
                    flag=0;
                }
                else {
                    stack.push(1);
                    flag=0;
                }
            }
        }
        //System.out.println(stack);

        int ans=0;
        while(!stack.isEmpty()){
            int num=stack.pop();
            int sign=0;
            if(!stack.isEmpty()) 
                sign=stack.pop();
            if(sign==-1)ans-=num;
            else ans+=num;
        }

        return ans;
    }
}
