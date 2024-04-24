424. Longest Repeating Character Replacement

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length


==========================================================
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int mostFreqLetter = 0;
        char mostFreqChar='-';
        int left = 0;
        int max = 0;
        
        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;

            //get the frequency of most frequent character//
            if(mostFreqChar=='-' || freq[mostFreqChar-'A'] < freq[s.charAt(right) - 'A']){
                mostFreqChar=s.charAt(right);
            }
             
            int lettersToChange = (right - left + 1) - freq[mostFreqChar-'A'];
            if(lettersToChange > k){

                //shrink window//
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            
            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
}



===========================================================
Intution:

The question asks to find the longest substring that contains the same characters. It also says that we can change k characters to make a substring longer and valid.

Ex:

"ABAB" k = 1
Here we know that we can change 1 character to make a substring that is a valid answer
AKA: a substring with all the same characters.

So a valid substring answer would be s.substring(0, 3) -> "ABA" because with can replace 1 character.

Another answer could be "BAB".

Using the sliding window technique, we set up pointers left = 0 and right = 0
We know that a our current window / substring is valid when the number of characters that need to be replaced is <= k.

Lets take the example below to understand it better:
Ex:

"AABABCC" k = 2
left = 0
right = 4 inclusive
This is example above shows a valid substring window because we have enough k changes to change the B's to A's and match the rest of the string.

"AABAB" with 2 changes is valid

We will need to know how many letters in our substring that we need to replace.
To find out the lettersToReplace = (end - start + 1) - mostFreqLetter;
Pretty much you take the size of the window minus the most freq letter that is in the current window.

Now that we know how many characters that need to be replaced in our window, we can deduce that if lettersToReplace > k than the window is invalid and we decrease the window size from the left.


