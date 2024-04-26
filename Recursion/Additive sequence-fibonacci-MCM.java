Additive sequence


Given a string n, your task is to find whether it contains an additive sequence or not. A string n contains an additive sequence if its digits can make a sequence of numbers in which every number is addition of previous two numbers. You are required to complete the function which returns true if the string is a valid sequence else returns false. For better understanding check the examples.

Note: A valid string should contain at least three digit to make one additive sequence. 

Example 1:

Input:  
n = "1235813"
Output: 
1
Explanation: 
The given string can be splited into a series of numbers  
where each number is the sum of the previous two numbers: 
1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8, and 5 + 8 = 13. Hence, the output would be 1 (true).
Example 2:

Input:  
n = "11235815"
Output: 
0
Explanation: 
We can start with the first two digits: "11".
First number: 1, Second number: 1, Sum: 1 + 1 = 2
Now, we have "2" as the next number.
First number: 1, Second number: 2, Sum: 1 + 2 = 3
Now, we have "3" as the next number.
First number: 2, Second number: 3, Sum: 2 + 3 = 5
Now, we have "5" as the next number.
First number: 3, Second number: 5, Sum: 3 + 5 = 8
Now, we have "8" as the next number.
First number: 5, Second number: 8, Sum: 5 + 8 = 13
At this point, there is no "13" present in the remaining digits "815". Hence, the output would be 0 (or false).
User Task: 
Your task is to complete the function isAdditiveSequence() which takes a single string as input n and returns a boolean value indicating whether the given string contains an additive sequence or not. You need not take any input or print anything.

Expected Time Complexity: O(n3).
Expected Auxiliary Space: O(n).

Constraints:
3 <= length( n ) <= 200
1 <= digits of string <= 9


class Solution {
    public boolean isAdditiveSequence(String str) {
        return helper(str.length()-1,str.length()-1,str);
    }
    public boolean helper(int ts,int te,String str){
        if(ts<=1){
            return false;
        }
        
        int third=Integer.parseInt(str.substring(ts,te+1));
        
        for(int start=ts-2;start>=0;start--){
            
            for(int end=start;end<ts-1;end++){
                
                if(ts-start >= 16 )break;
               
                if(end-start >8)continue;
                int first=Integer.parseInt(str.substring(start,end+1));
                if(ts-(end+1) >8)continue;
                int second=Integer.parseInt(str.substring(end+1,ts));

                 
                if(first+second==third){
                    if(start==0)return true;
                    if(helper(end+1,ts-1,str)==true)return true;
                }
                
            }
            
        }
        
        if(third<(int)1e8 && helper(ts-1,te,str)==true)
            return true;
            
        return false;
    }
}
