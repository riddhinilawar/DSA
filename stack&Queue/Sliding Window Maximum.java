239. Sliding Window Maximum

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length



class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();  // stores *indices*
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            // remove first element if it's outside the window
            if (q.getFirst() == i - k) {
                q.removeFirst();
            }
            // if window has k elements add to results (first k-1 windows have < k elements because we start from empty window and add 1 element each iteration)
            if (i >= k - 1) {
                res.add(nums[q.peek()]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();            
    }
}

=================================================================================================================

class Solution {
    
public int[] maxSlidingWindow(int[] nums, int k) {
  // assume nums is not null
  if (nums.length == 0 || k == 0) {
    return new int[0];
  }
  int n = nums.length;
  int[] result = new int[n - k + 1]; // number of windows
  
  // left & right
  int[] left = new int[n];
  int[] right = new int[n];
  left[0] = nums[0]; // init
  right[n - 1] = nums[n - 1];
  
  for (int i = 1; i < n; ++i) {
    // left
    if (i % k == 0) left[i] = nums[i];
    else            left[i] = Math.max(left[i - 1], nums[i]);
    // right
    int j = n - i - 1;
    if (j % k == (k - 1)) right[j] = nums[j];
    else                  right[j] = Math.max(right[j + 1], nums[j]);
  }
  
  // dp
  for (int i = 0, j = i + k - 1; j < n; ++i, ++j) {
    result[i] = Math.max(right[i], left[j]);
  }
  
  return result;
}
}
