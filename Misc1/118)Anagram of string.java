Anagram of string, gfg          
Given two strings S1 and S2 in lowercase, the task is to make them anagram. The only allowed operation is to remove a character from any string. Find the minimum number of characters to be deleted to make both the strings anagram. Two strings are called anagram of each other if one of them can be converted into another by rearranging its letters.
Example 1:
Input:
S1 = bcadeh
S2 = hea
Output: 3
Explanation: We need to remove b, c
and d from S1.
Example 2:
Input:
S1 = cddgk
S2 = gcd
Output: 2
Explanation: We need to remove d and
k from S1.
Your Task:
Complete the function remAnagram() which takes two strings S1, S2 as input parameter, and returns minimum characters needs to be deleted.
Expected Time Complexity: O(max(|S1|, |S2|)), where |S| = length of string S.
Expected Auxiliary Space: O(26)
Constraints:
1 <= |S1|, |S2| <= 105
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
class GfG
{
       public int remAnagrams(String s1,String s2)
       {
        if(s1.length()<s2.length()) return remAnagrams(s2,s1);
        
        int arr1[]=new int[26];
        int arr2[]=new int[26];
        
        for(int i=0;i<s1.length();i++)
            arr1[s1.charAt(i)-'a']++;
    
        for(int i=0;i<s2.length();i++)
            arr2[s2.charAt(i)-'a']++;
        
        int ans=0;    
            
        for(int i=0;i<26;i++)
        {
            ans+=(Math.abs(arr1[i]-arr2[i]));
        }
        
        return ans;
    }
}
