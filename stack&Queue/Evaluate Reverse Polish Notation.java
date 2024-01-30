150. Evaluate Reverse Polish Notation

You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 

Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].


class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){

            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){

                int second=stack.pop();
                int first=stack.pop();

                if(token.equals("+"))stack.push(first+second);
                else if(token.equals("-"))stack.push(first-second);
                else if(token.equals("*"))stack.push(first*second);
                else if(token.equals("/"))stack.push(first/second);

            }
            else{
                stack.push(Integer.parseInt(token));
            } 
        }
        return stack.pop();
    }
}
========================================================================================
class Solution {
    int pos;
    public int evalRPN(String[] tokens) {
        this.pos = tokens.length-1;
        return evaluate(tokens);
    }

    public int evaluate(String[] t){
        String token = t[pos];
        pos--;
        if(token.equals("+")){
            return evaluate(t) + evaluate(t); 
        }else
        if(token.equals("*")){
            return evaluate(t) * evaluate(t);
        }else 
        if(token.equals("-")){
            return -evaluate(t) + evaluate(t);
        }else
        if(token.equals("/")){
            int right = evaluate(t);
            return evaluate(t) / right;
        }else{
            return Integer.parseInt(token);
        }
    }
}
====================================================================================================
class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = 0;
        for(String s : tokens) {
            char c = s.charAt(0);
            if(c=='+') {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a+b;
            } else if(c=='-' && s.length()==1) {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a-b;
            } else if(c=='*') {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a*b;
            } else if(c=='/') {
                int b = stack[--top];
                int a = stack[--top];
                stack[top++] = a/b;
            } else 
                stack[top++] = Integer.parseInt(s);
        }
        return stack[0];
    }
}
