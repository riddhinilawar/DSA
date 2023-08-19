Duplicate Distance -BNY Mellon                     
Given an array of integers, print out an array where at each index I, the total distance from I t every other duplicate element of I in the array is showm.
 
Example 1:
Input: nums = [1,3,1,1,2]
Output: [5,0,3,4,0]

Example 2:
Input: nums = [1,1,1,1,1]
Output: [10,7,6,7,10]
 
Example 3:
Input: nums = [1,2,3,4,5]
Output: [0,0,0,0,0]


Approach:

Solution 1: nested for loop

public static void fun(int arr[],int n)
	{
		//putting elements in hashmap
		Hashtable<Integer, ArrayList<Integer>> hash=new Hashtable<>();
		for(int i=0;i<n;i++)
		{
			if(hash.containsKey(arr[i]))
			{
				ArrayList<Integer> temp=hash.get(arr[i]);
				temp.add(i);
				hash.put(arr[i], temp);
			}
			else
			{
				ArrayList<Integer> temp=new ArrayList<Integer>();
				temp.add(i);
				hash.put(arr[i], temp);
			}
		}
		
		//creating ans array and putting all the values in it.
		int ans[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ArrayList<Integer> temp=hash.get(arr[i]);
			int sum=0;
			for(int j=0;j<temp.size();j++)
			{
				sum+=Math.abs(i-temp.get(j));
			}
			ans[i]=sum;
		}
		
		//printing ans
		for(int i: ans)
			System.out.print(i+" ");
	}

Time Complexity: O(n^2) 
Space Complexity: O(n), we are using hashmap

Solution 2: Optimal
public static void fun1(int arr[],int n)
	{
		//putting elements in hashmap
		HashMap<Integer, ArrayList<Integer>> hash=new HashMap<>();
		int ans[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			int sum=0;
			if(hash.containsKey(arr[i]))
			{
				for(int c:hash.get(arr[i]))
				{
					ans[c]+=i-c;
					sum+=i-c;
				}
			}
			ans[i]+=sum;
			hash.putIfAbsent(arr[i], new ArrayList<>());
			hash.get(arr[i]).add(i);
		}
		//System.out.println(hash);
		
		
		
		//printing ans
		for(int i: ans)
			System.out.print(i+" ");
	}
Time Complexity: O(n)
Space Complexity: O(n), we are using hashmap.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
