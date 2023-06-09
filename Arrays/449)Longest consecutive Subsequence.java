Longest consecutive Subsequence           LC-128,gfg
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.
 
Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Constraints:  0 <= nums.length <= 105
Solution 1 (Brute Force):
 We can simply sort the array and run a for loop to find the longest consecutive sequence.
Time Complexity: O(NlogN) 
Space Complexity: O(1)
Solution 2 (Better):
 We will first push all are elements in the HashSet. Then we will run a for loop and check for any number(x) if it is the starting number of the consecutive sequence by checking if the HashSet contains (x-1) or not. If ‘x’ is the starting number of the consecutive sequence we will keep searching for the numbers y = x+1, x+2, x+3, ….. And stop at the first ‘y’ which is not present in the HashSet. Using this we can calculate the length of the longest consecutive subsequence. 
Time Complexity: O(N)-> Frequency array or O(N) ->  (Assuming hashset takes O(1) to search)
Space Complexity: O(N)









Approach 1:
if(nums.length==0)return 0;
        
        int count=1;
        int maxcount=1;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
                continue;
            if(nums[i]==nums[i+1]-1)
            {
                count++;
            }
            else
            {
                count=1;
            }
            maxcount=Math.max(maxcount,count);
        }
        return maxcount;
Approach 2:
Set < Integer > hashSet = new HashSet < Integer > ();
        for (int num: nums) {
            hashSet.add(num);
        }

        int longestStreak = 0;

        for (int num: nums) {
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
