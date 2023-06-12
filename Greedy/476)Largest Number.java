179. Largest Number


Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109
  
class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((s,t)->(t+s).compareTo(s+t));
        StringBuilder sb = new StringBuilder();

        for(int num:nums)
            pq.add(String.valueOf(num));
        
        while(!pq.isEmpty())
            sb.append(pq.poll());

        int zero = 0;
        String s = sb.toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') zero++;
            else break;
        }
        s = s.substring(zero);
        return s.length() > 0 ? s : "0";
    }
}
