Next Permutation                                      LC-31,gfg
Solution 1 Brute Force: Finding all possible permutations. 
Approach :
Step 1: Find all possible permutations of elements present and store them.
Step 2: Search input from all possible permutations.
Step 3: Print the next permutation present right after it.
For reference of how to find all possible permutations, follow up https://www.youtube.com/watch?v=f2ic2Rsc9pU&t=32s. This video shows for distinct elements but code works for duplicates too.
Time Complexity :
For finding, all possible permutations, it is taking N!xN. N represents the number of elements present in the input array. Also for searching input arrays from all possible permutations will take N!. Therefore, it has a Time complexity of O(N!xN).
Space Complexity :
Since we are not using any extra spaces except stack spaces for recursion calls. So, it has a space complexity of O(1).
Solution 3 :
Intuition :
Intuition lies behind the lexicographical ordering of all possible permutations of a given array. There will always be an increasing sequence of all possible permutations when observed.
Let’s check all sequences of permutations of {1,2,3}.
{1,2,3} 
Thus, we can see every sequence has increasing order. Hence, our approach aims to get a peak from where the increasing sequence starts. This is what we achieve from our first step of the approach. 
Then, we need to get just a larger value than the point where the peak occurs. To make rank as few as possible but greater than input array, just perverse array from breakpoint achieved from the first step of the approach. We achieve these from all remaining steps of our approach.
Approach :
Step 1: Linearly traverse array from backward such that ith index value of the array is less than (i+1)th index value. Store that index in a variable.
Step 2: If the index value received from step 1 is less than 0. This means the given input array is the largest lexicographical permutation. Hence, we will reverse the input array to get the minimum or starting permutation. Linearly traverse array from backward. Find an index that has a value greater than the previously found index. Store index is another variable.
Step 3: Swap values present in indices found in the above two steps.
Step 4: Reverse array from index+1 where the index is found at step 1 till the end of the array.

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.
The replacement must be in place and use only constant extra memory.
 
Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:
Input: nums = [1,1,5]
Output: [1,5,1]
 
Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 100

Solved by me:

class Solution {
    public void nextPermutation(int[] nums) {
        
        
        int n=nums.length;
        
        
        if(n<2)return;
        
        int f_index=-1;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                f_index=i;
                break;
            }
        }
        System.out.println(f_index);
        if(f_index==-1)
        {
            for(int i=0;i<n/2;i++)
            {
                int temp=nums[i];
                nums[i]=nums[n-1-i];
                nums[n-1-i]=temp;
            }
        }
        else
        {
            int s_index=-1;
            for(int i=n-1;i>f_index;i--)
            {
                if(nums[i]>nums[f_index])
                {
                    s_index=i;
                    break;
                }
            }
            
            System.out.println(s_index);
            
            int temp=nums[f_index];
            nums[f_index]=nums[s_index];
            nums[s_index]=temp;
            
            int j=0;
            for(int i=f_index+1;i<=(f_index+1)+(n-1-1-f_index)/2;i++)
            {
                temp=nums[i];
                nums[i]=nums[n-1-j];
                nums[n-1-j]=temp;
                j++;
            }
        }
    }
}
Leetcode discussion:

class Solution {
    public void nextPermutation(int[] nums) {
        
        
        int n=nums.length;
        
        
        if(n<2)return;
        
        int f_index=-1;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                f_index=i;
                break;
            }
        }
        
        System.out.println(f_index);
        
        if(f_index==-1)
        {
            for(int i=0;i<n/2;i++)
            {
                int temp=nums[i];
                nums[i]=nums[n-1-i];
                nums[n-1-i]=temp;
            }
        }
        else
        {
            int s_index=-1;
            for(int i=n-1;i>f_index;i--)
            {
                if(nums[i]>nums[f_index])
                {
                    s_index=i;
                    break;
                }
            }
            
            System.out.println(s_index);
            
            swap(nums,f_index,s_index);
            reverse(nums,f_index+1,n-1);
        }
    }
    public void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
}



Striver                                            Day 1-3(Related)

Find all permutations in string/array                                     Permutation (input without duplicate elements)   LC-46,gfg
Solution 1: Recursive
Approach: We have given the nums array, so we will declare an ans vector of vector that will store all the permutations also declare a data structure.
Declare a map and initialize it to zero and call the recursive function
Base condition:
When the data structure’s size is equal to n(size of nums array)  then it is a permutation and stores that permutation in our ans, then returns it.
Recursion:
Run a for loop starting from 0 to nums.size() – 1. Check if the frequency of i is unmarked, if it is unmarked then it means it has not been picked and then we pick. And make sure it is marked as picked.
Call the recursion with the parameters to pick the other elements when we come back from the recursion make sure you throw that element out. And unmark that element in the map.

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:
Input: nums = [1]
Output: [[1]]
Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
For storing – it takes O(n) space solution
public static void permutation(int arr[],int index,ArrayList<ArrayList<Integer>>  list)
	{
		if(index==arr.length)
		{
			//for answer in list
			ArrayList<Integer> temp=new ArrayList<>();
			for(int j=0;j<arr.length;j++)
			{
				temp.add(arr[j]);
			}
			list.add(temp);
			return;
		}
		for(int i=index;i<arr.length;i++)
		{
			swap(arr,i,index);
			permutation(arr,index+1,list);
			//backtracking
			swap(arr,i,index);
		}
	}
	public static void swap(int arr[],int i,int index)
	{
		int temp=arr[i];
		arr[i]=arr[index];
		arr[index]=temp;
	}
Function call: permutation(arr,0,list);
Just for printing – it takes O(1) space solution
public static void permutation(int arr[],int index)
	{
		if(index==arr.length)
		{
			//for printing
			for(int j=0;j<arr.length;j++)
			{
				System.out.print(arr[j]);
			}
			System.out.println();
			return;
		}
		for(int i=index;i<arr.length;i++)
		{
			swap(arr,i,index);
			permutation(arr,index+1);
			//backtracking
			swap(arr,i,index);
		}
	}
	public static void swap(int arr[],int i,int index)
	{
		int temp=arr[i];
		arr[i]=arr[index];
		arr[index]=temp;
	}
Function call: permutation(arr,0);

Striver                                            Day 1-3(Related)

Find all permutations in string/array                                     Permutation (input with duplicate elements)   LC-47,gfg
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        permutation(nums,0,ans);
        return ans;
    }
    public void permutation(int arr[],int index,List<List<Integer>> list)
    {
        if(index==arr.length)
        {
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<arr.length;i++)
            {
                temp.add(arr[i]);
            }
            if(list.contains(temp)==false)
            list.add(temp);
            return;
        }
        for(int i=index;i<arr.length;i++)
        {
            swap(arr,index,i);
            permutation(arr,index+1,list);
            swap(arr,i,index);
        }
    }
    public void swap(int arr[],int a,int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
Note: If the input contains duplicate elements then,while storing the elements in the ouput arraylist check weather the out is already contains the arraylist or not, if the element is already contains then don’t store it again.(is only the difference in 2 codes)
