Roman to Integer- gfg                                                              LC-13
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
•	I can be placed before V (5) and X (10) to make 4 and 9. 
•	X can be placed before L (50) and C (100) to make 40 and 90. 
•	C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
 
Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 
Constraints:
•	1 <= s.length <= 15
•	s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
•	It is guaranteed that s is a valid roman numeral in the range [1, 3999].•	
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


class Solution {
    public int romanToInt(String s) {
        
        int n=s.length()-1;
        int i=s.length()-1;
        int ans=0;

        while(i>=0 && s.charAt(i)=='I')
        {
            ans=ans+1;
            i--;
        }

        if(i>=0&&(i-1)>=0&&s.charAt(i)=='V'&&s.charAt(i-1)=='I')
        {
            ans=ans+4;
            i--;
            i--;
        }

        while(i>=0&&s.charAt(i)=='V')
        {
            ans=ans+5;
            i--;
        }

        if(i>=0&&(i-1)>=0&&s.charAt(i)=='X'&&s.charAt(i-1)=='I')
        {
            ans=ans+9;
            i--;
            i--;
        }

        while(i>=0&&s.charAt(i)=='X')
        {
            ans=ans+10;
            i--;
        }

        if(i>=0&&(i-1)>=0&&s.charAt(i)=='L'&&s.charAt(i-1)=='X')
        {
            ans=ans+40;
            i--;
            i--;
        }

        while(i>=0&&s.charAt(i)=='L')
        {
            ans=ans+50;
            i--;
        }

        if(i>=0&&(i-1)>=0&&s.charAt(i)=='C'&&s.charAt(i-1)=='X')
        {
            ans=ans+90;
            i--;
            i--;
        }

        while(i>=0&&s.charAt(i)=='C')
        {
            ans=ans+100;
            i--;
        }

        if(i>=0&&(i-1)>=0&&s.charAt(i)=='D'&&s.charAt(i-1)=='C')
        {
            ans=ans+400;
            i--;
            i--;
        }

        while(i>=0&&s.charAt(i)=='D')
        {
            ans=ans+500;
            i--;
        }

        if(i>=0&&(i-1)>=0&&s.charAt(i)=='M'&&s.charAt(i-1)=='C')
        {
            ans=ans+900;
            i--;
            i--;
        }

        while(i>=0&&s.charAt(i)=='M')
        {
            ans=ans+1000;
            i--;
        }

       return ans;
    }
}


