// "static void main" must be defined in a public class..
//https://svalaks.medium.com/leetcode-642-design-search-autocomplete-system-69dd16758b36
/*

Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#').

You are given a string array sentences and an integer array times both of length n where sentences[i] is a previously typed sentence and times[i] is the corresponding number of times the sentence was typed. For each input character except '#', return the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed.

Here are the specific rules:

The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same hot degree, use ASCII-code order (smaller one appears first).
If less than 3 hot sentences exist, return as many as you can.
When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
Implement the AutocompleteSystem class:

AutocompleteSystem(String[] sentences, int[] times) Initializes the object with the sentences and times arrays.
List<String> input(char c) This indicates that the user typed the character c.
Returns an empty array [] if c == '#' and stores the inputted sentence in the system.
Returns the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed. If there are fewer than 3 matches, return them all.
Example 1:

Input
["AutocompleteSystem", "input", "input", "input", "input"]
[[["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]], ["i"], [" "], ["a"], ["#"]]
Output
[null, ["i love you", "island", "i love leetcode"], ["i love you", "i love leetcode"], [], []]
Explanation
AutocompleteSystem obj = new AutocompleteSystem(["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]);
obj.input("i"); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
obj.input(" "); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
obj.input("a"); // return []. There are no sentences that have prefix "i a".
obj.input("#"); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
Constraints:

n == sentences.length
n == times.length
1 <= n <= 100
1 <= sentences[i].length <= 100
1 <= times[i] <= 50
c is a lowercase English letter, a hash '#', or space ' '.
Each tested sentence will be a sequence of characters c that end with the character '#'.
Each tested sentence will have a length in the range [1, 200].
The words in each input sentence are separated by single spaces.
At most 5000 calls will be made to input.

*/
// "static void main" must be defined in a public class..
//https://svalaks.medium.com/leetcode-642-design-search-autocomplete-system-69dd16758b36
/*

Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#').

You are given a string array sentences and an integer array times both of length n where sentences[i] is a previously typed sentence and times[i] is the corresponding number of times the sentence was typed. For each input character except '#', return the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed.

Here are the specific rules:

The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same hot degree, use ASCII-code order (smaller one appears first).
If less than 3 hot sentences exist, return as many as you can.
When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
Implement the AutocompleteSystem class:

AutocompleteSystem(String[] sentences, int[] times) Initializes the object with the sentences and times arrays.
List<String> input(char c) This indicates that the user typed the character c.
Returns an empty array [] if c == '#' and stores the inputted sentence in the system.
Returns the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed. If there are fewer than 3 matches, return them all.
Example 1:

Input
["AutocompleteSystem", "input", "input", "input", "input"]
[[["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]], ["i"], [" "], ["a"], ["#"]]
Output
[null, ["i love you", "island", "i love leetcode"], ["i love you", "i love leetcode"], [], []]
Explanation
AutocompleteSystem obj = new AutocompleteSystem(["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]);
obj.input("i"); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
obj.input(" "); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
obj.input("a"); // return []. There are no sentences that have prefix "i a".
obj.input("#"); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
Constraints:

n == sentences.length
n == times.length
1 <= n <= 100
1 <= sentences[i].length <= 100
1 <= times[i] <= 50
c is a lowercase English letter, a hash '#', or space ' '.
Each tested sentence will be a sequence of characters c that end with the character '#'.
Each tested sentence will have a length in the range [1, 200].
The words in each input sentence are separated by single spaces.
At most 5000 calls will be made to input.

*/
public class Main {

    public static void main(String[] args) {
        
        Trie obj = new Trie();
         String inputStr[]={"i love you", "island", "iroman", "i love leetcode"};
         int times[]={5, 3, 2, 2};
        
        //String inputStr[]={"c", "co", "cod", "code"};
        //int times[]={2,2,4,4};
        
        
        for(int i=0;i<inputStr.length;i++){
            String word=inputStr[i];
            obj.insert(word,times[i]);
        }
        //char[] charArr={ 'c', ' ', '#'};
        char[] charArr={ 'i', ' ','a' ,'#'};
        for(char c:charArr)
            System.out.println(c+" "+obj.query(c));
        
    }
}
class Trie{
    
    int sentencesIdx=1;
    //map sentences to index
    HashMap<String,Integer> allSentences= new HashMap<>();
    //index to sentence mapping
    HashMap<Integer,String> mapToSentense = new HashMap<>();
    //index to frequency mapping
    HashMap<Integer,Integer> mapToFrequency = new HashMap<>();
    
    
    Node root;
    Node temp;
    StringBuilder sb;
    boolean query;
    Trie(){
        query=true;
        root=new Node();
        temp=root;
        sb=new StringBuilder();
    }
    public void insert(String word,int time){
        if(allSentences.containsKey(word)==true){
                mapToFrequency.put(allSentences.get(word),mapToFrequency.get(allSentences.get(word))+1);
                insertNewWordOrUpdateOldWordFreq(word);
            }
            else{
                //System.out.println(word+" "+sentencesIdx);
                allSentences.put(word,sentencesIdx);
                mapToSentense.put(sentencesIdx,word);
                mapToFrequency.put(sentencesIdx,time);
                sentencesIdx++;
                insertNewWordOrUpdateOldWordFreq(word);
            }
    }
    
    public void insertNewWordOrUpdateOldWordFreq(String word){
        
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curr.contains(c)==false){
                curr.setNode(c);
            }
            curr=curr.getNode(c);
            
            //handle the frequencies
            int[] freq = curr.getMaxFeq();
            //System.out.println(word+"-- "+c+" -->"+freq[0]+" "+freq[1]+" "+freq[2]);
            manageFrequencies(word,freq);
            //System.out.println(word+"-- "+c+" -->"+freq[0]+" "+freq[1]+" "+freq[2]);
        }
        curr.setEnd();
    }
    
    public void manageFrequencies(String word,int[] freq){
        
        int currIdx=allSentences.get(word);
        int currFreq=mapToFrequency.get(currIdx);
        
        
        
        //if cuurentIndex already exist do nothing
        for(int i=0;i<3;i++){
            if(freq[i]==currIdx){
                return;
            }
        }
        
        //if slots are empty insert
        
        if(freq[0]==0){
            freq[0]=currIdx;
            Arrays.sort(freq);
            return;
        }
        
        //get the min frequency index and value
        int minFreqExist=100;
        int minFreqIdx=-1;
        for(int i=0;i<3;i++){
            if(minFreqExist>mapToFrequency.get(freq[i])){
                minFreqExist=mapToFrequency.get(freq[i]);
                minFreqIdx=i;
            }
        }
        //System.out.println(minFreqExist+" "+minFreqIdx);
        //if current freq is less than min freq available in array
        if(currFreq<minFreqExist){
            return;
        }
        
       
        //if current freq is same as min freq
        if(minFreqExist==currFreq){
            int removeIdx=minFreqIdx;
            String removeWord=mapToSentense.get(freq[minFreqIdx]);
            
            for(int i=0;i<3;i++){
                if(minFreqExist==mapToFrequency.get(freq[i])){
                    if(removeWord.compareTo(mapToSentense.get(freq[i]))>0){
                        removeWord=mapToSentense.get(freq[i]);
                        removeIdx=i;
                    }
                }
            }

            //check current word with 
            if(removeWord.compareTo(word)>0){
                freq[removeIdx]=currIdx;

            }
            return;
        }
        
        //if current freq is greater as min freq
        
        int removeIdx=minFreqIdx;
        String removeWord=mapToSentense.get(freq[minFreqIdx]);
        
        for(int i=0;i<3;i++){
            if(currFreq>mapToFrequency.get(freq[i])){
                if(mapToFrequency.get(freq[removeIdx]) >= mapToFrequency.get(freq[i]) ){
                    removeWord=mapToSentense.get(freq[i]);
                    removeIdx=i;
                }
                else if(mapToFrequency.get(freq[removeIdx]) == mapToFrequency.get(freq[i])     &&      (removeWord.compareTo(mapToSentense.get(freq[i]))>0)){
                    removeWord=mapToSentense.get(freq[i]);
                    removeIdx=i;
                }
            }
        }

        freq[removeIdx]=currIdx;
           

    }
    
    
    
    
        public ArrayList<String> query(char c){
            ArrayList<String> ans = new ArrayList<>();
            if(c=='#'){
                temp=root;
                
                String word=sb.toString();
                insert(word,1);
                query=true;
                sb.delete(0,sb.length());
            }
            
            else if(temp.contains(c) && query==true){
                temp=temp.getNode(c);
                int[] maxfreq=temp.getMaxFeq();
                for(int ff:maxfreq){
                    if(ff!=0){
                        ans.add(mapToSentense.get(ff));
                    }
                }
            }
            else{
                query = false;
            }
            return ans;
        }
    

}
class Node{
    boolean endsAt;
    Node node[];
    int max[];
    
    Node(){
        endsAt=false;
        node=new Node[27];
        max=new int[3];
    }
    
    public Node getNode(char c){
        if(c==' ')return node[26];
        else return node[c-'a'];
    }
    
    public boolean contains(char c){
        if(c==' ')return node[26]!=null;
        else return node[c-'a']!=null;
    }
    
    public void setNode(char c){
        if(c==' ')node[26]=new Node();
        else node[c-'a']=new Node();
    }
    
    public boolean isEnd(){
        return endsAt;
    }
    
    public void setEnd(){
        endsAt=true;
    }
    
    public int[] getMaxFeq(){
        return max;
    }
}
