Sort an array of 0s, 1s and 2s                        LC-75
Problem Statement: Given an array consisting of only 0s, 1s and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)
Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Input: nums = [2,0,1]
Output: [0,1,2]

Input: nums = [0]
Input: nums = [0]

Solution 1: Sorting ( even if it is not the expected solution here but it can be considered as one of the approaches). Since the array contains only 3 integers, 0, 1, and 2. Simply sorting the array would arrange the elements in increasing order.
Time Complexity: O(N*logN)
Space Complexity: O(1)

Solution 2: Keeping count of values
Intuition: Since in this case there are only 3 distinct values in the array so it’s easy to maintain the count of all, Like the count of 0, 1, and 2. This can be followed by overwriting the array based on the frequency(count) of the values.
Approach: 
Take 3 variables to maintain the count of 0, 1 and 2.
Travel the array once and increment the corresponding counting variables
( let’s consider count_0 = a, count_1 = b, count_2 = c )
In 2nd traversal of array, we will now over write the first ‘a’ indices / positions in array with ’0’, the next ‘b’ with ‘1’ and the remaining ‘c’ with ‘2’.
Time Complexity: O(N) + O(N)
Space Complexity: O(1)

Solution 3: 3-Pointer approach
This problem is a variation of the popular Dutch National flag algorithm 
Intuition: In this approach, we will be using 3 pointers named low, mid, and high. We will be using these 3 pointers to move around the values. The primary goal here is to move 0s to the left and 2s to the right of the array and at the same time all the 1s shall be in the middle region of the array and hence the array will be sorted. 
Approach: 
Initialize the 3 pointers such that low and mid will point to 0th index and high pointer will point to last index
int low = arr[0]
int mid = arr[0]
int high = arr[n – 1]
Now there will 3 different operations / steps based on the value of arr[mid] and will be repeated until mid <= high.

arr[mid] == 0:
swap(arr[low], arr[mid])
low++, mid++

arr[mid] == 1:
mid++

arr[mid] == 2:
swap(arr[mid], arr[high])
high–;
The array formed after these steps will be a sorted array.

Approach 3: Dutch National flag algorithm 
class Solution {
    public void sortColors(int[] nums) {
        int start=0;
        int mid=0;
        int end=nums.length-1;
        
        while(mid<=end){
            if(nums[mid]==0){
                int temp=nums[mid];
                nums[mid]=nums[start];
                nums[start]=temp;
                mid++;
                start++;
                //after swapping incrementing both pointers because//
                //start will be before or at point of mid//
                //if mid == 0 start will be 1 or 0//
                //so that it can be incementedted and won't go in never ending loop//
                //[2,0,2,1,1,0] -> [Output] [1,1,2,2,0,0] If you increment mid//
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                int temp=nums[mid];
                nums[mid]=nums[end];
                nums[end]=temp;
                end--;
            }
        }
    }
}
