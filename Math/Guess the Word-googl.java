843. Guess the Word
Note: for any word lets say first word try the function get the matches count,
  check for others is the matches count condition satisfies..if yes..kepp..else remove..
  for all others repeat the same
You are given an array of unique strings words where words[i] is six letters long. One word of words was chosen as a secret word.

You are also given the helper object Master. You may call Master.guess(word) where word is a six-letter-long string, and it must be from words. Master.guess(word) returns:

-1 if word is not from words, or
an integer representing the number of exact matches (value and position) of your guess to the secret word.
There is a parameter allowedGuesses for each test case where allowedGuesses is the maximum number of times you can call Master.guess(word).

For each test case, you should call Master.guess with the secret word without exceeding the maximum number of allowed guesses. You will get:

"Either you took too many guesses, or you did not find the secret word." if you called Master.guess more than allowedGuesses times or if you did not call Master.guess with the secret word, or
"You guessed the secret word correctly." if you called Master.guess with the secret word with the number of calls to Master.guess less than or equal to allowedGuesses.
The test cases are generated such that you can guess the secret word with a reasonable strategy (other than using the bruteforce method).

 

Example 1:

Input: secret = "acckzz", words = ["acckzz","ccbazz","eiowzz","abcczz"], allowedGuesses = 10
Output: You guessed the secret word correctly.
Explanation:
master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
We made 5 calls to master.guess, and one of them was the secret, so we pass the test case.
Example 2:

Input: secret = "hamada", words = ["hamada","khaled"], allowedGuesses = 10
Output: You guessed the secret word correctly.
Explanation: Since there are two words, you can guess both.
 

Constraints:

1 <= words.length <= 100
words[i].length == 6
words[i] consist of lowercase English letters.
All the strings of wordlist are unique.
secret exists in words.
10 <= allowedGuesses <= 30


/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */

class Solution {
    
    // Method to count matching characters between two words
    public int matchWord(String w1, String w2) {
        int count = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) == w2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
    
    // Main method to find the secret word
    public void findSecretWord(String[] words, Master master) {
        int left = 0; // Left pointer
        int right = words.length - 1; // Right pointer
        
        // Loop until the secret word is found
        while (true) {
            // Get the count of matching characters for the first word
            int count = master.guess(words[0]);
            // If all characters match, the secret word is found, so return
            if (count == 6) {
                return;
            }
            
            int j = left + 1; // Start comparing from the word next to the left pointer
            
            // Iterate through the words between left and right pointers
            while (j < right) {
                // If the count of matching characters between the current word and the leftmost word
                // is not equal to the count obtained from the master's guess
                if (matchWord(words[left], words[j]) != count) {
                    // Replace the current word with the word at the right pointer
                    words[j] = words[right];
                    right--; // Decrement right pointer
                } else {
                    j++; // Move to the next word
                }
            }
            
            // Replace the leftmost word with the word at the right pointer
            words[0] = words[right--];
        }
    }
}
