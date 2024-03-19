Minimum Characters required to make a String Palindromic


Given a string A. The only operation allowed is to insert characters at the beginning of the string.
Find how many minimum characters are needed to be inserted to make the string a palindrome string.


Problem Constraints
1 <= |A| <= 106


Input Format
The only argument given is string A.


Output Format
Return the minimum characters that are needed to be inserted to make the string a palindrome string.


Example Input
Input 1:
A = "ABC"
Input 2:
A = "AACECAAAA"


Example Output
Output 1:
2
Output 2:
2


Example Explanation
Explanation 1:
Insert 'B' at beginning, string becomes: "BABC".
Insert 'C' at beginning, string becomes: "CBABC".
Explanation 2:
Insert 'A' at beginning, string becomes: "AAACECAAAA".
Insert 'A' at beginning, string becomes: "AAAACECAAAA".
public class Solution {
    public int solve(String A) {
        int len = A.length();
        String reverse = new StringBuffer(A).reverse().toString();
        A = A+"$"+reverse;
        return len - KMP(A);
    }
    public static int KMP(String s){
        int m =s.length();
        int lps[] = new int[m];
        int i=1,len=0;lps[0]=0;
        while(i<m){
            if(s.charAt(i)==s.charAt(len)){
                len++;lps[i]=len;i++;
            }
            else{
                if(len!=0){
                    len = lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps[m-1];
    }
}

