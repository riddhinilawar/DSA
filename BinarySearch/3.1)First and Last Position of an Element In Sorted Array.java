Approach 1)Using upper bund lower bound method: first occ:lower bound, last occ:upper bound -1

import java.util.*;
public class Solution {

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int ans[]=new int[2];
        int lb=lowerBound(arr,n,k);
        if(arr.get(lb)!=k){
            ans[0]=-1;
            ans[1]=-1;
            return ans;
        }
        ans[0]=lb;
        ans[1]=upperBound(arr,n,k)-1;
        return ans;
    }
    public static int lowerBound(ArrayList<Integer> arr, int n, int x) {
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr.get(mid)>=x){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int upperBound(ArrayList<Integer> arr, int n, int x){
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr.get(mid)>x){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return (ans==-1)?n:ans;
    }
};


=====================================================================================================================

Approach 2)Using simple binary search
class Solution {
    
    public pair indexes(long v[], long x){
        int first=firstOcc(v,v.length,x);
        if(first == -1 || v[first]!=x){
            return new pair(-1,-1);
        }
        int last=lastOcc(v,v.length,x);
        return new pair(first,last);
    }
    public static int firstOcc(long v[], int n, long x) {
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(v[mid]==x){
                ans=mid;
                high=mid-1;
            }
            else if(v[mid]>x){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int lastOcc(long v[], int n, long x){
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            //System.out.println(mid);
            if(v[mid]==x){
                ans=mid;
                low=mid+1;
            }
            else if(v[mid]>x){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}


Problem statement
You have been given a sorted array/list 'arr' consisting of ‘n’ elements. You are also given an integer ‘k’.



Now, your task is to find the first and last occurrence of ‘k’ in 'arr'.



Note :
1. If ‘k’ is not present in the array, then the first and the last occurrence will be -1. 
2. 'arr' may contain duplicate elements.


Example:
Input: 'arr' = [0,1,1,5] , 'k' = 1

Output: 1 2

Explanation:
If 'arr' = [0, 1, 1, 5] and 'k' = 1, then the first and last occurrence of 1 will be 1(0 - indexed) and 2.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
8 2
0 0 1 1 2 2 2 2


Sample output 1:
4 7


Explanation of Sample output 1:
For this testcase the first occurrence of 2 in at index 4 and last occurrence is at index 7.


Sample Input 2:
4 2
1 3 3 5


Sample output 2:
-1 -1


Expected Time Complexity:
Try to do this in O(log(n)).


Constraints:
1 <= n <= 10^5
0 <= k <= 10^9
0 <= arr[i] <= 10^9

Time Limit : 1 second
