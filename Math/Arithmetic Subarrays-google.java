1630. Arithmetic Subarrays

A sequence of numbers is called arithmetic if it consists of at least two elements, and the difference between every two consecutive elements is the same. More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i.

For example, these are arithmetic sequences:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic:

1, 1, 2, 5, 7
You are given an array of n integers, nums, and two arrays of m integers each, l and r, representing the m range queries, where the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.

Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can be rearranged to form an arithmetic sequence, and false otherwise.

 

Example 1:

Input: nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
Output: [true,false,true]
Explanation:
In the 0th query, the subarray is [4,6,5]. This can be rearranged as [6,5,4], which is an arithmetic sequence.
In the 1st query, the subarray is [4,6,5,9]. This cannot be rearranged as an arithmetic sequence.
In the 2nd query, the subarray is [5,9,3,7]. This can be rearranged as [3,5,7,9], which is an arithmetic sequence.
Example 2:

Input: nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
Output: [false,true,false,false,true,true]
 

Constraints:

n == nums.length
m == l.length
m == r.length
2 <= n <= 500
1 <= m <= 500
0 <= l[i] < r[i] < n
-105 <= nums[i] <= 105

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        
        //create the pair and sort them according to values//
        int Pair[][]=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            Pair[i][0]=i;
            Pair[i][1]=nums[i];
        }
        Arrays.sort(Pair,(a,b)->a[1]-b[1]);

        //traverse through the queries//
        for(int i=0;i<l.length;i++){
            int left=l[i];
            int right=r[i];

            boolean result=true;
            int total=right-left+1,cnt=0;

            //if the sequence have 2 elements it means it will always be true//
            if(total==2){
                ans.add(result);
                continue;
            }

            int diff=Integer.MIN_VALUE,num1=Integer.MIN_VALUE,num2=Integer.MIN_VALUE;
            //find the difference while traversing and get the diff//
            //once you got the diff just check if difference condition satisfies//
            for(int j=0;j<nums.length;j++){
                if(Pair[j][0]>=left && Pair[j][0]<=right){
                    cnt++;

                    if(diff!=Integer.MIN_VALUE){
                        int num3=Pair[j][1];

                        if(num3-num2!=diff){
                            result=false;
                            break;
                        }

                        num2=num3;
                    }
                    else{
                        if(num1==Integer.MIN_VALUE){
                            num1=Pair[j][1];
                           
                        }
                        else if(num2==Integer.MIN_VALUE){
                            num2=Pair[j][1];
                            diff=num2-num1;
                            
                        }
                    }
                    if(cnt==total)break;
                }
            }

            ans.add(result);
        }
        return ans;
    }
}
