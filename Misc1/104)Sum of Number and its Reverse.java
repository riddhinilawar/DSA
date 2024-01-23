Sum of Number and its Reverse                                      LC-2443
Given a non-negative integer num, return true if num can be expressed as the sum of any non-negative integer and its reverse, or false otherwise.
 
Example 1:
Input: num = 443
Output: true
Explanation: 172 + 271 = 443 so we return true.
Example 2:
Input: num = 63
Output: false
Explanation: 63 cannot be expressed as the sum of a non-negative integer and its reverse so we return false.
Example 3:
Input: num = 181
Output: true
Explanation: 140 + 041 = 181 so we return true. Note that when a number is reversed, there may be leading zeros.
 
Constraints:
•	0 <= num <= 105
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i=0;i<=num;i++)
            if(i+rev(i)==num)return true;
        return false;
    }
    public int rev(int n){
        int temp=0;
        while(n>0){
            temp = temp*10 + n%10;
            n/=10;
        }
        return temp;
    }
}
==================================================================================
 class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        //a,a => 2a
        if(num<=18) {
            if(num%2==0) {
                return true;
            }
        }
        //a,a=>2a
        
        //ab, ba => 11(a+b)
        if(num>=11) {
            if(num%11==0 && num/11<=18) {
             //   System.out.println(num);
                return true;
            }
        }
        //abc, cba => 101(a+c) + 20b
        if(num>=101) {
            for(int i=1;i<=18;i++) {
                int tmp = num-101*i;
                if(tmp<0) break;
                if(tmp%20==0&& tmp/20<=9) {
               //     System.out.println(i+" "+tmp);
                    return true;
                }
            }
        }
        //abcd, dcba => 1001(a+d)+110(b+c)
        if(num>=1001) {
            for(int i=1;i<=18;i++) {
                int tmp = num-1001*i;
                if(tmp<0) break;
                if(tmp%110==0&& tmp/110<=18) {
                   // System.out.println(i+"  "+tmp);
                    return true;
                }
            }            
        }
        
        //abcde, edcba => 10001(a+e)+ 1010(b+d) +200c
        if(num>=10001) {
            for(int i=1;i<=18;i++) {
                for(int j=0;j<=18;j++) {
                    int tmp = num-10001*i-1010*j;
                    if(tmp<0) break;
                    if(tmp%200==0&& tmp/200<=9) {
                       //   System.out.println(i+" "+j+" "+tmp);
                        return true;
                    }
                }
            }              
        }
        return false;
    }
}
