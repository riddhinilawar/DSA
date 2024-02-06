public void binarySearch(int arr[],int n,int target){
    return helper(0,n-1,target,arr);
}
public int helper(int low,int high,int target,int arr[]){
    if(low>high){
        return -1;
    }
    int mid=(low+high)/2;
    if(target==arr[mid]){
        return mid;
    }
    else if(target>arr[mid]){
        return helper(mid+1,high,target,arr);
    }
    else{
        return helper(low,mid-1,target,arr);
    }
}
