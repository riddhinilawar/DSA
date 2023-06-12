There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104
class Solution {
    public int candy(int[] ratings) {
        
        int n=ratings.length;
        
        if(n==1)return 1;
        if(n==2){
            if(ratings[0]==ratings[1])return 2;
            else return 3;
        }   

        int ans[]=new int[n];
        Arrays.fill(ans, 1);
        int answer[]=new int[n];
        Arrays.fill(answer, 1);
        
       
        
        for(int i=0;i<n;i++)
        {
            if(i==0 && ratings[0]>ratings[1])
                ans[i]=2;
            else if(i!=0 && ratings[i]>ratings[i-1])
                ans[i]=ans[i-1]+1;
        }

        for(int i=n-1;i>=0;i--)
        {
            if(i==n-1 && ratings[n-1]>ratings[n-2])
                answer[i]=2;

            else if(i!=n-1 &&ratings[i]>ratings[i+1])
                answer[i]=answer[i+1]+1;
        }

        int result=0;
        for(int i=0;i<n;i++)
            result+=Math.max(ans[i],answer[i]);

        return result;
    }
}class Solution {
    public int candy(int[] ratings) {
        
        int n=ratings.length;
        
        if(n==1)return 1;
        if(n==2){
            if(ratings[0]==ratings[1])return 2;
            else return 3;
        }   

        int ans[]=new int[n];
        Arrays.fill(ans, 1);
        int answer[]=new int[n];
        Arrays.fill(answer, 1);
        
       
        
        for(int i=0;i<n;i++)
        {
            if(i==0 && ratings[0]>ratings[1])
                ans[i]=2;
            else if(i!=0 && ratings[i]>ratings[i-1])
                ans[i]=ans[i-1]+1;
        }

        for(int i=n-1;i>=0;i--)
        {
            if(i==n-1 && ratings[n-1]>ratings[n-2])
                answer[i]=2;

            else if(i!=n-1 &&ratings[i]>ratings[i+1])
                answer[i]=answer[i+1]+1;
        }

        int result=0;
        for(int i=0;i<n;i++)
            result+=Math.max(ans[i],answer[i]);

        return result;
    }
}
