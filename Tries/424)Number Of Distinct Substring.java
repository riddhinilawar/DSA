Number Of Distinct Substring

Problem Statement
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
2
3
aaa
4
abab
Sample Output 1 :
3
7
Explanation For Sample Output 1 :
For the first test case :
Following are distinct substrings of the given string ‘WORD’.
“aaa”
“aa”   
“a”

For the second test case :
Following are distinct substrings of the given string ‘WORD’.
“abab”
“aba” 
“ab”
“a”
“bab”
“ba”
“b”
Sample Input 2 :
2
1
z
3
abc    
Sample Output 2 :
1
6
Explanation For Sample Output 2:
For the first test case:
There is only one possible substring of the given string ‘WORD’ which is also distinct so the answer will be 1.

For the second test case :
Following are distinct substrings of the given string ‘WORD’.
“abc”
“ab”
“a”
“bc”
“b”
“c”
import java.util.* ;
import java.io.*; 
class Node{
    Node links[]=new Node[26];

    public boolean contains(Character c){
        return links[c-'a']!=null;
    }

    public Node get(Character c){
        return links[c-'a'];
    }

    public void put(Character c){
        links[c-'a']=new Node();
    }
}
class Trie{
    public Node root;
    Trie(){
        root=new Node();
    }
    public int insert(String word){
        int count=0;
        Node curr=root;
        for(int i=0;i<word.length();i++){
            if(curr.contains(word.charAt(i))==false){
                count++;
                curr.put(word.charAt(i));
            }
            curr=curr.get(word.charAt(i));
        }
        return count;
    }
}
public class Solution {
    public static int distinctSubstring(String word) {
        Trie obj = new Trie();
        int ans=0;
        for(int i=0;i<word.length();i++){
            //System.out.println(word.substring(i, word.length()));
            ans+=obj.insert(word.substring(i, word.length()));
        }
        return ans;
    }
}
