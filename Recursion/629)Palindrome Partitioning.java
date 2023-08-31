131. Palindrome Partitioning


Given a string s, partition s such that every substring of the partition is a palindrome. 
Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.


class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans =new ArrayList<>();
        getPartition(s,0,new ArrayList<>(),ans);
        return ans;
    }
    public void getPartition(String S, int curr,List<String> temp,List<List<String>> ans){
        if(curr==S.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=curr;i<S.length();i++){
            if(isPalindrome(S,curr,i)==true){
                temp.add(S.substring(curr,i+1));
                getPartition(S,i+1,temp,ans);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalindrome(String S,int start,int end){
        while(start<end){
            if(S.charAt(start++)!=S.charAt(end--))
                return false;
        }
        return true;
    }
}



Time Complexity: O( (2^n) *k*(n/2) )

Reason: O(2^n) to generate every substring and O(n/2)  to check if the substring generated is a palindrome. O(k) is for inserting the palindromes in another data structure, where k  is the average length of the palindrome list.

Space Complexity: O(k * x)

Reason: The space complexity can vary depending upon the length of the answer. k is the average length of the list of palindromes and if we have x such list of palindromes in our final answer. The depth of the recursion tree is n, so the auxiliary space required is equal to the O(n).
