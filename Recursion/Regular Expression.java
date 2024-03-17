class Solution {
    public boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[s.length() + 1][p.length() + 1];// dp array to skip 
        return helper(s, 0, p, 0, dp);// overlapping subproblems
    }

    public static boolean helper(String s, int i, String p, int j, Boolean dp[][]){
        if(i == s.length() && j == p.length()) return true;// if we have reached end of 
																		//both strings means both string matches return true
        if(j == p.length()) return false;// if j reached end of pattern, we cant compare more
        if(dp[i][j] != null) return dp[i][j];// if dp doesn't contains null means we already calculated
        boolean ans = false;// variable to store the answer
        boolean charMatch = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
// variable to pre compute is i not exceeding length is s or char at both string matches
// or pattern contains '.'
        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            
            ans = helper(s, i, p, j + 2, dp) || charMatch && helper(s, i + 1, p, j, dp);
        }// first Condition -> j + 2 because if character repeats 0 times then same string s
// and pattern should start from j + 2
// Or if character matches or in pattern character at j is * that means, Also charater matches
// so keep j at same position there maybe character repeats more than 0 times
// and then check from i + 1
        else ans = charMatch && helper(s, i + 1, p, j + 1, dp);
        return dp[i][j] = ans;
    }
}
