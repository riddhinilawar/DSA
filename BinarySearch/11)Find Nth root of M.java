class Solution{
    public int NthRoot(int n, int m){
        int low=1;
        int high=m;
        int ans=1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int temp=pow(mid,n,m);
            if(temp==0){
                return mid;
            }
            else if(temp==1){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    public int pow(int x,int n,int m){
        long ans=1;
        for(int i=0;i<n;i++){
            ans=ans*x;
            if(ans>m){
                return 2;
            }
        }
        return (m==(int)ans)?0:1;
    }
}


You are given 2 numbers (n , m); the task is to find n√m (nth root of m).
 

Example 1:

Input: n = 2, m = 9
Output: 3
Explanation: 32 = 9
Example 2:

Input: n = 3, m = 9
Output: -1
Explanation: 3rd root of 9 is not
integer.
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function NthRoot() which takes n and m as input parameter and returns the nth root of m. If the root is not integer then returns -1.
 

Expected Time Complexity: O(n* log(m))
Expected Space Complexity: O(1)
 

Constraints:
1 <= n <= 30
1 <= m <= 109

