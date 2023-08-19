Relative Sort Array                                                            LC-1122
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
Example 1:               Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]            Output: [2,2,2,1,4,3,3,9,6,7,19]
Example 2:               Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]                        Output: [22,28,8,6,17,44]
Constraints:
•	1 <= arr1.length, arr2.length <= 1000
•	0 <= arr1[i], arr2[i] <= 1000
•	All the elements of arr2 are distinct.
•	Each arr2[i] is in arr1.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
class Solution {
    public int[] relativeSortArray(int[] arr, int[] brr) {
         Arrays.sort(arr);
        int N=arr.length;
        int M=brr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++)
        {
            if(map.containsKey(arr[i])==false)
                map.put(arr[i],1);
            else
                map.put(arr[i],map.get(arr[i])+1);
        }
        List<Integer> a = new ArrayList<Integer>();
        
        for(int i=0;i<M;i++)
        {
            while(map.containsKey(brr[i])==true&&map.get(brr[i])!=0)
            {
                    map.put(brr[i],map.get(brr[i])-1);
                    a.add(brr[i]);
            }
        }
        
        for(int i=0;i<N;i++)
        {
            while(map.containsKey(arr[i])==true&&map.get(arr[i])!=0)
            {
                    map.put(arr[i],map.get(arr[i])-1);
                    a.add(arr[i]);
            }
        }  
        //System.out.println(a);
        
        int ans[]= new int[a.size()];
        for(int i=0;i<ans.length;i++)
        {
            ans[i]=a.get(i);
        }
        return ans;
    } }
