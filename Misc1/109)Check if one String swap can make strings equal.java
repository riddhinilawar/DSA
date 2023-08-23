Check if one String swap can make strings equal     LC-1790
You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.
Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.
 
Example 1:
Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".
Example 2:
Input: s1 = "attack", s2 = "defend"
Output: false
Explanation: It is impossible to make them equal with one string swap.
Example 3:
Input: s1 = "kelb", s2 = "kelb"
Output: true
Explanation: The two strings are already equal, so no string swap operation is required.
 
Constraints:
•	1 <= s1.length, s2.length <= 100
•	s1.length == s2.length
•	s1 and s2 consist of only lowercase English letters.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        ArrayList<Character> a1 = new ArrayList<Character>();
        ArrayList<Character> a2 = new ArrayList<Character>();

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                a1.add(s1.charAt(i));
                a2.add(s2.charAt(i));
            }
        }

        if(a1.size() == a2.size() && a1.size() == 0)
            return true;
        else if(a1.size() == a2.size() && a1.size() == 2){
            if(a1.get(0) == a2.get(1) && a1.get(1) == a2.get(0))
                return true;
            else
                return false;
        }
        else
            return false;


    }
}
