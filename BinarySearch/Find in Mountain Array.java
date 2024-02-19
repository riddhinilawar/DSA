1095. Find in Mountain Array

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
		int length=mountainArr.length();
		int peakIndex=getPeakIndex(length,mountainArr);
		
		int index=getLeftSideTragetBS(target,peakIndex,mountainArr);
		if(index==-1){
			index=getRightSideTragetBS(target,peakIndex,length-1,mountainArr);
		}
		
		return index;
	}
    public int getPeakIndex(int length,MountainArray mountainArr){
    	int start=1;
		int end=length-2;
		
		if(length==1){
			return 0;
		}
		if(mountainArr.get(0)>mountainArr.get(1)){
			return 0;
		}
		if(mountainArr.get(length-1)>mountainArr.get(length-2)){
			return length-2;
		}
		
		while(start<=end){
			int mid=start+(end-start)/2;
			int left = mountainArr.get(mid-1);
			int curr = mountainArr.get(mid);
			int right = mountainArr.get(mid+1);
			
			if(curr>left && curr>right){
				return mid;
			}
			else if(curr<left){
				end=mid-1;
			}
			else{
				start=mid+1;
			}	
		}
		
		return -1;
		
	}
    public int getLeftSideTragetBS(int target,int end,MountainArray mountainArr){
		int start=0;
		while(start<=end){
			int mid=start+(end-start)/2;
			int curr=mountainArr.get(mid);
			if(curr==target){
				return mid;
			}
			if(curr>target){
				end=mid-1;
			}
			else{
				start=mid+1;
			}
		}
    	return -1;
	}
    public int getRightSideTragetBS(int target,int start,int end,MountainArray mountainArr){
		
		while(start<=end){
			int mid=start+(end-start)/2;
			int curr=mountainArr.get(mid);
			if(curr==target){
				return mid;
			}
			if(curr<target){
				end=mid-1;
			}
			else{
				start=mid+1;
			}
		}
    	return -1;
	}
}


(This problem is an interactive problem.)

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

 

Example 1:

Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:

Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.
 

Constraints:

3 <= mountain_arr.length() <= 104
0 <= target <= 109
0 <= mountain_arr.get(index) <= 109
