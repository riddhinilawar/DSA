1481. Least Number of Unique Integers after K Removals

Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

 

Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.
Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 

Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9
0 <= k <= arr.length



class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        int n=arr.length;

        int[] count = new int[n+1];

        int totalUniqueElements = 0;
        int individualElementLength=1;

        for (int i = 1; i < n; i++) {
            if (arr[i]==arr[i-1]) {
                individualElementLength++;
            } else {
                totalUniqueElements++;
                count[individualElementLength]++;
                individualElementLength=1;
            }
        }
        count[individualElementLength]++;
        totalUniqueElements++;

        for(int i=1;i<n+1;i++) {
            int canRemove = Math.min(k/i, count[i]);
            totalUniqueElements-=canRemove;
            k-=canRemove*i;
        }
        return totalUniqueElements;
    }
}


============================================================================================================

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n=arr.length;
        ArrayList<int[]> list = new ArrayList<>();
        
        Arrays.sort(arr);

        int count=1;
        int element=arr[0];

        for(int i=1;i<n;i++){
            if(arr[i]!=arr[i-1]){
                list.add(new int[]{element,count});
                count=1;
                element=arr[i];
            }
            else{
                count++;
            }
        }

        list.add(new int[]{element,count});

        Collections.sort(list,(a,b)->a[1]-b[1]);

        int ans=list.size();
        for(int i=0;i<list.size();i++){
            //System.out.println(list.get(i)[0]+" "+list.get(i)[1]+" "+k);
            if(list.get(i)[1]<=k){
                ans--;
                k-=list.get(i)[1];
            }
            else{
                break;
            }
        }
        return ans;
    }
}
