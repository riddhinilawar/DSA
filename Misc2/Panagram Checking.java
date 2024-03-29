Panagram Checking

  Given a string s check if it is "Panagram" or not.

A "Panagram" is a sentence containing every letter in the English Alphabet.

Example 1:

Input:
s = "Bawds jog, flick quartz, vex nymph"
Output: 
1
Explanation: 
In the given input, there
are all the letters of the English
alphabet. Hence, the output is 1.
Example 2:

Input:
s = "sdfs"
Output: 
0
Explanation: 
In the given input, there
aren't all the letters present in the
English alphabet. Hence, the output
is 0.
Your Task:
You do not have to take any input or print anything. You need to complete the function checkPangram() that takes a string as a parameter and returns true if the string is a Panagram, or else it returns false.

Expected Time Complexity: O( |s| )
Expected Auxiliary Space: O(1)
|s| denotes the length of the input string.

Constraints:
1 ≤ |s| ≤ 104
Both Uppercase & Lowercase are considerable

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String sentence) {
        if(sentence.length()<26)return false;
        
        int arr[]=new int[26];
        int count=0;
        for(int i=0;i<sentence.length();i++)
        {
            if((sentence.charAt(i)>='A' && sentence.charAt(i)<='Z')||((sentence.charAt(i)>='a' && sentence.charAt(i)<='z')))
            {
            
            char c=sentence.charAt(i);
            if(c>='A' && c<='Z')c=(char)((int)c+32);
            if(arr[c-'a']==0)
            {
                count++;
                arr[c-'a']=1;
            }
            }
        }
        if(count==26)return true;
        else return false;
    }
}
