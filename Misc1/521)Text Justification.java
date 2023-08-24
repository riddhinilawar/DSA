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




lass Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n=words.length;
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int countWidth=0;
        int prev_idx=0;


        for(int i=0;i<n;i++){

            int width=words[i].length();
            width++;

            if(countWidth+width-1>maxWidth){
                //System.out.println("countWidth:"+countWidth);
                countWidth--;
                
                int addWidth=maxWidth-countWidth+(i-prev_idx-1);
                //System.out.println(addWidth);

                int individualWidth=0;
                int inidividualRem=0;

                if((i-prev_idx-1)!=0){
                    individualWidth=addWidth/(i-prev_idx-1);
                    inidividualRem=addWidth%(i-prev_idx-1);
                }
                
                //System.out.println(individualWidth+" "+inidividualRem);

                for(int j=prev_idx;j<i;j++){
                    sb.append(words[j]);

                    int temp=0;
                    if(i-1!=j)temp=individualWidth;

                    while(temp>0){
                        sb.append(" ");
                        temp--;
                    }
                    if(inidividualRem!=0){
                        sb.append(" ");
                        inidividualRem--;
                    }
                }
                
                if(i-prev_idx-1==0)inidividualRem=addWidth;
                while(inidividualRem>0){
                    sb.append(" ");
                    inidividualRem--;
                }
                
                ans.add(sb.toString());

                sb.delete(0,sb.length());

                countWidth=width;
                prev_idx=i;

            }
            else{
                countWidth+=width;
            }

            
        }
        

        //
        countWidth=0;
        for(int j=prev_idx;j<n;j++){
            sb.append(words[j]);
            countWidth+=words[j].length();

            if(countWidth<maxWidth)
                sb.append(" ");    

            countWidth++;        
        }
        while(sb.length()<maxWidth){
            sb.append(" ");
        }
        ans.add(sb.toString());

        return ans;
    }
}
