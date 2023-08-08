Merge and Sort, gfg
class Solution {
   public static int mergeNsort(int a[], int b[], int n, int m, int answer[])
    {
        // Write your code here
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0; i<n; i++){
            hs.add(a[i]);
        }
        
        for(int i=0; i<m; i++){
            hs.add(b[i]);
        }
        
        int result[] = new int[hs.size()];
        
        int count = 0;
        for(int x : hs){
            result[count++] = x;
        }
        
        Arrays.sort(result);
        
        for(int i=0; i<count; i++){
            answer[i] = result[i];
        }
        return count;
    }
}
Given two arrays of length N and M, print the merged array in ascending order containing only unique elements.
Example 1:Input:N = 2
a[] = {1, 8}
M = 2
b[] = {10, 11}
Output:
answer[] = {1, 8, 10, 11}
Explanation:
The answer[] array after merging both
the arrays and removing duplicates is
[1 8, 10, 11]
You have to return the size of the array
formed ( 4 in this case) and update the
answer array in the function mergeNsort().
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
