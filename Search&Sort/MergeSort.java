Expected Time Complexity: O(nlogn)  in all cases
Expected Auxiliary Space: O(n)


class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
        int left[]=new int[m-l+1];
        int right[]=new int[r-m];
        
        int i=0,j=0,k=l;
        
        for(int x=l;x<=m;x++)
            left[i++]=arr[x];
        for(int x=m+1;x<=r;x++)
            right[j++]=arr[x];
            
        i=0;j=0;
        
        while(i<left.length && j<right.length){
            if(left[i]<=right[j])
                arr[k++]=left[i++];
            else
                arr[k++]=right[j++];
        }
        
        while(i<left.length)
            arr[k++]=left[i++];
        
        while(j<right.length)
            arr[k++]=right[j++];
        
    }
    void mergeSort(int arr[], int l, int r)
    {
        if(l<r){
            int mid=l+(r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }
}
-------------------------------------------------------------------------------
Merge Sort – In Place ,gfg
void merge(int arr[], int start, int mid, int end)
    {
         int index1=start;
         int index2=mid+1;
         int a[]=new int[end-start+1];
         int i=0;
         while(index1<=mid&&index2<=end)
         {
             if(arr[index1]<arr[index2])
             {
                 a[i]=arr[index1];
                 i++;
                 index1++;
             }
             else if(arr[index1]==arr[index2])
             {
                 a[i]=arr[index1];
                 i++;
                 index1++;
                 a[i]=arr[index2];
                 i++;
                 index2++;
             }
             else
             {
                 a[i]=arr[index2];
                 i++;
                 index2++;
             }
            
         }
         while(index1<=mid)
         {
                 a[i]=arr[index1];
                 i++;
                 index1++;
         }
         while(index2<=end)
         {
                 a[i]=arr[index2];
                 i++;
                 index2++;
         }
         for(int k=0,j=start;k<a.length;k++,j++)
         {
             arr[j]=a[k];
         }
    }
    void mergeSort(int arr[], int l, int r)
    {
       
        if(l>=r)return;
        int mid=l+(r-l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

//function calling : (arr,0,arr.length-1);

Input:
N = 5
arr[] = {4 1 3 9 7}
Output:
1 3 4 7 9
Input:
N = 10
arr[] = {10 9 8 7 6 5 4 3 2 1}
Output:
1 2 3 4 5 6 7 8 9 10
step 1: start
step 2: declare array and left, right, mid variable
step 3: perform merge function.
    if left > right
        return
    mid= (left+right)/2
    mergesort(array, left, mid)
    mergesort(array, mid+1, right)
    merge(array, left, mid, right)
step 4: Stop
 

Merge Sort – Using extra space, LC-912
class Solution {
    public int[] sortArray(int[] nums) {
     
        if(nums.length==1)return nums;
        
        int mid=nums.length/2;
        int[] left = sortArray(Arrays.copyOfRange(nums,0,mid));
        int[] right = sortArray(Arrays.copyOfRange(nums,mid,nums.length));
        
        return merge(left, right);
    }
    int[] merge(int left[],int right[])
    {
         int index1=0;
         int index2=0;
         int a[]=new int[left.length+right.length];
         int i=0;
         while(index1<left.length&&index2<right.length)
         {
             if(left[index1]<right[index2])
             {
                 a[i]=left[index1];
                 i++;
                 index1++;
             }
             else if(left[index1]==right[index2])
             {
                 a[i]=left[index1];
                 i++;
                 index1++;
                 a[i]=right[index2];
                 i++;
                 index2++;
             }
             else
             {
                 a[i]=right[index2];
                 i++;
                 index2++;
             }
            
         }
         while(index1<left.length)
         {
                 a[i]=left[index1];
                 i++;
                 index1++;
         }
         while(index2<right.length)
         {
                 a[i]=right[index2];
                 i++;
                 index2++;
         }
         return a;}}
