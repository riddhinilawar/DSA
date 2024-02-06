public void binarySearch(int arr[],int n,int target){
    int low=0;
    int high=n-1;
    while(low<=high){
        int mid=(low+high)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(target>arr[mid]){
            low=mid+1;
        }
        else{
            high=mid-1;
        }
    }
    return -1;
}

TC:As we divide : O(log n) 
    Ex: n=32
    log base2 32
    log base2 2power5
    5 log base2 2
    5*1
    5
    for the array of size 32 we need 5 operations to perform and get the target element.
