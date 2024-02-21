Numbers with one absolute difference




Given a number N. The task is to return all the numbers less than or equal to N in increasing order, with the fact that absolute difference between any adjacent digits of number should be 1.
 

Example 1:

Input: N = 20
Output: 10 12
Explanation: Diff between 1 and 0 and
Diff between 1 and 2 is one.

Example 2:

Input:
N = 9
Output: -1
Explanation: No such number exist.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function absDifOne() which takes an integer as input and returns a list of numbers.
 

Expected Time Complexity : O(2Number of Digits in N)
Expected Auxiliary Space : O(2Number of Digits in N)

Constraints:
1 <= N <= 1012



class Solution{
    ArrayList<Long> absDifOne(long N){
        ArrayList<Long> list = new ArrayList<>();
        Queue<Long> q = new LinkedList<>();
        for(long i=1;i<=9;i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            long curr=q.remove();
            if(curr>N){
                continue;
            }
            if(curr>9){
                list.add(curr);
            }
            if(curr%10!=0){
                q.add((curr*10)+(curr%10-1));
            }
            if(curr%10!=9){
                q.add((curr*10)+(curr%10+1));
            }
        }
        
        return list;
    }

}
==================================================================================================
//User function Template for Java

class Solution{
    ArrayList<Long> absDifOne(long N){
        ArrayList<Long> list = new ArrayList<>();
        for(long i=1;i<=9;i++){
            helper(i,list,N);
        }
        Collections.sort(list);
        return list;
    }
    void helper(long curr,ArrayList<Long> list,long n){
        if(curr>n){
            return;
        }
        if(curr>9){
            list.add(curr);
        }
        if(curr%10!=0){
            helper((curr*10)+(curr%10-1),list,n);
        }
        if(curr%10!=9){
            helper((curr*10)+(curr%10+1),list,n);
        }
    }
}
