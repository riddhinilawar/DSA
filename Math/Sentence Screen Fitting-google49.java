418. Sentence Screen Fitting
Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given sentence can be fitted on the screen.

Note:

A word cannot be split into two lines.
The order of words in the sentence must remain unchanged.
Two consecutive words in a line must be separated by a single space.
Total words in the sentence won't exceed 100.
Length of each word is greater than 0 and won't exceed 10.
1 ≤ rows, cols ≤ 20,000.
Example 1:

Input:
rows = 2, cols = 8, sentence = ["hello", "world"]

Output:
1

Explanation:
hello---
world---

The character '-' signifies an empty space on the screen.
Example 2:

Input:
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

Output:
2

Explanation:
a-bcd-
e-a---
bcd-e-

The character '-' signifies an empty space on the screen.
Example 3:

Input:
rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

Output:
1

Explanation:
I-had
apple
pie-I
had--

The character '-' signifies an empty space on the screen.

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int n=4;
        int m=5;
        String arr[]={"I", "had", "apple", "pie"};
        System.out.println(getMaxFits(arr,n,m));
    }
    public static int getMaxFits(String[] arr,int n,int m){
        
        //keep 1 for I, 5 for had, 11 for apple, and 15 for pie in map
        TreeSet<Integer> map = new TreeSet<>();
        
        //pre calculate it
        int sum=0;
        for(String s:arr){
            sum+=s.length();
            map.add(sum);
            sum++;
        }
        
        //to point at which location you are in string
        int ptr=0;
        //to keep ans count
        int ans=0;
        
        //row and col traversal
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                //get remaining spaces in the row
                int getAvailSpc=m-j;
                
                //poss will tell what values will get filled in available locations
                int poss=-1;
                
                try{
                    poss=map.floor(ptr+getAvailSpc);
                }
                catch(Exception e){
                    //gives null pointer exception
                    //break for changing row
                    break;
                }
                
                System.out.println(i+" "+j+" "+getAvailSpc+" "+poss+ " " +ptr);
                
                //getting floor value less than the ptr position which you had already traversed
                if(poss<=ptr){
                    //word gets completed in that row, so no space required in that row so increase ptr, because we are chaing the line why to lose the space 
                    ptr++;
                    break;
                }
                
                j+=(poss-ptr);
                ptr=poss;
                
                //word gets completed in that row, so no space required in that row so increase ptr, in other words, last word last character had completed on last index of row..so no need to condiser the space required for that index
                if(j>=m)ptr++;
                
                //if poss gives you the last value in map
                if(poss==map.last()){
                    if(j<=m-1){
                        j++;
                    }
                    ans++;
                    ptr=0;
                }
                
                j--;
                
            }
        }
        
        return ans;
    }
}
