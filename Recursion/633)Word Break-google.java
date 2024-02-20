139. Word Break
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordDict.size();i++)
            set.add(wordDict.get(i));
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return (solve(0,s,set,dp)==1?true:false);
    }
    public int solve(int curr,String s, HashSet<String> set,int dp[]){
        if(s.length()==curr)
            return 1;

        if(dp[curr]!=-1)
            return dp[curr];

        for(int i=curr;i<s.length();i++){
            if(set.contains(s.substring(curr,i+1))==true){
                if(solve(i+1,s,set,dp)==1)
                    return dp[curr]=1;
            }
        }

        return dp[curr]=0;
    }
}


===========================================normal recursion===============================

 class Solution{
    public static int wordBreak(String s, ArrayList<String> dictionary ){
        
        HashSet<String> set = new HashSet<>();
        for(String word:dictionary){
            set.add(word);
        }
        
        return helper(0,s.length(),s,set);
    }
    public static int helper(int start,int n,String s,HashSet<String> set){
        if(start==n){
            return 1;
        }
        
        for(int end=start+1;end<=n;end++){
            if(set.contains(s.substring(start,end))){
                int temp=helper(end,n,s,set);
                if(temp==1)return 1;
            }
        }
        
        return 0;
    }
}


======================================memoization=================================

 class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordDict.size();i++)
            set.add(wordDict.get(i));
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return (solve(0,s,set,dp)==1?true:false);
    }
    public int solve(int start,String s, HashSet<String> set,int dp[]){
        if(start==s.length())
            return 1;

        if(dp[start]!=-1)
            return dp[start];

        for(int end=start+1;end<=s.length();end++){
            if(set.contains(s.substring(start,end))==true){
                if(solve(end,s,set,dp)==1)
                    return dp[start]=1;
            }
        }

        return dp[start]=0;
    }
}
