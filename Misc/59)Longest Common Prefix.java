Longest Common Prefix- gfg                                           LC-14
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
 
Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 
Constraints:
•	1 <= strs.length <= 200
•	0 <= strs[i].length <= 200
•	strs[i] consists of only lowercase English letters.•	
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
class Solution {
    public String longestCommonPrefix(String[] arr) {
        Arrays.sort(arr);
        String ans="";
        
        int minlen=arr[0].length()>arr[arr.length-1].length()?arr[arr.length-1].length():arr[0].length();
        
        for(int i=0;i<minlen;i++)
        {
            if(arr[0].charAt(i)!=arr[arr.length-1].charAt(i))
            {
                if(i==0)return "";
                break;
            }
            else
                ans=ans+arr[0].charAt(i);
        }
        
        return ans;
    }
}
