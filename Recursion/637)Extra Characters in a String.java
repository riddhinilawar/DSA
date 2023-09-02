2707. Extra Characters in a String


You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.

Return the minimum number of extra characters left over if you break up s optimally.

 

Example 1:

Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
Output: 1
Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.

Example 2:

Input: s = "sayhelloworld", dictionary = ["hello","world"]
Output: 3
Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.
 

Constraints:

1 <= s.length <= 50
1 <= dictionary.length <= 50
1 <= dictionary[i].length <= 50
dictionary[i] and s consists of only lowercase English letters
dictionary contains distinct words

Memoization:

class Solution {
    int ans;
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        for(String d:dictionary)
            set.add(d);
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(0,s,set,dp);
    }
    public int helper(int idx,String s,HashSet<String> set,int dp[]){
        if(idx==s.length()){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int temp=Integer.MAX_VALUE;
        for(int i=idx;i<s.length();i++){
            if(set.contains(s.substring(idx,i+1))){
                temp = Math.min(temp,0+helper(i+1,s,set,dp));
            }
            else{
                temp = Math.min( temp,i-idx+1+helper(i+1,s,set,dp));
            }
        }

        return dp[idx]=temp;
    }
    
}


==========================================================================================================

Recursive(Functional):

class Solution {
    int ans;
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        for(String d:dictionary)
            set.add(d);
        return helper(0,s,set);
    }
    public int helper(int idx,String s,HashSet<String> set){
        if(idx==s.length()){
            return 0;
        }

        int temp=Integer.MAX_VALUE;
        for(int i=idx;i<s.length();i++){
            if(set.contains(s.substring(idx,i+1))){
                temp = Math.min(temp,0+helper(i+1,s,set));
            }
            else{
                temp = Math.min( temp,i-idx+1+helper(i+1,s,set));
            }
        }

        return temp;
    }
    
}

=================================================================================================

Recursive (parameterized):

class Solution {
    int ans;
    public int minExtraChar(String s, String[] dictionary) {
        ans=Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        for(String d:dictionary)
            set.add(d);
        helper(0,s,set,0);
        return ans;
    }
    public void helper(int idx,String s,HashSet<String> set, int absent){
        if(idx==s.length()){
            ans=Math.min(ans,absent);
            return;
        }

        for(int i=idx;i<s.length();i++){
            if(set.contains(s.substring(idx,i+1))){
                helper(i+1,s,set,absent);
            }
            else{
                helper(i+1,s,set,absent+i-idx+1);
            }
        }
    }
    
}
