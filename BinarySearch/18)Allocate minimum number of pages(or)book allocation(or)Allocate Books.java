Allocate minimum number of pages

Note:: sum is the end of Binary seaych but sum exceeds the int max value some times
what if number of books are less than number of students.
you are allocating minimum number of pages to student..what if the book had more pages than you are alloting..

You have N books, each with A[i] number of pages. M students need to be allocated contiguous books, with each student getting at least one book.
Out of all the permutations, the goal is to find the permutation where the sum of maximum number of pages in a book allotted to a student should be minimum, out of all possible permutations.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

 

Example 1:

Input:
N = 4
A[] = {12,34,67,90}
M = 2
Output:113
Explanation:Allocation can be done in 
following ways:
{12} and {34, 67, 90} Maximum Pages = 191
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90} Maximum Pages =113.
Therefore, the minimum of these cases is 113,
which is selected as the output.

Example 2:

Input:
N = 3
A[] = {15,17,20}
M = 2
Output:32
Explanation: Allocation is done as
{15,17} and {20}
Your Task:
You don't need to read input or print anything. Your task is to complete the function findPages() which takes 2 Integers N, and m and an array A[] of length N as input and returns the expected answer.


Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(1)


Constraints:
1 <= N <= 105
1 <= A [ i ] <= 106
1 <= M <= 105

 




class Solution 
{
    
    public static int findPages(int[]A,int N,int M)
    {
        if(M>N)return -1;
        long sum=0;int low=Integer.MAX_VALUE;int res=-1;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            low=Math.min(low,A[i]);
        }
        
        int high=(sum<Integer.MIN_VALUE || sum>Integer.MAX_VALUE)?Integer.MAX_VALUE:(int)sum;
        //System.out.println(low+" "+high);

        while(low<=high){
            int mid=low+(high-low)/2;
            if(allocate(mid,A,M)<=M){
                res=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return res;
    }
    public static int allocate(int mid,int[] A,int M){
        int allocation=1,pages=0;
        
        for(int i=0;i<A.length;i++){
            if(A[i]>mid)return Integer.MAX_VALUE;
            if(pages+A[i] > mid){
                pages=A[i];
                allocation+=1;
            }
            else
                pages+=A[i];
        }
        //System.out.println(mid+" "+allocation);
        return allocation;
    }
};


============================================================================================================






class Solution 
{
    
    public static int findPages(int[]A,int N,int M)
    {
        if(M>N)return -1;
        long sum=0;int low=Integer.MAX_VALUE;int res=-1;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            low=Math.min(low,A[i]);
        }
        
        int high=(sum<Integer.MIN_VALUE || sum>Integer.MAX_VALUE)?Integer.MAX_VALUE:(int)sum;
        //System.out.println(low+" "+high);

        while(low<=high){
            int mid=low+(high-low)/2;
            if(allocate(mid,A,M)==true){
                res=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return res;
    }
    public static boolean allocate(int mid,int[] A,int M){
        int allocation=1,pages=0;
        
        for(int i=0;i<A.length;i++){
            if(A[i]>mid)return false;
            if(pages+A[i] > mid){
                pages=A[i];
                allocation+=1;
            }
            else
                pages+=A[i];
        }
        //System.out.println(mid+" "+allocation);
        if(allocation>M)return false;
        else return true;
    }
};
