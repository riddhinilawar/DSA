Maximum XOR of Two Numbers in an Array


Problem Statement
Suggest Edit
Alice and Bob recently learned about bitwise xor operator. Intrigued by this concept, Alice gave Bob an array ‘A’ of ‘N’ integers and asked him to select two indexes ‘x’ and ‘y’ such that ‘x’ <= ‘y’ and bitwise xor of values present in these indexes is maximum possible among all such pairs.
As always, Bob asked you to help him do the task.
Detailed explanation ( Input/output format, Notes, Images )
 
Constraints:
1 <= T <= 5
1 <= N <= 10^4
1 <= A[i] <= 10^9 

Time Limit: 1 sec
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

class Node{

 Node [] links = new Node[2];
 Node(){
    
}
boolean containsKey(int bit)
{
    return (links[bit]!=null);
}
void put(int bit,Node node)
{
    links[bit] = node;
}
Node get(int bit)
{
    return links[bit];
}
}
class Trie{

Node root;
Trie(){
    root = new Node();
}
void insert(int nums)
{
    Node node = root;
    for(int i=31;i>=0;i--)
    {
        int bit = (nums>>i) & 1;
        if(!node.containsKey(bit))
        {
            node.put(bit,new Node());
        }
        node = node.get(bit);
    }
}
int getMax(int nums)
{
    int Maxnum = 0;
    Node node = root;
    for(int i=31;i>=0;i--)
    {
        int bit = (nums>>i) & 1;
        if(node.containsKey(1-bit))
        {
            Maxnum = Maxnum | (1<<i);
            node = node.get(1-bit);
        }
        else
        node = node.get(bit);
    }
    return Maxnum;
}
}
class Solution {

public int[] maximizeXor(int[] nums, int[][] queries) {
    Arrays.sort(nums);
    int [] ans = new int[queries.length];
    int [][] offlineOrders = new int[queries.length][3];
    for(int i=0;i<queries.length;i++)
    {
        offlineOrders[i][0] = queries[i][0];
        offlineOrders[i][1] = queries[i][1];
        offlineOrders[i][2] = i;
    }
    //sort based on mi(queries[i][1]);
    Arrays.sort(offlineOrders,(a,b)->(a[1]-b[1]));
    int index = 0;
    Trie trie = new Trie();
    for (int query[] : offlineOrders) {
        while (index < nums.length && nums[index] <= query[1]) {
            trie.insert(nums[index]);
            index++;
        }
        int tmpval = -1;
        if (index != 0) 
            tmpval = trie.getMax(query[0]);
        ans[query[2]] = tmpval;
    }
    return ans;
}
}

---------------------------------------------------------------------------------------------------------------------
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

