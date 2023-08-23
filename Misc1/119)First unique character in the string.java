First unique character in the string                                LC-387
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 
Example 1:
Input: s = "leetcode"
Output: 0
Example 2:
Input: s = "loveleetcode"
Output: 2
Example 3:
Input: s = "aabb"
Output: -1
 
Constraints:
•	1 <= s.length <= 105
•	s consists of only lowercase English letters.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
class Solution {
    public int firstUniqChar(String s) {

    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
    for (char c : s.toCharArray()) 
        map.put(c, map.getOrDefault(c, 0) + 1);   

    char ans=' ';
    for (char ch : map.keySet()) 
        if(map.get(ch)==1)
        {
            ans=ch;
            break;
        }

    if(ans==' ')return -1;
    else 
    {
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)==ans)return i;
    }
    return -1;
    }
}
