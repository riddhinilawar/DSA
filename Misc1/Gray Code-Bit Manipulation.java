89. Gray Code

An n-bit gray code sequence is a sequence of 2n integers where:

Every integer is in the inclusive range [0, 2n - 1],
The first integer is 0,
An integer appears no more than once in the sequence,
The binary representation of every pair of adjacent integers differs by exactly one bit, and
The binary representation of the first and last integers differs by exactly one bit.
Given an integer n, return any valid n-bit gray code sequence.

 

Example 1:

Input: n = 2
Output: [0,1,3,2]
Explanation:
The binary representation of [0,1,3,2] is [00,01,11,10].
- 00 and 01 differ by one bit
- 01 and 11 differ by one bit
- 11 and 10 differ by one bit
- 10 and 00 differ by one bit
[0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
- 00 and 10 differ by one bit
- 10 and 11 differ by one bit
- 11 and 01 differ by one bit
- 01 and 00 differ by one bit
Example 2:

Input: n = 1
Output: [0,1]
 

Constraints:

1 <= n <= 16

class Solution {
    public List<Integer> grayCode(int n) {

        List<Integer> ans = new ArrayList<Integer>();//need to maintain the order//
        Set<Integer> st = new HashSet<Integer>();
        
        ans.add(0);
        st.add(0);
        
        int numsReq = (1<<n);//number required in list//
        int lastNum = 0;
        //check from right to left, if set bit is 1 make it 0, or 0 make it 1.
        while( ans.size() < numsReq ){
            int newNum = 0;
            for(int bitIdx=0; bitIdx<n; bitIdx++){
                //get the bit//
                int lastNumBit = (lastNum>>bitIdx)&1;

                //shuffling the bit//
                if( lastNumBit == 1 ) newNum = lastNum - (1<<bitIdx);
                else newNum = lastNum + (1<<bitIdx);

                //If dosent came earlier consider it//
                if( st.contains(newNum) == false ){
                    break;
                }
            }
            st.add(newNum);
            ans.add(newNum);
            lastNum = newNum;
        }
        
        return ans;
    }
}
