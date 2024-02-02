Implement Atoi

Given a string, s, the objective is to convert it into integer format without utilizing any built-in functions. If the conversion is not feasible, the function should return -1.

Note: Conversion is feasible only if all characters in the string are numeric or if its first character is '-' and rest are numeric.

Example 1:

Input:
s = "-123"
Output: 
-123
Explanation:
It is possible to convert -123 into an integer 
and is so returned in the form of an integer
Example 2:

Input:
s = "21a"
Output: 
-1
Explanation: 
The output is -1 as, due to the inclusion of 'a',
the given string cannot be converted to an integer.
Your Task:
You do not have to take any input or print anything. Complete the function atoi() which takes a string s as an input parameter and returns an integer value representing the given string. If the conversion is not feasible, the function should return -1.

|s| = length of string str.
Expected Time Complexity: O( |s| ), 
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |s| ≤ 10

class Solution
{
    int atoi(String s) {
        int counter=0;
        if(s.length()==1&& (s.charAt(0)<48||s.charAt(0)>57))return -1;

        int sign=0;
        int signcount=0;
        
        
        while(counter<s.length()&&(s.charAt(counter)=='+'||s.charAt(counter)=='-'))
        {
            if(s.charAt(counter)=='-')
                sign=-1;
             counter++;
             signcount++;
        }
        
        if(counter>=s.length())return -1;
        if(signcount>1)return -1;
        
        
        
        long ans=0;
       // System.out.println(counter); 
        
        for(int i=counter;i<s.length();i++)
        {
            
            ans=(ans*10)+Character.getNumericValue(s.charAt(i));
           // System.out.println(ans);
           if(s.charAt(i)<48||s.charAt(i)>57)return -1;
            
        }
       
            if(sign==-1)ans=-ans;
        
        
        return (int)ans;
    }
}
