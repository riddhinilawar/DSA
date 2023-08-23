Valid Anagram                                                                          LC-242
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
Example 2:
Input: s = "rat", t = "car"
Output: false
 
Constraints:
•	1 <= s.length, t.length <= 5 * 104
•	s and t consist of lowercase English letters.
 
Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)
class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length())return false;
        
        char[] S=s.toCharArray();
        char[] T=t.toCharArray();
        
        Arrays.sort(S);
        Arrays.sort(T);
        

        for(int i=0;i<s.length();i++)
        {
            if(S[i]!=T[i])
                return false;
        }
        
        return true;
    }
}











Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
class Solution {
    public boolean isAnagram(String s, String t) {
        int arr[]=new int[26];
        int brr[]=new int[26];
        
        if(s.length()!=t.length())return false;
        
        for(int i=0;i<s.length();i++)
        {
            arr[s.charAt(i)-'a']++;
            brr[t.charAt(i)-'a']++;           
        }
        
        for(int i=0;i<26;i++)
        {
           if(arr[i]!=brr[i])return false;          
        }
        return true;
    }
}
