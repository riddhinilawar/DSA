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
