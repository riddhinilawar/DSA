139. Word Break

Time Complexity: The time complexity of the above code will be O(2^n).
Auxiliary Space: The space complexity will be O(n) as we are using recursion and the recursive call stack will take O(n) space.

 
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






140. Word Break II

Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
 

Constraints:

1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
Input is generated in a way that the length of the answer doesn't exceed 105.



class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordDict.size();i++)
            set.add(wordDict.get(i));

        ArrayList<String> ans = new ArrayList<>();

        solve(0,s,set,ans,new ArrayList<String>());
        
        return ans;
    }
    public void solve(int start,String s, HashSet<String> set,ArrayList<String> ans,ArrayList<String> temp){
        if(start==s.length()){
            StringBuilder sb = new StringBuilder();
            for(String t:temp){
                sb.append(t);
                sb.append(" ");
            }
            ans.add(sb.toString().substring(0,sb.length()-1));
        }
        
        for(int end=start+1;end<=s.length();end++){
            if(set.contains(s.substring(start,end))==true){
                temp.add(s.substring(start,end));
                solve(end,s,set,ans,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}

However, considering the total number of substring operations performed over all recursive calls, the total time taken for substring operations can be approximated to O(n^2).

Combining these factors, the overall time complexity of the solve function is O(n^3), where n is the length of the input string s.

Since the wordBreak function calls the solve function once, its time complexity is also O(n^3), where n is the length of the input string s.
===================================================================================================================
Google | Onsite | Word Break III


 Given a sentence without spaces s and a dictionary dict, you have to find the way to break the sentence in the minimum number of individual dictionary words. If there're multiple solutions, return any of them.

Example 1:

Input: s = "bedbathandbeyand", dict = ["bed", "bath", "bat", "and", "hand", "bey", "beyand"]
Output: ["bed", "bath", "and", "beyand"] or ["bed", "bat", "hand", "beyand"]
Example 2:

Input: s = "catsandog", dict = ["cats", "dog", "sand", "and", "cat"]
Output: []
 
