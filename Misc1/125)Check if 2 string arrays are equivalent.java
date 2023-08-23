Check if 2 string arrays are equivalent             LC-1662
Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
A string is represented by an array if the array elements concatenated in order forms the string.
 
Example 1:
Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.
Example 2:
Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false
Example 3:
Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true
 
Constraints:
•	1 <= word1.length, word2.length <= 103
•	1 <= word1[i].length, word2[i].length <= 103
•	1 <= sum(word1[i].length), sum(word2[i].length) <= 103
•	word1[i] and word2[i] consist of lowercase letters.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1="";
        String s2="";
        
        if(word1.length<word2.length) return arrayStringsAreEqual(word2 , word1);
        
        int max= word1.length;
        
        for(int i=0,j=0;i<max;i++,j++)
        {
            s1+=word1[i];
            
            if(j<word2.length)
            s2+=word2[j];
        }
        
        if(s1.equals(s2)==true)return true;
        else return false;
    }
}
