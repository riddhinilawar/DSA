Given two strings, one is a text string, txt and other is a pattern string, pat. The task is to print the indexes of all the occurences of pattern string in the text string. Use one-based indexing while returing the indices. 
Note: Return an empty list incase of no occurences of pattern. Driver will print -1 in this case.

Example 1:

Input:
txt = "geeksforgeeks"
pat = "geek"
Output: 
1 9
Explanation: 
The string "geek" occurs twice in txt, one starts are index 1 and the other at index 9. 
Example 2:

Input: 
txt = "abesdu"
pat = "edu"
Output: 
-1
Explanation: 
There's not substring "edu" present in txt.
Your Task:
You don't need to read input or print anything. Your task is to complete the function search() which takes the string txt and the string pat as inputs and returns an array denoting the start indices (1-based) of substring pat in the string txt. 

Expected Time Complexity: O(|txt|).
Expected Auxiliary Space: O(|txt|).

Constraints:
1 ≤ |txt| ≤ 105
1 ≤ |pat| < |S|
Both the strings consists of lowercase English alphabets.


  class Solution{
      ArrayList<Integer> search(String pat, String txt){
        ArrayList<Integer> list = new ArrayList<>();
        int index = txt.indexOf(pat);
        while(index != -1){
            list.add(index+1);
            index=txt.indexOf(pat,index+1);
        }
        return list;
    }
}
Note: IndexOf(String, Int32, StringComparison) Reports the zero-based index of the first occurrence of the specified string in the current String object. 
==============================================================================================
https://www.youtube.com/watch?v=GTJr8OvyEVQ

class Solution{
    ArrayList<Integer> search(String pat, String txt){
        ArrayList<Integer> ans = new ArrayList<>();
        
        
        //getting the preprocessed values in dp
        int dp[]=new int[pat.length()];
        dp[0]=0;
        
        int i=0;
        for(int j=1;j<pat.length();j++){
            if(pat.charAt(i)==pat.charAt(j)){
                dp[j]=i+1;
                i++;
            }
            else{
                while(pat.charAt(i)!=pat.charAt(j)){
                    
                    if(i==0){
                        dp[j]=0;
                        break;
                    }
                    
                    i=dp[i-1];
                    
                    if(pat.charAt(i)==pat.charAt(j)){
                        dp[j]=i+1;
                        i++;
                        break;
                    }
                }
            }
        }
        // for(int num:dp){
        //     System.out.println(num);
        // }
        
        
        i=0;
        int j=0;
        
        while(i<txt.length()){
            if(txt.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }
            if(j==pat.length()){
                ans.add(i-j+1);
                j=dp[j-1];
            }
            else if(i<txt.length() && txt.charAt(i) != pat.charAt(j)){
                if(j!=0){
                    j=dp[j-1];
                }
                else{
                    i++;
                }
            }
        }
        
    return ans;
    }
}

