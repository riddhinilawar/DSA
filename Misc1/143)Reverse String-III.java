Reverse String-III                                                                    LC-557
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 
Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:
Input: s = "God Ding"
Output: "doG gniD"
 
Constraints:
•	1 <= s.length <= 5 * 104
•	s contains printable ASCII characters.
•	s does not contain any leading or trailing spaces.
•	There is at least one word in s.
•	All the words in s are separated by a single space.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
class Solution {
    public String reverseWords(String s) {
        
        String ans="";
        String curr="";
        boolean flag=true;
        
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)==' ')
            {
                if(ans=="") ans=curr;
                else ans=curr+" "+ans;
                curr="";
                flag=false;
            }
            else
            {
                curr+=s.charAt(i);
            }
        }
        ans=curr+" "+ans;
        if(flag==true)return curr;
        return ans;
    }
}
Edge case:
Input:"hehhhhhhe"
Output:"ehhhhhheh "
Expected:"ehhhhhheh"

