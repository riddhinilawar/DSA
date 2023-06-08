Majority Element(> N/2 times)                 LC-169,gfg
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
Example 1:
Input: nums = [3,2,3]
Output: 3
Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
Constraints:
•	n == nums.length
•	1 <= n <= 5 * 104
•	-109 <= nums[i] <= 109
Solution 1 (Brute Force):
Check the count of occurrences of all elements of the array one by one. Start from the first element of the array and count the number of times it occurs in the array. If the count is greater than the floor of N/2 then return that element as the answer. If not, proceed with the next element in the array and repeat the process.
Time Complexity: O(N2) 
Space Complexity: O(1)
Solution 2 (Better):
Intuition: Use a better data structure to reduce the number of look-up operations and hence the time complexity. Moreover, we have been calculating the count of the same element again and again – so we have to reduce that also.
Approach: 
1.	Use a hashmap and store as (key, value) pairs. (Can also use frequency array based on the size of nums) 
2.	Here the key will be the element of the array and the value will be the number of times it occurs. 
3.	Traverse the array and update the value of the key. Simultaneously check if the value is greater than the floor of N/2. 
1.	If yes, return the key 
2.	Else iterate forward.
Time Complexity: O(N)-> Frequency array or O(N log N) -> HashMap 
Space Complexity: O(N)

Solution 3 (Optimal):
Moore’s Voting Algorithm
Intuition: The question clearly states that the nums array has a majority element. Since it has a majority element we can say definitely the count is more than N/2.
Majority element count = N/2 + x;
Minority/Other elements = N/2 – x;
Where x is the number of times it occurs after reaching the minimum value N/2.
Now, we can say that count of minority elements and majority elements are equal up to a certain point of time in the array. So when we traverse through the array we try to keep track of the count of elements and which element we are tracking. Since the majority element appears more than N/2 times, we can say that at some point in array traversal we find the majority element. 
Approach: 
1.	Initialize 2 variables: 
1.	Count –  for tracking the count of element
2.	Element – for which element we are counting
2.	Traverse through nums array.
1.	If Count is 0 then initialize the current traversing integer of array as Element 
2.	If the traversing integer of array and Element are same increase Count by 1
3.	If they are different decrease Count by 1
3.	The integer present in Element is the result we are expecting 
Time Complexity: O(N)  ,  Space Complexity: O(1)
Most Optimal: class Solution {
    public int majorityElement(int[] arr) {
        if(arr.length==1)return 1;
        
        int element=0;
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(count==0)
			{
				element=arr[i];
                count=count+1;
			}
			else
			{
				if(arr[i]==element)
				{
					count=count+1;
				}
				else
				{
					count=count-1;
				}
			}
		}
		return element  }}
public static int fun(int arr[])
	{
		int maxcount=arr.length/2;;
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i])==true)
			{
				int temp=map.get(arr[i]);
				map.put(arr[i],temp+1 );
				if((temp+1)>maxcount)return arr[i];
			}
			else
			{
				map.put(arr[i], 1);
			}
		}
		return 0;
	}
public static int fun(int a[])
	{
		int size=a.length;
		if(size==1) return a[0];
        Arrays.sort(a);
        int count=1;
        for(int i=0;i<size-1;i++)
        {
            if(a[i]==a[i+1])
            {
                count++;
                if(count>(size/2))
                    return a[i];
            }
            else
            {
                count=1;
            }
        }
        return -1;
	}
public static int fun(int arr[]){
		int maxcount=0;
		int ans=0;
		for(int i=0;i<arr.length;i++)
		{
			int count=0;
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					count++;
				}
			}
			if(maxcount<count)
			{
				maxcount=count;
				ans=arr[i]; }}return ans;}
