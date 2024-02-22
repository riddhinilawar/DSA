Given an array of words, find all shortest unique prefixes to represent each word in the given array. Assume that no word is prefix of another.

Note:: Just insert everything in trie..then increment the counter of all the nodes while insering itself
..while finding the word when you reach at the char having 1 count ..break and return the prefix..

Example 1:

Input: 
N = 4
arr[] = {"zebra", "dog", "duck", "dove"}
Output: z dog du dov
Explanation: 
z => zebra 
dog => dog 
duck => du 
dove => dov 
Example 2:

Input: 
N = 3
arr[] =  {"geeksgeeks", "geeksquiz",
                       "geeksforgeeks"};
Output: geeksg geeksq geeksf
Explanation: 
geeksgeeks => geeksg 
geeksquiz => geeksq 
geeksforgeeks => geeksf
Your task:
You don't have to read input or print anything. Your task is to complete the function findPrefixes() which takes the array of strings and it's size N as input and returns a list of shortest unique prefix for each word
 
Expected Time Complexity: O(N*length of each word)
Expected Auxiliary Space: O(N*length of each word)
 
Constraints:
1 ≤ N, Length of each word ≤ 1000

  class Solution {
    static String[] findPrefixes(String[] arr, int N) {
        String[] ans = new String[N];
        
        Trie trieObj = new Trie();
        for(String s: arr){
            trieObj.insert(s);
        }
        
        for(int i=0;i<N;i++){
            ans[i]=trieObj.getPrefix(arr[i]);
        }
        
        return ans;
    }
}
class Trie{
    
    Node root;
    
    Trie(){
        root=new Node();
    }
    
    void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curr.contains(c)==false){
                curr.setNode(c);
            }
            curr=curr.getNode(c);
            curr.incrementCount();
        }
    }
    
    String getPrefix(String word){
        Node curr=root;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            curr=curr.getNode(c);
            if(curr.getCount()<=1){
                sb.append(c);
                break;
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
class Node{
    Node arr[]=new Node[26];
    int count=0;
    
    
    boolean contains(char c){
        return arr[c-'a']!=null;
    }
    
    void setNode(char c){
        arr[c-'a']=new Node();
    }
    
    Node getNode(char c){
        return arr[c-'a'];
    }
    
    int getCount(){
        return count;
    }
    
    void incrementCount(){
        count++;
    }
}
