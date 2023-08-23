Add two Array format of integers                                   LC-989
The array-form of an integer num is an array representing its digits in left to right order.
•	For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
 
Example 1:
Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
Example 2:
Input: num = [2,7,4], k = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455
Example 3:
Input: num = [2,1,5], k = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
 
Constraints:
•	1 <= num.length <= 104
•	0 <= num[i] <= 9
•	num does not contain any leading zeros except for the zero itself.
•	1 <= k <= 104
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
        ArrayList<Integer> arr=new ArrayList<Integer>();
        
        int idx=num.length-1, carry=0;
        
        while(k>0 && idx>=0)
        {
            int first=num[idx];
            int second=k%10;
            
            if(first+second+carry > 9)
            {
                arr.add((first+second+carry)%10);
                carry=1;
            }
            else
            {
                arr.add(first+second+carry);
                carry=0;
            }
            
            
            k/=10;
            idx--;
        }
        
        System.out.println(carry);
        
        while(k>0)
        {
            int curr=k%10;
            if(curr+carry > 9)
            {
                arr.add((curr+carry)%10);
                carry=1; 
            }
            else
            {
                arr.add(curr+carry);
                carry=0;
            }
            k/=10;
        }
        
        while(idx>=0)
        {
            int curr=num[idx];
            if(curr+carry > 9)
            {
                arr.add((curr+carry)%10);
                carry=1; 
            }
            else
            {
                arr.add(curr+carry);
                carry=0;
            }
            idx--;
        }
        
        if(carry==1)arr.add(carry);
        
        Collections.reverse(arr);
        
        return arr;
    }
}
