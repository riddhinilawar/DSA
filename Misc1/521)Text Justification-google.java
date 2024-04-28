68. Text Justification


Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
 

Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.
Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 

Constraints:

1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth




class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int wordCount = words.length;
        List<String> justifiedLines = new ArrayList<>();
        StringBuilder lineBuilder = new StringBuilder();
        int lineWidth = 0;//current line width
        int prevIndex = 0;//prevIndex until words were inserted

        for (int i = 0; i < wordCount; i++) {
            int wordWidth = words[i].length();
            wordWidth++;

            if (lineWidth + wordWidth - 1 > maxWidth) {
                lineWidth--;

                int extraSpaceWidth = maxWidth - lineWidth + (i - prevIndex - 1); 

                int individualSpaceWidth = 0;
                int remainingSpace = 0;

                //get how much spaces present inbetween words,not handeling for last word
                if ((i - prevIndex - 1) != 0) {
                    individualSpaceWidth = extraSpaceWidth / (i - prevIndex - 1);
                    remainingSpace = extraSpaceWidth % (i - prevIndex - 1);
                }

                //inserting the words with space
                for (int j = prevIndex; j < i; j++) {
                    lineBuilder.append(words[j]);

                    //after last index one should not put space
                    int tempSpace = 0;
                    if (i - 1 != j) tempSpace = individualSpaceWidth;

                    while (tempSpace > 0) {
                        lineBuilder.append(" ");
                        tempSpace--;
                    }
                    if (remainingSpace != 0) {
                        lineBuilder.append(" ");
                        remainingSpace--;
                    }
                }

                //in case of one word only, word length is 15 and line length is 17 then insert 2 extra spaces
                if (i - prevIndex - 1 == 0) remainingSpace = extraSpaceWidth;
                while (remainingSpace > 0) {
                    lineBuilder.append(" ");
                    remainingSpace--;
                }

                justifiedLines.add(lineBuilder.toString());

                lineBuilder.delete(0, lineBuilder.length());

                //assigning the remaining to the next line.
                lineWidth = wordWidth;
                prevIndex = i;
            } else {
                lineWidth += wordWidth;
            }
        }
        //repeating the same thing for last line.
        lineWidth = 0;
        for (int j = prevIndex; j < wordCount; j++) {
            lineBuilder.append(words[j]);
            lineWidth += words[j].length();

            if (lineWidth < maxWidth)
                lineBuilder.append(" ");

            lineWidth++;
        }
        while (lineBuilder.length() < maxWidth) {
            lineBuilder.append(" ");
        }
        justifiedLines.add(lineBuilder.toString());

        return justifiedLines;
    }
}
