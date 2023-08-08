Count pairs with given sum,gfg
Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.
Input:
N = 4, K = 6
arr[] = {1, 5, 7, 1}
Output: 2
Explanation: 
arr[0] + arr[1] = 1 + 5 = 6 
and arr[1] + arr[3] = 5 + 1 = 6.
Input:
N = 4, K = 2
arr[] = {1, 1, 1, 1}
Output: 6
Explanation: 
Each 1 will produce sum 2 with any 1.

Constraints:
1 <= N <= 105
1 <= K <= 108
1 <= Arr[i] <= 106
HashMap Application
class Solution {
    int getPairsCount(int[] a, int n, int k) {
        HashMap<Integer,Integer> mp=new HashMap<Integer,Integer>();
        int pair=0;
        for(int i=0;i<n;i++)
        {
            if(mp.containsKey(k-a[i]))
            pair+=mp.get(k-a[i]);
            if(mp.containsKey(a[i]))
            mp.put(a[i],mp.get(a[i])+1);
            else
            mp.put(a[i],1);
        }
        return pair;
    }
}
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
