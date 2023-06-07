Problem Statement
Suggest Edit
Ninja has to implement a data structure ”TRIE” from scratch. Ninja has to complete some functions.
1) Trie(): Ninja has to initialize the object of this “TRIE” data structure.

2) insert(“WORD”): Ninja has to insert the string “WORD”  into this “TRIE” data structure.

3) countWordsEqualTo(“WORD”): Ninja has to return how many times this “WORD” is present in this “TRIE”.

4) countWordsStartingWith(“PREFIX”): Ninjas have to return how many words are there in this “TRIE” that have the string “PREFIX” as a prefix.

5) erase(“WORD”): Ninja has to delete one occurrence of the string “WORD” from the “TRIE”.
Note:
1. If erase(“WORD”) function is called then it is guaranteed that the “WORD” is present in the “TRIE”.

2. If you are going to use variables with dynamic memory allocation then you need to release the memory associated with them at the end of your solution.
Can you help Ninja implement the "TRIE" data structure?
Detailed explanation ( Input/output format, Notes, Images )
 
Constraints:
1 <= “T” <= 50
1 <= “N” <= 10000
 “WORD” = {a to z}
1 <= | “WORD” | <= 1000

Where “T” is the number of test cases, “N” denotes how many times the functions(as discussed above) we call, “WORD” denotes the string on which we have to perform all the operations as we discussed above, and | “WORD” | denotes the length of the string “WORD”.

Time limit: 1 sec.
Sample Input 1:
1
5
insert coding
insert ninja
countWordsEqualTo coding
countWordsStartingWith nin
erase coding
Sample Output 1:
1
1   
Explanation Of Sample Input 1:
After insertion of “coding” in “TRIE”:
 
After insertion of “ninja” in “TRIE”:
 
Count words equal to “coding” :
 
Count words those prefix is “nin”:
 
After deletion of the word “coding”, “TRIE” is:
 
Sample Input 2:
1
6
insert samsung
insert samsung
insert vivo
erase vivo
countWordsEqualTo samsung
countWordsStartingWith vi
Sample Output 2:
2
0
Explanation For Sample Input 2:
insert “samsung”: we are going to insert the word “samsung” into the “TRIE”.

insert “samsung”: we are going to insert another “samsung” word into the “TRIE”.

insert “vivo”: we are going to insert the word “vivo” into the “TRIE”.

erase “vivo”: we are going to delete the word “vivo” from the “TRIE”.

countWordsEqualTo “samsung”: There are two instances of “sumsung” is present in “TRIE”.

countWordsStartingWith “vi”: There is not a single word in the “TRIE” that starts from the prefix “vi”.


import java.util.* ;
import java.io.*; 
class Node{
    Node links[]=new Node[26];
    int cp=0;
    int ew=0;

    public boolean contains(Character c){
        if(links[c-'a']==null)
            return false;
        return true;
    } 
    public Node get(Character c){
        return links[c-'a'];
    }
    public void put(Character c){
        links[c-'a']=new Node();
    }
    public void incerementcp(){
        cp++;
    }
    public void decerementcp(){
        cp--;
    }
    public void incrementew(){
        ew++;
    }
    public void decrementew(){
        ew--;
    }
    public int getcp(){
        return cp;
    }
    public int getew(){
        return ew;
    }
}
public class Trie {

    Node root;
    public Trie() {
        root=new Node();
    }

    public void insert(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            if(curr.contains(word.charAt(i))==false)
                curr.put(word.charAt(i));
            curr=curr.get(word.charAt(i));
            curr.incerementcp();
        }
        curr.incrementew();
    }

    public int countWordsEqualTo(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            if(curr.contains(word.charAt(i))==false)
                return 0;
            curr=curr.get(word.charAt(i));
        }
        return curr.getew();
    }

    public int countWordsStartingWith(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            if(curr.contains(word.charAt(i))==false)
                return 0;
            curr=curr.get(word.charAt(i));
        }
        return curr.getcp();
    }

    public void erase(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            if(curr.contains(word.charAt(i))==false)
                return;
            curr=curr.get(word.charAt(i));
            curr.decerementcp();
        }
        curr.decrementew();
    }

}
