Second largest element in the array, without sort, gfg
Second largest digit in the staring -without sort  LC-1796
Solution 1: (Brute Force) [this approach only works if there are no duplicates]
Intuition: What do we do to find the largest or the smallest element present in an array? We ideally sort them and the first element would be the smallest of all while the last element would be the largest. Can we find the second smallest and second-largest using a similar approach?
Approach:
Sort the array in ascending order
The element present at the second index is the second smallest element
The element present at the second index from the end is the second largest element
Time Complexity: O(NlogN), For sorting the array
Space Complexity: O(1)
Solution 2(Better Solution)
Intuition: Even though we want to have just the second smallest and largest elements, we are still sorting the entire array for that and thus increasing the time complexity. Can we somehow try to not sort the array and still get our answer?
Approach:
Find the smallest and largest element in the array in a single traversal
After this, we once again traverse the array and find an element that is just greater than the smallest element we just found.
Similarly, we would find the largest element which is just smaller than the largest element we just found
Indeed, this is our second smallest and second largest element.

Time Complexity: O(N), We do two linear traversals in our array
Space Complexity: O(1)
Solution 3(Best Solution)
Intuition: In the previous solution, even though we were able to bring down the time complexity to O(N), we still needed to do two traversals to find our answer. Can we do this in a single traversal by using smart comparisons on the go?
Approach:
We would require four variable : small,second_small,large,second_large. Variable small and second_small are initialized to INT_MAX while large and second_large are initialized to INT_MIN.
Second Smallest Algo:
If the current element is smaller than ‘small’, then we update second_small and small variables
Else if the current element is smaller than ‘second_small’ then we update the variable ‘second_small’
Once we traverse the entire array, we would find the second smallest element in the variable second_small.
Here’s a quick demonstration of the same.
Second Largest Algo:
If the current element is larger than ‘large’ then update second_large and large variables
Else if the current element is larger than ‘second_large’ then we update the variable second_large.
Once we traverse the entire array, we would find the second largest element in the variable second_large.
Here’s a quick demonstration of the same.

Time Complexity: O(N), Single-pass solution
Space Complexity: O(1)

Gfg solution:-
class Solution {
    int print2largest(int arr[], int n) {
        int first=-1;
        int second=-1;
        
        for(int i=0;i<n;i++)
        {
            if(arr[i]>first)
            {
                second=first;
                first=arr[i];
            }
            
            if(arr[i]>second&&arr[i]!=first)
            {
                second=arr[i];
            }
        }
        return second;
    }
}
Leetcode:
Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
An alphanumeric string is a string consisting of lowercase English letters and digits.
Example 1:Input: s = "dfa12321afd"
Output: 2 Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
Example 2:Input: s = "abc1111"
Output: -1 Explanation: The digits that appear in s are [1]. There is no second largest digit. 
Constraints: 1 <= s.length <= 500 , s consists of only lowercase English letters and/or digits.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

















My approach:
class Solution {
    public int secondHighest(String s) {  
        int first=-1;
        int second=-1;
        
        for(int i=0;i<s.length();i++)
        {
            int temp=s.codePointAt(i);
            if(temp>=48&&temp<=57)
            {
                int c=Character.getNumericValue(s.charAt(i));

                if(c>first)
                {
                    second=first;
                    first=c;
                }
                if(c>second&&c!=first)
                {
                    second=c;
                }
            }
        }
        //System.out.println("---"+first+" "+second);
        return second;
    }
}
Leetcode discussion:
class Solution {
   public int secondHighest(String s) {
        int firstMax =-1; int secondMax =-1;
       
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>=48 && c<=57){
                
                if((c-48) > firstMax){
                    secondMax = firstMax;
                    firstMax = (c-48);
                    
                }
                else if((c-48) > secondMax && firstMax!=(c-48)){
                    secondMax = (c-48);
                }
                
            }
        }
		// if still we haven't found any second largest element
        return (secondMax==-1)? -1:secondMax ;
    }
}
