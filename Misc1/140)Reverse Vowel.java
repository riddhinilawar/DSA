Reverse Vowel                                                                         LC-345
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 
Example 1:
Input: s = "hello"
Output: "holle"
Example 2:
Input: s = "leetcode"
Output: "leotcede"
 
Constraints:
•	1 <= s.length <= 3 * 105
•	s consist of printable ASCII characters.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
class Solution {
    public String reverseVowels(String s) {
        
        char arr[]=s.toCharArray();
        
        String vwls = "aeiouAEIOU";
        
        for (int l = 0, r = s.length() - 1; l < r; ++l, --r) 
        {
            while (l < r && vwls.indexOf(arr[l]) < 0) ++l;
            while (l < r && vwls.indexOf(arr[r]) < 0) --r;
            
            char c=arr[l];
            arr[l]=arr[r];
            arr[r]=c;
        }
        
        return String.valueOf(arr);
    }
}
