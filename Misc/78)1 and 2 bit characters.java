1 and 2 bit characters                                                       LC-717
We have two special characters:
•	The first character can be represented by one bit 0.
•	The second character can be represented by two bits (10 or 11).
Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.
 
Example 1:
Input: bits = [1,0,0]
Output: true
Explanation: The only way to decode it is two-bit character and one-bit character.
So the last character is one-bit character.
Example 2:
Input: bits = [1,1,1,0]
Output: false
Explanation: The only way to decode it is two-bit character and two-bit character.
So the last character is not one-bit character.
 
Constraints:
•	1 <= bits.length <= 1000
•	bits[i] is either 0 or 1.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
       
        int n=bits.length;
        if(n==1)return true;
        for(int i=0;i<n;i++)
        {
            if((i+1)<n&&bits[i]==1&&(bits[i+1]==1||bits[i+1]==0))
                i++;

            if(i<n&&(i+1)==n-1)return true;
        }

        return false;
    }
}
