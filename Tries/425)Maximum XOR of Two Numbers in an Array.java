Problem Statement
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
2
3
2 1 4
2
3 2
Sample Output 1:
6
1
Explanation For Sample Input 1:
In the first test case, Bob can select the 1st and 3rd index leading to a xor value of 6.
In the second test case, there are only two elements, so Bob has to select both of them, so the final answer becomes 1.
Sample Input 2:
2
4 
1 2 3 4
3 
5 3 2
Sample Output 2:
7
7

import java.util.* ;
import java.io.*; 
class Node{
    Node links[]=new Node[2];
    public boolean contains(int i){
        return links[i]!=null;
    }
    public Node get(int i){
        return links[i];
    }
    public void put(int i){
        links[i]=new Node();
    }
}
class Trie{
    public Node root;
    Trie(){
        root=new Node();
    }
    public void insert(int num){
        Node curr=root;
        for(int i=31;i>=0;i--){
            int bit = ((num & (1<<i))==0)?0:1;
            if(curr.contains(bit)==false)
                curr.put(bit);
         
            curr=curr.get(bit);
        }
    } 
    public int getMaxXOR(int x){
        int temp=0;
        Node curr=root;

        for(int i=31;i>=0;i--){

            int bit = ((x & (1<<i))==0)?0:1;

            if(curr.contains(1-bit)==true){
                temp=temp|(1<<i);
                curr=curr.get(1-bit);
            }
            else{
                curr=curr.get(bit);
            }
        }

        return temp;
    }
}
public class Solution {

    public static int maximumXor(int[] A) {
        
        Trie obj = new Trie();
        
        for(int num:A)
            obj.insert(num);

        int max=Integer.MIN_VALUE;

        for(int x:A)
            max=Math.max(max,obj.getMaxXOR(x));

        return max;
    }
}
