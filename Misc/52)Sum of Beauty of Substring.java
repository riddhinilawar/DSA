Sum of Beauty of Substring                                            LC-1718
The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
•	For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings.
 
Example 1:
Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
Example 2:
Input: s = "aabcbaa"
Output: 17
 
Constraints:
•	1 <= s.length <= 500
•	s consists of only lowercase English letters.
Expected Time Complexity: O(nsquare)
Expected Auxiliary Space: O(1)
class Solution {
    public int beautySum(String s) {

        int res=0;

        for(int i=0;i<s.length();i++){
            int arr[] = new int[26];
            for(int j=i; j <s.length();j++){
                arr[s.charAt(j)-'a']++;
                res+=beauty(arr);
            }
        }

        return res;
    }

    public int beauty(int arr[])
    {
        int min=Integer.MAX_VALUE;
        int max=-1;
        for(int i=0;i<arr.length;i++)
        {
            max=Math.max(max,arr[i]);
            if( arr[i]>0 && arr[i]<min) min = arr[i];
        }
        return max-min;
    }
}
