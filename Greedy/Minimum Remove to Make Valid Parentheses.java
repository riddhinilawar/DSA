
1249. Minimum Remove to Make Valid Parentheses

Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 

Constraints:

1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.

class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr=s.toCharArray();

        int i=0;
        while(i<s.length()){
            if(arr[i]=='(')break;
            if(arr[i]==')')arr[i]=':';
            i++;
        }

        i=s.length()-1;
        while(i>=0){
            if(arr[i]==')')break;
            if(arr[i]=='(')arr[i]=':';
            i--;
        }

        i=0;
        int temp=0;
        int open=0;
        int close=0;

        while(i<s.length()){
            if(arr[i]=='(')open++;
            if(arr[i]==')')close++;
            if(close>open){
                open=close=0;
                arr[i]=':';
            }
            i++;
        }
        
        open=0;
        close=0;
        i=s.length()-1;

        while(i>=0){
            if(arr[i]=='(')open++;
            if(arr[i]==')')close++;
            if(close<open){
                open=close=0;
                arr[i]=':';
            }
            i--;
        }

        return helper(arr);
    }
    public String helper(char arr[]){
        String ans="";
        for(char c:arr){
            if(c!=':')ans+=c;
        }

        return ans;
    }
}
