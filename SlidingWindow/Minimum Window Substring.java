76.Minimum Window Substring
class Solution {
    public String minWindow(String s, String t) {
        int freqt[]=new int[130];
        int freqs[]=new int[130];
        int totalDiffChar=0;
        for(char c:t.toCharArray()){
            if(freqt[c]==0)totalDiffChar++;
            freqt[c]++;
        }

        int start=0;
        int end=-1;
        int n=s.length();
        int ansStart=-1;
        int ansEnd=-1;
        int ansLen=Integer.MAX_VALUE;
        int diffChar=0;

        while(start<n){
            while(end+1<n && diffChar<totalDiffChar){
                freqs[s.charAt(end+1)]++;
                if(freqs[s.charAt(end+1)]==freqt[s.charAt(end+1)])diffChar++;
                //System.out.println(start+" "+end+" "+diffChar+" "+totalDiffChar+" "+freqs[s.charAt(end+1)]+" "+freqt[s.charAt(end+1)]);
                end++;
            }
            if(end<n && diffChar==totalDiffChar && ansLen>(end-start+1)){
                //System.out.println("In");
                ansLen=(end-start+1);
                ansStart=start;
                ansEnd=end;
            }
            freqs[s.charAt(start)]--;
            if(freqs[s.charAt(start)]<freqt[s.charAt(start)])diffChar--;
            start++;
        }
        //System.out.println(ansStart+" "+ansEnd);
        return (ansStart==-1)?"":s.substring(ansStart,ansEnd+1);
    }
}

Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?
