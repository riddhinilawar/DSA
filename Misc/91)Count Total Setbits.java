Count Total Setbits,gfg


You are given a number N. Find the total number of setbits in the numbers from 1 to N. 


Example 1:

Input: N = 3
Output: 4
Explaination: 
1 -> 01, 2 -> 10 and 3 -> 11. 
So total 4 setbits.
 

Example 2:

Input: N = 4
Output: 5
Explaination: 1 -> 01, 2 -> 10, 3 -> 11 
and 4 -> 100. So total 5 setbits.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function countBits() which takes N as input parameter and returns the total number of setbits upto N.

 

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

 

Constraints:
1 ≤ N ≤ 106  



class Solution{
    static int countBits(int n){
        HashMap<Integer,Integer> bits = new HashMap<>();
        int prev=2,count=1;
        bits.put(1,1);
        bits.put(2,2);
        for(int i=3;i<1000001;i++){
            if((i & (i-1)) ==0){
                bits.put(i,prev+prev + (int)Math.pow(2,count)-1);
                prev=prev+prev + (int)Math.pow(2,count)-1;
                count++;
                
                //System.out.println(i+" "+bits.get(i));
            }
        }
        //System.out.println(bits);
        
        int ans=0;
        count=20;
        int temp=0;
        
        while(n>0){
            if(n>= (int)Math.pow(2,count)){
                //System.out.println((int)Math.pow(2,count)+" "+n);
                n=n-(int)Math.pow(2,count);
                ans+=(bits.get((int)Math.pow(2,count))+((int)Math.pow(2,count) * temp));
                count--;
                temp++;
            }
            else count--;
        }
        
        return ans;
    }
}
