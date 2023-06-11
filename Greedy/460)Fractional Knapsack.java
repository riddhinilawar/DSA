Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item. 

 

Example 1:

Input:
N = 3, W = 50
values[] = {60,100,120}
weight[] = {10,20,30}
Output:
240.00
Explanation:Total maximum value of item
we can have is 240.00 from the given
capacity of sack. 
Example 2:

Input:
N = 2, W = 50
values[] = {60,100}
weight[] = {10,20}
Output:
160.00
Explanation:
Total maximum value of item
we can have is 160.00 from the given
capacity of sack.
 

Your Task :
Complete the function fractionalKnapsack() that receives maximum capacity , array of structure/class and size n and returns a double value representing the maximum value in knapsack.
Note: The details of structure/class is defined in the comments above the given function.


Expected Time Complexity : O(NlogN)
Expected Auxilliary Space: O(1)


Constraints:
1 <= N <= 105
1 <= W <= 105

class Pair{
    int value;
    int weight;
    double div;
    Pair(int value,int weight,double div){
        this.value=value;
        this.weight=weight;
        this.div=div;
    }
    double getDiv(){
        return div;
    }
    
}
class ItemComparator implements Comparator<Pair>{
    @Override
    public int compare(Pair s1, Pair s2) {
    if (s1.getDiv() < s2.getDiv())
        return 1;
    else if (s1.getDiv() > s2.getDiv())
        return -1;
    else
        return 0;
    }
}
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>
        (new ItemComparator());
        
        for(int i=0;i<n;i++){
            double temp = (double)arr[i].value/(double)arr[i].weight;
            pq.add(new Pair(arr[i].value,arr[i].weight,temp));
        }  
        
        double ans=0;
        
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int value=p.value;
            int weight=p.weight;
            
            if(weight<=W){
                W-=weight;
                ans+=value;
            }
            else if(W!=0){
                int avil_W=W;
                W=0;
                
                double partial_val = ((double)value*(double)avil_W)/(double)weight;
                ans+=partial_val;
            }
        }
        
        return ans;
    }
}
