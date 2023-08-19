Plus One,LC-66

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.
 
Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 
Constraints:
•	1 <= digits.length <= 100
•	0 <= digits[i] <= 9
•	digits does not contain any leading 0's.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)~tentative

 class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int carry=1;
        for(int i=n-1;i>=0;i--){
            int temp=digits[i]+carry;
            if(temp>9){
                carry=1;
                digits[i]=temp-10;
            }
            else{
                carry=0;
                digits[i]=temp;
                break;
            }
        }
        if(carry==1){
            int arr[]=new int[n+1];
            arr[0]=1;
            for(int i=0;i<n;i++)
                arr[i+1]=digits[i];
            return arr;
        }
        return digits;
    }
}
----------------------------------------------------------------------------------------------------------------------
class Solution {
     
    public int[] plusOne(int[] digits) {
        
        int n=digits.length;
        
        int carry=0;
        int add=1;
        for(int i=n-1;i>=0;i--)
        {
           if((digits[i]+carry)>9)
            {
                digits[i]=0;
                carry=1;
            }
            else if(carry==1)
            {
                digits[i]=digits[i]+1;
                carry=0;
            }
            else if((digits[i]+add)>9&&add==1)
            {
                digits[i]=0;
                carry=1;
                add=0;
            }
            else if(add==1)
            {
                digits[i]=digits[i]+1;
                add=0;
            }
        }
        if(carry==1)
        {
            int a[]=new int[n+1];
            a[0]=1;
            System.arraycopy(digits, 0, a,1, n);
            return a;
        }
        return digits; 
    }
}
