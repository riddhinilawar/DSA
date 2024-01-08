last occurrence  of x,         gfg                     
Given a sorted array arr containing n elements with possibly duplicate elements, the task is to find indexes of last occurrences of an element x in the given array.
Example 1:Input:
n=9, x=5
arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
Output:  5
Explanation: First occurrence of 5 is at index 2 and lastoccurrence of 5 is at index 5. 
Example 2:Input:
n=9, x=7
arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
Output:  6 
Constraints:
1 ≤ N ≤ 107
public class solution {
  public static int solve(int n, int key, int[] v) {
    int start = 0;
    int end = n - 1;
    int res = -1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (v[mid] == key) {
        res = mid;
        start = mid + 1;

      } else if (key < v[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;
  }
  public static void main(String args[]) {
    int n = 7;
    int key = 13;
    int[] v = {3,4,13,13,13,20,40};

    // returning the last occurrence index if the element is present otherwise -1
    System.out.println(solve(n, key, v));
  }
}
Constraints:
1 ≤ N ≤ 107
Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

