Ceil the floor,gfg                       
Given an unsorted array Arr[] of N integers and an integer X, find floor and ceiling of X in Arr[0..N-1].
Floor of X is the largest element which is smaller than or equal to X. Floor of X doesn’t exist if X is smaller than smallest element of Arr[].
Ceil of X is the smallest element which is greater than or equal to X. Ceil of X doesn’t exist if X is greater than greatest element of Arr[].
Example 1:Input:
N = 8, X = 7
Arr[] = {5, 6, 8, 9, 6, 5, 5, 6}
Output: 6 8
Explanation:Floor of 7 is 6 and ceil of 7 is 8.
Example 2:Input:
N = 8, X = 10
Arr[] = {5, 6, 8, 9, 6, 5, 5, 6}
Output: 9 -1
Explanation:Floor of 10 is 9 but ceil of 10 is not possible.
class Solve {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        
        int floor=Integer.MIN_VALUE;
        int ceil=Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++)
        {
            if(arr[i]<=x&&arr[i]>=floor)
            floor=arr[i];
            
            if(arr[i]>=x&&arr[i]<=ceil)
            ceil=arr[i];
        }
        
        if(ceil==Integer.MAX_VALUE)ceil=-1;
        if(floor==Integer.MIN_VALUE)floor=-1;
        return new Pair(floor ,ceil);
    }
}

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
