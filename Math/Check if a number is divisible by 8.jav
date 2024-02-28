Check if a number is divisible by 8


Given a string representation of a decimal number s, check whether it is divisible by 8.

Example 1:

Input:
s = "16"
Output:
1
Explanation:
The given number is divisible by 8,
so the driver code prints 1 as the output.
Example 2:

Input:
s = "54141111648421214584416464555"
Output:
-1
Explanation:
Given Number is not divisible by 8, 
so the driver code prints -1 as the output.
Your Task:
You don't need to read input or print anything.Your task is to complete the function DivisibleByEight() which takes a string s as the input and returns 1 if the number is divisible by 8, else it returns -1.

Expected Time Complexity: O(1).
Expected Auxillary Space: O(1).

Constraints:
1 <= Number represented by the string s < 106



class Solution{
    int DivisibleByEight(String s){
        if(s.length() == 0) return -1;
        
        int num = 0;
        // If the string is too long we'll take only last 3 digits
        num = Integer.parseInt(s.substring(Math.max(0, s.length() - 3)));
        
        if(num % 8 == 0) return 1;
        
        return -1;
    }
}
=============================================================================================================================================================
Divisible By

 

--->1
Any integer (not a fraction) is divisible by 1


--->2
The last digit is even (0,2,4,6,8)

128  Yes

129  No

--->3
The sum of the digits is divisible by 3

381 (3+8+1=12, and 12÷3 = 4) Yes

217 (2+1+7=10, and 10÷3 = 3 1/3) No

This rule can be repeated when needed:

99996 (9+9+9+9+6 = 42, then 4+2=6) Yes

--->4
The last 2 digits are divisible by 4

1312 is (12÷4=3) Yes

7019 is not (19÷4=4 3/4) No

We can also subtract 20 as many times as we want before checking:

68: subtract 3 lots of 20 and we get 8 Yes

102: subtract 5 lots of 20 and we get 2 No

Another method is to halve the number twice and see if the result is still a whole number:

124/2 = 62, 62/2 = 31, and 31 is a whole number. Yes

30/2 = 15, 15/2 = 7.5 which is not a whole number. No

--->5
The last digit is 0 or 5

175  Yes

809  No

--->6
Is even and is divisible by 3 (it passes both the 2 rule and 3 rule above)

114 (it is even, and 1+1+4=6 and 6÷3 = 2) Yes

308 (it is even, but 3+0+8=11 and 11÷3 = 3 2/3) No

--->7
Double the last digit and subtract it from a number made by the other digits. The result must be divisible by 7. (We can apply this rule to that answer again)

672 (Double 2 is 4, 67−4=63, and 63÷7=9) Yes

105 (Double 5 is 10, 10−10=0, and 0 is divisible by 7) Yes

905 (Double 5 is 10, 90−10=80, and 80÷7=11 3/7) No

--->8
The last three digits are divisible by 8

109816 (816÷8=102) Yes

216302 (302÷8=37 3/4) No

A quick check is to halve three times and the result is still a whole number:

816/2 = 408, 408/2 = 204, 204/2 = 102 Yes

302/2 = 151, 151/2 = 75.5 No

--->9
The sum of the digits is divisible by 9

(Note: This rule can be repeated when needed)

1629 (1+6+2+9=18, and again, 1+8=9) Yes

2013 (2+0+1+3=6) No

--->10
The number ends in 0

220  Yes

221  No

--->11
Add and subtract digits in an alternating pattern (add digit, subtract next digit, add next digit, etc). Then check if that answer is divisible by 11.

1364 (+1−3+6−4 = 0) Yes

913 (+9−1+3 = 11) Yes

3729 (+3−7+2−9 = −11) Yes

987 (+9−8+7 = 8) No

--->12
The number is divisible by both 3 and 4 (it passes both the 3 rule and 4 rule above)

648
(By 3? 6+4+8=18 and 18÷3=6 Yes)
(By 4? 48÷4=12 Yes)
Both pass, so Yes

524
(By 3? 5+2+4=11, 11÷3= 3 2/3 No)
(Don't need to check by 4) No
