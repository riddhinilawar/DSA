Count Occurrences of anagrams, gfg                               LC-438                                  
Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.
Example 1:
Input:
txt = forxxorfxdofr
pat = for
Output: 3
Explanation: for, orf and ofr appears
in the txt, hence answer is 3.
Example 2:
Input:
txt = aabaabaa
pat = aaba
Output: 4
Explanation: aaba is present 4 times
in txt.
Your Task:
Complete the function search() which takes two strings pat, txt, as input parameters and returns an integer denoting the answer. You don't to print answer or take inputs.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(26) or O(256)
Constraints:
1 <= |pat| <= |txt| <= 105
Both string contains lowercase english letters.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


class Solution {

    int search(String pat, String txt) {
        
        int first_ptr=0,second_ptr=pat.length()-1;
        int arr[]=new int[26];
        int brr[]=new int[26];
        
        for(int i=0;i<pat.length();i++)
            brr[pat.charAt(i)-'a']++;
        
        for(int i=first_ptr;i<=second_ptr;i++)
            arr[txt.charAt(i)-'a']++;
        
        if(pat.length()==txt.length()){
            if(helper(arr,brr)==true)return 1;
            else return 0;
        }
        
        int ans=0;
        
       if(helper(arr,brr)==true)ans++;
        
        for(int i=first_ptr, j=second_ptr+1;j<txt.length();j++,i++)
        {
             arr[txt.charAt(i)-'a']--;
             arr[txt.charAt(j)-'a']++;
             if(helper(arr,brr)==true)ans++;
        }
        
        return ans;
    }
    boolean helper(int arr[], int brr[]) 
    {
        for(int i=0;i<26;i++)
        {
            if(arr[i]!=brr[i])return false;
        }
        return true;
    }
}

