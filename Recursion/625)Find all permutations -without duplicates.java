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

===========================================VINIT's Approach======================================================================

Note::On every iteration just checking thatweather the particular element got sorted with that digit.
    
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        permutation(nums,0,ans);
        return ans;
    }
    public void permutation(int arr[],int index,List<List<Integer>> list){
        if(index==arr.length){
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                temp.add(arr[i]);
            }
            list.add(temp);
            return;
        }
        boolean hash[]=new boolean[21];
        for(int i=index;i<arr.length;i++){
            if( !hash[arr[i]+10] ){
                swap(arr,index,i);
                permutation(arr,index+1,list);
                swap(arr,i,index);
            }
            hash[arr[i]+10] = true;
        }
    }
    public void swap(int arr[],int a,int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
