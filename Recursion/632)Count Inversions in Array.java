Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).
What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].
Example 1:
Input Format: N = 5, array[] = {1,2,3,4,5}

Result: 0

Explanation: we have a sorted array and the sorted array 
has 0 inversions as for i < j you will never find a pair 
such that A[j] < A[i]. More clear example: 2 has index 1 
and 5 has index 4 now 1 < 5 but 2 < 5 so this is not an 
inversion.
Example 2:
Input Format: N = 5, array[] = {5,4,3,2,1}

Result: 10

Explanation: we have a reverse sorted array and we will 
get the maximum inversions as for i < j we will always 
find a pair such that A[j] < A[i]. 
Example: 5 has index 0 and 3 has index 2 now (5,3) pair 
is inversion as 0 < 2 and 5 > 3 which will satisfy out 
conditions and for reverse sorted array we will get 
maximum inversions and that is (n)*(n-1) / 2.

For above given array there is 4 + 3 + 2 + 1 = 10 inversions.
Example 3:
Input Format: N = 5, array[] = {5,3,2,1,4}

Result: 7

Explanation: There are 7 pairs (5,1), (5,3), (5,2), (5,4),
(3,2), (3,1), (2,1) and we have left 2 pairs (2,4) and 
(1,4) as both are not satisfy our condition. 

Solution 1:
Intuition: Let’s understand the Question more deeply we are required to give the total number of inversions and the inversions are: For i & j < size of an array if i < j then you have to find pair (A[i], A[j]) such that A[j] < A[i]. Let’s take an example of array  [5,3,2,1,4] and to satisfy the first condition which is i < j for i, j < N,  we fix an element and traverse the next array elements then we are good to satisfy the first requirement.
The second condition which is for i < j we can only take pairs (A[i], A[j]) such that A[j] < A[i] and to satisfy this condition we will iterate through the array and check the condition A[j] < A[i] and if this is true then we will add 1 to answer.
But if we do it by brute force, it will cost O(n^2) time complexity because we have to add two nested loops to check the 2nd condition, but if we have the sorted array, then it could be easier to get the answer. How?
If an array is sorted, the array inversions are 0, and if reverse sorted, the array inversions are maximum.
But what if we have an unsorted array?
To sort the array, we will use mergeSort. In mergeSort, we will deep in one element, compare two elements, and put it in a new array in sorted order. By doing this for log(N) time, we will get the sorted array, and while comparing the two array elements, we will add some more lines of code such that it will count the inversion of the smaller array and slowly it will count for larger and larger array.
Approach: 
Let’s understand the algorithm by example. We slice the array in the middle and further slice it in merge sort, as shown in the figure.
 
The single element is always sorted after slicing to the bottom and getting them on an element as an array. Before returning the merged array with sorted numbers, we will count the inversion from there. How?
1st condition i < j above in the image, you can see that the right element’s index is always greater, so while computing the inversion, we should take care only 2nd condition, which is if i < j then A[j] < A[i] to make a pair and add one to the count.
In the above example i < j as i is the 5’s index and j is 3’s index and (A[i] == 5) > (A[j] == 3) so we got our first inversion pair (5,3) after that merge then into one array [3,5] and return it for further computations now lets take another example:
[2,3,5] and [1,4] and count = 3. How to calculate it further? 
Compare elements in 1st array with the 2nd array’s all elements if 1’s array’s element is greater than 2’s array then we will count it as inversion pair as 1st condition for inversion will always satisfy with right arrays. 2 > [1], 3 > [1], 5 > [1,4] so we will get 4 inversion pairs from this. and total inversion pair from [5,3,2,1,4] is 7.
Dry Run: I have explained the main dry run case above, and for a full dry run, I have added this image:
 

Time complexity: O(nlogn)
Space Complexity: O(1)









public class ReversePair {
	public static int merge(int arr[],int temp[],int left,int mid,int right)
	{
	    int inv_count=0;
	    int i = left;
	    int j = mid;
	    int k = left;
	    while((i <= mid-1) && (j <= right)){
	        if(arr[i] <= arr[j]){
	            temp[k++] = arr[i++];
	        }
	        else
	        {
	            temp[k++] = arr[j++];
	            inv_count = inv_count + (mid - i);
	        }
	    }
	    while(i <= mid - 1)
	        temp[k++] = arr[i++];

	    while(j <= right)
	        temp[k++] = arr[j++];

	    for(i = left ; i <= right ; i++)
	        arr[i] = temp[i];
	    
	    return inv_count;
	}

	public static int merge_Sort(int arr[],int temp[],int left,int right)
	{
	    int mid,inv_count = 0;
	    if(right > left)
	    {
	        mid = (left + right)/2;

	        inv_count += merge_Sort(arr,temp,left,mid);
	        inv_count += merge_Sort(arr,temp,mid+1,right);

	        inv_count += merge(arr,temp,left,mid+1,right);
	    }
	    return inv_count;
	}

	public static void main(String args[])
	{
	    int arr[]={5,3,2,1,4};
	    int n=5;
	    int temp[]=new int[n];
	    int ans = merge_Sort(arr,temp,0,n-1);
	    System.out.println(ans);}}
