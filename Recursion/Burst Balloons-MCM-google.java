
312. Burst Balloons

You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10
 

Constraints:

n == nums.length
1 <= n <= 300
0 <= nums[i] <= 100

 ================================Best MCM Solution================Accepted================================================
//MCM Solution, Tc:O(n^3), sc:O(n^2),
 
 class Solution {
    int[][] ans;
    public int maxCoins(int[] nums) {
        
        int[] arr = new int[nums.length+2];
        int n = nums.length;
        this.ans  = new int[n+1][n+1];
        
        
        // start padding         
        arr[0] = 1;
        int k = 1;
        for(int i: nums)
            arr[k++] = i;
        // end padding
        arr[k] = 1;


    // considering the range from 1 to n because we padded 1 in the start and the end
        return helper(arr,1,n);     
    }


    int helper(int[] nums, int i, int j){

        // to helperord the max value
        int max = Integer.MIN_VALUE;
        if(i>j) return 0;


        // intially the left and right will be 1 and 1. since we are choosing the last balloon first that means that it is the only one left so we need to consider the padding
        int left = nums[i-1];
        int right = nums[j+1];


        // memoization step
        if(ans[i][j]!=0) return ans[i][j];

        // trying all possible values to be burst last and taking the max one.
        // the left independent part   
        // score from bursting the current balloon         
        // the right independent part
        for(int k=i;k<=j;k++)
            max = Math.max(helper(nums,i,k-1) + left * nums[k] * right +helper(nums,k+1,j),max);
           
        ans[i][j] = max;
        return ans[i][j];
    }
}
===================================Recursion =====Backtracking======TLE==================tc==n*(n*(n+1))/2*300=====goes around 10 pow 9==========
class Solution {
    //backtracking question
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int vis[]=new int[n];
        return helper(nums,vis,n,0);
    }
    public int helper(int nums[],int vis[],int n,int count){
        //count check how many non visited nodes are yet to traverse
        if(count==n){
            return 0;
        }

        int max=0;
        //check all non visited nodes
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                vis[i]=1;

                int currCost=nums[i];
                int leftCost=1;
                int rightCost=1;

                //get the left non visited node cost
                for(int j=i-1;j>=0;j--){
                    if(vis[j]!=1){
                        leftCost=nums[j];
                        break;
                    }
                }

                //get the right non visited node cost
                for(int j=i+1;j<n;j++){
                    if(vis[j]!=1){
                        rightCost=nums[j];
                        break;
                    }
                }

                //multiply them
                currCost=currCost*rightCost*leftCost;

                //pass it to the recursive function
                max=Math.max(max,currCost+helper(nums,vis,n,count+1));

                //unvisit the visited node
                vis[i]=0;
            }
        }
        return max;
    }
}
=====================================DP=====MEMO===TLE=======================================
used string ,Integer dp for the same , what is changeing vis is changing for that visited pattern what is the answer that we are storing in the dp
 
 class Solution {
    //backtracking question
    HashMap<String,Integer> dp;

    public int maxCoins(int[] nums) {
        int n=nums.length;
        char vis[]=new char[n];
        Arrays.fill(vis,'0');
        dp=new HashMap<>();
        return helper(nums,vis,n,0);
    }

    public int helper(int nums[],char vis[],int n,int count){
        //count check how many non visited nodes are yet to traverse
        if(count==n){
            return 0;
        }

        String dpStr=String.valueOf(vis);
        if(dp.containsKey(dpStr)){
            return dp.get(dpStr);
        }

        int max=0;
        //check all non visited nodes
        for(int i=0;i<n;i++){
            if(vis[i]!='1'){
                vis[i]='1';

                int currCost=nums[i];
                int leftCost=1;
                int rightCost=1;

                //get the left non visited node cost
                for(int j=i-1;j>=0;j--){
                    if(vis[j]!='1'){
                        leftCost=nums[j];
                        break;
                    }
                }

                //get the right non visited node cost
                for(int j=i+1;j<n;j++){
                    if(vis[j]!='1'){
                        rightCost=nums[j];
                        break;
                    }
                }

                //multiply them
                currCost=currCost*rightCost*leftCost;

                //pass it to the recursive function
                max=Math.max(max,currCost+helper(nums,vis,n,count+1));

                //unvisit the visited node
                vis[i]='0';
            }
        }

        
        dp.put(dpStr,max);
        return max;
    }
}
====================================insted of vis array using set to get the next and previous baloon in log n , TLE, same as above approach in TC=====Batter to go with memo first===============
 class Solution {

    //backtracking question
    HashMap<String,Integer> dp;

    //to store the indexes which are not visited
    TreeSet<Integer> set;



    public int maxCoins(int[] nums) {
        int n=nums.length;
        dp=new HashMap<>();
        set = new TreeSet<>();
        return helper(nums,n,0);
    }


    public int helper(int nums[],int n,int count){
        //count check how many non visited nodes are yet to traverse
        if(count==n){
            return 0;
        }

        String dpStr=set.stream().map(e->e.toString()+"#").collect(Collectors.joining());
        //System.out.println(dpStr);
        if(dp.containsKey(dpStr)){
            return dp.get(dpStr);
        }

        int max=0;
        //check all non visited nodes
        for(int i=0;i<n;i++){
            if(set.contains(i)==false){
                set.add(i);

                int currCost=nums[i];
                int leftCost=1;
                int rightCost=1;

                
                //get the left non visited node cost
                int floorIdx=-1;
                try{
                    floorIdx=set.floor(i-1);
                }
                catch(Exception e){
                    ;
                }
                if(floorIdx!=-1){
                    leftCost=nums[floorIdx];
                }
                
                //get the right non visited node cost
                int ceilIdx=-1;
                try{
                    ceilIdx=set.ceiling(i+1);
                }
                catch(Exception e){
                    ;
                }
                if(ceilIdx!=-1){
                    rightCost=nums[ceilIdx];
                }

                //multiply them
                currCost=currCost*rightCost*leftCost;

                //pass it to the recursive function
                max=Math.max(max,currCost+helper(nums,n,count+1));

                //unvisit the visited node
                set.remove(i);
            }
        }
        dp.put(dpStr,max);
        return max;
    }
}
