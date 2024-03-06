315. Count of Smaller Numbers After Self
Note::similar like count inversion..

Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].
TC::O(nlogn)
 

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Example 2:

Input: nums = [-1]
Output: [0]
Example 3:

Input: nums = [-1,-1]
Output: [0,0]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104


class Solution {
    Pair[] arr;
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        
        arr = new Pair[n];
        for(int i=0;i<n;i++){
            arr[i]=new Pair(nums[i],i);
        }

        int start=0;
        int end=n-1;

        mergeSort(start,end,ans);



        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }
    public void mergeSort(int start,int end,int[] ans){
        if(start<end){
            int mid=start+(end-start)/2;
            mergeSort(start,mid,ans);
            mergeSort(mid+1,end,ans);
            merge(start,mid,end,ans);
        }
    }
    public void merge(int start,int mid,int end,int[] ans){
        //System.out.println(start+" "+mid+" "+end);



        
        Pair left[]=new Pair[mid-start+1];
        Pair right[]=new Pair[end-mid];

        int i=0,j=0,k=start;

        for(int idx=start;idx<=mid;idx++){
            left[i]=arr[idx];
            i++;
        }
        for(int idx=mid+1;idx<=end;idx++){
            right[j]=arr[idx];
            j++;
        }

        i=0;
        j=0;

      ===============================================================actual logic====================================
        int tempAns[]=new int[left.length];
        while(i<left.length && j<right.length){
            if(left[i].num <= right[j].num){
                i++;
            }
            else{
                tempAns[i]++;
                j++;
            }
        }

        ans[left[0].idx]+=tempAns[0];
        for(int z=1;z<tempAns.length;z++){
            tempAns[z]=tempAns[z]+tempAns[z-1];
            ans[left[z].idx]+=tempAns[z];
        }

===============================================================actual logic ends here===================================
        i=0;
        j=0;

        while(i<left.length & j<right.length){
            if(left[i].num <= right[j].num){
                //System.out.println("In 1::"+left[i].num+" : "+right[j].num);
                arr[k]=left[i];
                k++;
                i++;
            }
            else{
                //System.out.println("In 2::"+left[i].num+" : "+right[j].num);
                arr[k]=right[j];
                k++;
                j++;
            }
        }

        while(i<left.length){
            arr[k]=left[i];
            k++;
            i++;
        }

        while(j<right.length){
            arr[k]=right[j];
            k++;
            j++;
        }
    }
}
class Pair{
    int num;
    int idx;
    Pair(int num,int idx){
        this.num=num;
        this.idx=idx;
    }
}
