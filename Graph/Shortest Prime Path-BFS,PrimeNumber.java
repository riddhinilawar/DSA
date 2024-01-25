Shortest Prime Path

You are given two four digit prime numbers Num1 and Num2. Find the distance of the shortest path from Num1 to Num2 that can be attained by altering only single digit at a time such that every number that we get after changing a digit is a four digit prime number with no leading zeros.

Example 1:

Input:
Num1 = 1033 
Num2 = 8179
Output: 6
Explanation:
1033 -> 1733 -> 3733 -> 3739 -> 3779 -> 8779 -> 8179.
There are only 6 steps reuired to reach Num2 from Num1. 
and all the intermediate numbers are 4 digit prime numbers.
Example 2:

Input:
Num1 = 1033 
Num2 = 1033
Output:
0
Your Task:  
You don't need to read input or print anything. Your task is to complete the function solve() which takes two integers Num1 and Num2 as input parameters and returns the distance of the shortest path from Num1 to Num2. If it is unreachable then return -1.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1000<=Num1,Num2<=9999
Num1 and Num2 are prime numbers.



class Solution{
    int solve(int Num1,int Num2){
        if(Num1 ==Num2)return 0;
        
        boolean isPrime[]=new boolean[10000];
        sieveOfEratosthenes(isPrime);
        
        Queue<Pair> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        vis.add(Num1);
        q.add(new Pair(Num1,0));
        
        while(!q.isEmpty()){
            Pair p=q.remove();
            int curr=p.num;
            int weight=p.weight;
            //System.out.println(curr);
            char[] arr=String.valueOf(curr).toCharArray();
            
            for(int i=0;i<4;i++){
                for(int j='0';j<='9';j++){
                    
                    if(i==0 && j=='0')continue;
                    
                    char prev=arr[i];
                    arr[i]=(char)j;
                    
                    int temp=Integer.parseInt(String.valueOf(arr));
                    //if(curr==3733)System.out.println(temp+" "+isPrime[temp]);
                    if(temp==Num2)return weight+1;
                    
                    if(!vis.contains(temp) && isPrime[temp]==true){
                        vis.add(temp);
                        q.add(new Pair(temp,weight+1));
                    }
                    
                    arr[i]=prev;
                }
            }
        }
        
        return -1;
        
    }
    void sieveOfEratosthenes(boolean isPrime[]){
        Arrays.fill(isPrime,true);
        
        for(int i=2;i<isPrime.length;i++){
            if(isPrime[i]==true){
                for(int j=i*i;j<isPrime.length;j+=i){
                    isPrime[j]=false;
                }
            }
        }
    }
}
class Pair{
    int num;
    int weight;
    Pair(int num,int weight){
        this.num=num;
        this.weight=weight;
    }
}
