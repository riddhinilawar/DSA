Find the maximum subset XOR of a given set
Given a set of positive integers. find the maximum XOR subset value in the given set. Expected time complexity O(n).

Examples:

Input: set[] = {2, 4, 5}
Output: 7
The subset {2, 5} has maximum XOR value

Input: set[] = {9, 8, 5}
Output: 13
The subset {8, 5} has maximum XOR value

Input: set[] = {8, 1, 2, 12, 7, 6}
Output: 15
The subset {1, 2, 12} has maximum XOR value

Input: set[] = {4, 6}
Output: 6
The subset {6} has maximum XOR value


  import java.util.*; 
class Solution { 

	//this solution gets from discussion 
	public static int findMaximumXOR(int[] nums) { 

		int result = 0; 
		int mask = 0; 

		//let's check every possible positive integer number 
		for(int i=31;i>=0;i--){ 

			//mask start from most significant bit-1, 01000...00,->01100...00,->>>>>> 01111...11 
			mask = mask | (1<<i); 

			//we have already had a result,just make result's effective bit position extend to right one more 
			//for example : 0110100..00 is result,let's check if 0110110..00 is the result 
			//let's check is the candidateResult possible? 
			int candidateResult = result | (1<<i); //(candidateResult as a result candidate) 

			//record all prefixes(we only need to operate the specific bit positions) 
			HashSet<Integer> set = new HashSet<>(); 
			for(int num : nums){ 
				set.add(num & mask); 
			} 

			//let's check evey prefix 
			for(int prefix : set){ 

				//so..if candidateResult is the existed result, how could that happen? 
				//the tricky viewpoint is: 
				//A^B = candidateResult <=> B^candidateResult = A 
				if(set.contains(candidateResult^prefix)){ 

					//it is possible, so store this result 
					result = candidateResult; 
					break; 
				} 
			} 
		} 
		return result; 
	} 
// Driver code 
public static void main(String arg[]) { 
	int set[] = {9, 8, 5}; 

	System.out.print("Max subset XOR is "); 
	System.out.print(findMaximumXOR(set)); 
} 
}
