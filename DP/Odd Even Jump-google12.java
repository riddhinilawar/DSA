975. Odd Even Jump

You are given an integer array arr. From some starting index, you can make a series of jumps. The (1st, 3rd, 5th, ...) jumps in the series are called odd-numbered jumps, and the (2nd, 4th, 6th, ...) jumps in the series are called even-numbered jumps. Note that the jumps are numbered, not the indices.

You may jump forward from index i to index j (with i < j) in the following way:

During odd-numbered jumps (i.e., jumps 1, 3, 5, ...), you jump to the index j such that arr[i] <= arr[j] and arr[j] is the smallest possible value. If there are multiple such indices j, you can only jump to the smallest such index j.
During even-numbered jumps (i.e., jumps 2, 4, 6, ...), you jump to the index j such that arr[i] >= arr[j] and arr[j] is the largest possible value. If there are multiple such indices j, you can only jump to the smallest such index j.
It may be the case that for some index i, there are no legal jumps.
A starting index is good if, starting from that index, you can reach the end of the array (index arr.length - 1) by jumping some number of times (possibly 0 or more than once).

Return the number of good starting indices.

 

Example 1:

Input: arr = [10,13,12,14,15]
Output: 2
Explanation: 
From starting index i = 0, we can make our 1st jump to i = 2 (since arr[2] is the smallest among arr[1], arr[2], arr[3], arr[4] that is greater or equal to arr[0]), then we cannot jump any more.
From starting index i = 1 and i = 2, we can make our 1st jump to i = 3, then we cannot jump any more.
From starting index i = 3, we can make our 1st jump to i = 4, so we have reached the end.
From starting index i = 4, we have reached the end already.
In total, there are 2 different starting indices i = 3 and i = 4, where we can reach the end with some number of
jumps.
Example 2:

Input: arr = [2,3,1,1,4]
Output: 3
Explanation: 
From starting index i = 0, we make jumps to i = 1, i = 2, i = 3:
During our 1st jump (odd-numbered), we first jump to i = 1 because arr[1] is the smallest value in [arr[1], arr[2], arr[3], arr[4]] that is greater than or equal to arr[0].
During our 2nd jump (even-numbered), we jump from i = 1 to i = 2 because arr[2] is the largest value in [arr[2], arr[3], arr[4]] that is less than or equal to arr[1]. arr[3] is also the largest value, but 2 is a smaller index, so we can only jump to i = 2 and not i = 3
During our 3rd jump (odd-numbered), we jump from i = 2 to i = 3 because arr[3] is the smallest value in [arr[3], arr[4]] that is greater than or equal to arr[2].
We can't jump from i = 3 to i = 4, so the starting index i = 0 is not good.
In a similar manner, we can deduce that:
From starting index i = 1, we jump to i = 4, so we reach the end.
From starting index i = 2, we jump to i = 3, and then we can't jump anymore.
From starting index i = 3, we jump to i = 4, so we reach the end.
From starting index i = 4, we are already at the end.
In total, there are 3 different starting indices i = 1, i = 3, and i = 4, where we can reach the end with some
number of jumps.
Example 3:

Input: arr = [5,1,3,4,2]
Output: 3
Explanation: We can reach the end from starting indices 1, 2, and 4.
 

Constraints:

1 <= arr.length <= 2 * 104
0 <= arr[i] < 105
=======================================================TC:NlogN===============================
 class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        //keeping the last node in the map, because we can visit at and making thier flags true.
        map.put(arr[n - 1], n - 1);
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n - 1] = true;
        even[n - 1] = true;

        //starting from last-1 node
        for (int i = n - 2; i >= 0; i--) {

            //from the current element checking wether next greater or equal value exist
            Map.Entry<Integer, Integer> oddEntry = map.ceilingEntry(arr[i]);

            //from current element checking wether the next smaller or equal value exists
            Map.Entry<Integer, Integer> evenEntry = map.floorEntry(arr[i]);

            //if exists then from that next max value can you make the even jump
            if (oddEntry != null) {
                odd[i] = even[oddEntry.getValue()];
            }

            //if exists then from that next min value can you make the odd jump
            if (evenEntry !=  null) {
                even[i] = odd[evenEntry.getValue()];
            }
            map.put(arr[i], i);
        }

        //checking just the odd array because the first jump you take will be always odd
        int res = 0;
        for (boolean o : odd) {
            if(o) res++;
        }
        return res;

    }
}
===============================================TC:N*N in worse case======================================
class Solution {
    HashMap<Integer,Integer> minMap;
    HashMap<Integer,Integer> maxMap;
    public int oddEvenJumps(int[] arr) {
        
        int n=arr.length;

        //index and min/max value
        minMap = new HashMap<>(); 
        maxMap = new HashMap<>();

        int[][] pair = new int[n][2];
        for(int i=0;i<n;i++){
            pair[i][0]=i;
            pair[i][1]=arr[i];
        }

        Arrays.sort(pair,(a,b)->(a[1]==b[1]?a[0]-b[0]:a[1]-b[1]));

        for(int i=0;i<n;i++){
            int currIdx=pair[i][0];
            int currVal=pair[i][1];
            int getMinIdx=-1;
            int getMaxIdx=-1;

            for(int j=i-1;j>=0;j--){
                if(pair[j][1]<currVal && currIdx<pair[j][0]){
                    getMinIdx=pair[j][0];
                    int k=j-1;
                    while(k>=0 && pair[k][1]==arr[getMinIdx] && currIdx<pair[k][0]){
                        getMinIdx=pair[k][0];
                        k--;
                    }
                    break;
                } 
            }

            for(int j=i+1;j<n;j++){
                if(pair[j][1]==currVal){
                    //for handling next min condition when numbers are same.
                    //because we are taking forward jump, we will get next minimum and next maximum forward only
                    getMinIdx=pair[j][0];
                    getMaxIdx=pair[j][0];
                    break;
                } 
                else if(pair[j][1]>currVal && currIdx<pair[j][0]){
                    getMaxIdx=pair[j][0];
                    break;
                } 
            }
        
            minMap.put(currIdx,getMinIdx);
            maxMap.put(currIdx,getMaxIdx);
        }
        //System.out.println(minMap+" "+maxMap);
        int ans=0;
        int dp[][]=new int[n][2];
        for(int d[]:dp){
            Arrays.fill(d,Integer.MIN_VALUE);
        }
        for(int i=0;i<n;i++){
            ans+=(helper(i,1,arr,dp)==-1?0:1);
        }

        return ans;
    }
    public int helper(int idx,int jump,int arr[],int dp[][]){
        if(idx==arr.length-1){
            return 1;
        }

        if(dp[idx][jump]!=Integer.MIN_VALUE){
            return dp[idx][jump];
        }
        int next=-1;

        if(jump==1){
            next=maxMap.get(idx);
        }
        else{
            next=minMap.get(idx);
        }

        if(next==-1){
            return -1;
        }

        int temp=helper(next,1-jump,arr,dp);

        return dp[idx][jump]=temp;
    }
}
