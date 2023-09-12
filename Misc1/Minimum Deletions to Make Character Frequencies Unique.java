1647. Minimum Deletions to Make Character Frequencies Unique

A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.

 

Example 1:

Input: s = "aab"
Output: 0
Explanation: s is already good.
Example 2:

Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
Example 3:

Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 

Constraints:

1 <= s.length <= 105
s contains only lowercase English letters.

class Solution {
    public int minDeletions(String s) {
        int freq[]=new int[26];

        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }

        HashSet<Integer> set = new HashSet<>();
        int ans=0;

        for(int i=0;i<26;i++){
    
            if(set.contains(freq[i])){
                int temp=freq[i];
                while(set.contains(temp)){
                    temp--;
                }
    
                if(temp==0){
                    ans+=(freq[i]-temp);
                }
                else{
                    set.add(temp);
                    ans+=(freq[i]-temp);
                }
            }
            else if(freq[i]!=0){
                set.add(freq[i]);
            }
        }

        return ans;
    }
}
