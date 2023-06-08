Majority Element(> N/3 times)                 

Solution 1: Brute-Force
Approach: Simply count the no. of appearance for each element using nested loops and whenever you find the count of an element greater than N/3 times, that element will be your answer.
Time Complexity: O(n^2)
Space Complexity: O(1)
Solution 2: Better Solution
Approach: Traverse the whole array and store the count of every element in a map. After that traverse through the map and whenever you find the count of an element greater than N/3 times, store that element in your answer.
Dry Run: Lets take the example of arr[] = {10,20,40,40,40}, n=5.
First, we create an unordered map to store the count of each element.
Now traverse through the array 
Found 10 at  index 0, increase the value of key 10 in  the map by 1.
Found 20 at  index 1, increase the value of key 20 in  the map by 1.
Found 40 at  index 2, increase the value of key 40 in  the map by 1.
Found 40 at index 3, increase the value of key 40 in  the map by 1.
Found 40 at  index 4, increase the value of key 40 in the map by 1.
Now, Our map will look like this: 
10 -> 1 
20 ->1
40 ->3
Now traverse through the map, 
We found that the value of key 40 is greater than 2 (N/3). So, 40 is the answer.
Time Complexity: O(n)
Space Complexity: O(n)


Solution 3: Optimal Solution (Extended Boyer Moore’s Voting Algorithm)
Approach + Intuition: In our code, we start with declaring a few variables:
•	num1 and num2 will store our currently most frequent and second most frequent element.
•	c1 and c2 will store their frequency relatively to other numbers.
•	We are sure that there will be a max of 2 elements which occurs > N/3 times because there cannot be if you do a simple math addition.
Let, ele be the element present in the array at any index. 
•	if ele == num1, so we increment c1.
•	if ele == num2, so we increment c2.
•	if c1 is 0, so we assign num1 = ele.
•	if c2 is 0, so we assign num2 = ele.
•	In all the other cases we decrease both c1 and c2.
In the last step, we will run a loop to check if num1 or nums2 are the majority elements or not by running a for loop check.

Intuition: Since it’s guaranteed that a number can be a majority element, hence it will always be present at the last block, hence, in turn, will be on nums1 and nums2. For a more detailed explanation, please watch the video below.
Time Complexity: O(n)
Space Complexity: O(1)

class Solution {
    public List<Integer> majorityElement(int[] arr) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        if(arr.length==2)
		{
			if(arr[0]==arr[1])
			{
				a.add(arr[0]);
				return a;
			}
			else
			{
				a.add(arr[0]);
				a.add(arr[1]);
				return a;
			}
			
		}
        int n=arr.length;
		int el1=-1,el2=-1,c1=0,c2=0;
		for(int i=0;i<n;i++)
		{
			if(el1==arr[i])c1++;
			else if(el2==arr[i])c2++;
			else if(c1==0)
            {
                el1=arr[i];
                c1++;
            }
			else if(c2==0)
            {
                el2=arr[i];
                c2++;
            }
			else 
			{
				c1--;
				c2--;
			}
		}
		
		//System.out.println(el1+" "+el2);
		int count1=0,count2=0;
		for(int i=0;i<n;i++)
		{
			if(arr[i]==el1)count1++;
			if(arr[i]==el2)count2++;
			if(count1>(n/3))
			{
				if(!a.contains(el1))a.add(el1);
			}
			if(count2>(n/3))
			{
				if(!a.contains(el2))a.add(el2);
			}
		}
		return a;
    }
}
