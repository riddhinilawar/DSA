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

=================================================================================================================
