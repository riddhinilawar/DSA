1239. Maximum Length of a Concatenated String with Unique Characters

You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.
      
Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters.
 

Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lowercase English letters.

class Solution {
    public int maxLength(List<String> arr) {
        int n=arr.size();
        int bitRep[]=new int[n];
        bitRep=getBitRep(arr,n);

        return helper(0,arr,bitRep,n,0);
    }
    public int helper(int idx,List<String> arr,int bitRep[],int n,int currBitRep){
        if(idx==n){
            return 0;
        }
        int max=Integer.MIN_VALUE;

        if(bitRep[idx] !=-1 && (currBitRep&bitRep[idx])==0){
            max=Math.max(max,arr.get(idx).length()+helper(idx+1,arr,bitRep,n,currBitRep|bitRep[idx]));
        }

        max=Math.max(max,helper(idx+1,arr,bitRep,n,currBitRep));

        return max;
    }
    public int[] getBitRep(List<String> arr,int n){
        int[] bitRep=new int[n];

        for(int i=0;i<n;i++){
            String temp=arr.get(i);
            int bit=0;
            for(char j:temp.toCharArray()){
                if((bit & (1<<(j-'a'))) > 0){
                    bit=-1;
                    break;
                }
                bit=bit|(1<<(j-'a')); 
            }
            bitRep[i]=bit;
            
        }

        return bitRep;
    }
}
