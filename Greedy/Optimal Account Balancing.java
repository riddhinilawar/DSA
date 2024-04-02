465. Optimal Account Balancing
A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.

Note:

A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
Example 1:

Input:
[[0,1,10], [2,0,5]]

Output:
2

Explanation:
Person #0 gave person #1 $10.
Person #2 gave person #0 $5.

Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
Example 2:

Input:
[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

Output:
1

Explanation:
Person #0 gave person #1 $10.
Person #1 gave person #0 $1.
Person #1 gave person #2 $5.
Person #2 gave person #0 $5.

Therefore, person #1 only need to give person #0 $4, and all debt is settled.

class Solution {
    public int[][] minCashFlow(int[][] transaction, int n) {
        HashMap<Integer,Integer> trans = new HashMap<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                int giving=i;
                int taking=j;
                int amount=transaction[i][j];
                
                trans.put(taking,trans.getOrDefault(taking,0)-transaction[i][j]);
                trans.put(giving,trans.getOrDefault(giving,0)+transaction[i][j]);
            }
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> give = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
        PriorityQueue<Map.Entry<Integer, Integer>> take = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
        
        int ans[][]=new int[n][n];
        
        for(int person:trans.keySet()){
            int value=trans.get(person);
            
            if(value==0)continue;
            else if(value>0){
                take.add(new AbstractMap.SimpleEntry<>(person,value));
            }
            else{
                give.add(new AbstractMap.SimpleEntry<>(person,-value));
            }
        }
        
        while(!take.isEmpty()){
            int takeAmount=take.peek().getValue();
            int takePerson=take.peek().getKey();
            
            int giveAmount=give.peek().getValue();
            int givePerson=give.peek().getKey();
            
            give.remove();
            take.remove();
            
            if(takeAmount==giveAmount){
                ans[takePerson][givePerson]=takeAmount;
            }
            else if(takeAmount>giveAmount){
                int currAmount=takeAmount-giveAmount;
                ans[takePerson][givePerson]=giveAmount;
                take.add(new AbstractMap.SimpleEntry<>(takePerson,currAmount));
            }
            else{
                int currAmount=giveAmount-takeAmount;
                ans[takePerson][givePerson]=takeAmount;
                give.add(new AbstractMap.SimpleEntry<>(givePerson,currAmount));
            }
        }
        
        return ans;
    }
}
class Pair{
    int person;
    int value;
    Pair(int person,int value){
        this.person=person;
        this.value=value;
    }
}
