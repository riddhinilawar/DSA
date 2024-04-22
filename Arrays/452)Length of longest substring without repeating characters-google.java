Length of longest substring without repeating characters                                                     LC-3
Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 
Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

Solution 1: Brute Force
Approach: This approach consists of taking the two loops one for traversing the string and another loop – nested loop for finding different substrings and after that, we will check for all substrings one by one and check for each and every element if the element is not found then we will store that element in HashSet otherwise we will break from the loop and count it.
Time complexity: O(n^2)
Space Complexity: O(n)—because of using hashset

Soltuion 2:Optimal solution 
Approach: We will have two pointers left and right. Pointer ‘left’ is used for maintaining the starting point of substring while ‘right’ will maintain the endpoint of the substring.’ right’ pointer will move forward and check for the duplicate occurrence of the current element if found then ‘left’ pointer will be shifted ahead so as to delete the duplicate elements.
Time Complexity: O( 2*N ) (sometimes left and right both have to travel complete array)
Space Complexity: O(N) where N is the size of HashSet taken for storing the elements

Solution 3: Optimised  Approach 2
Approach: In this approach, we will make a map that will take care of counting the elements and maintaining the frequency of each and every element as a unity by taking the latest index of every element.
Time Complexity: O( N )
Space Complexity: O(N) where N represents the size of HashSet where we are storing our elements

Approach 1: nested loop approach using hashset
public class LengthofLongestSubstringwithoutanyRepeatingCharacter2 {
	  static int solve(String str) {

	        if(str.length()==0)
	             return 0;
	        int maxans = Integer.MIN_VALUE;
	        for (int i = 0; i < str.length(); i++) // outer loop for traversing the string
	        {
	            Set<Character> se = new HashSet<Character>();
	            for (int j = i; j < str.length(); j++) // nested loop for getting different string starting with str[i]
	            {
	                if (se.contains(str.charAt(j))) // if element if found so mark it as ans and break from the loop
	                {
	                    maxans = Math.max(maxans, j - i);
	                    break;
	                }
	                se.add(str.charAt(j));
	            }
	        }
	        return maxans;
	    }

	    public static void main(String args[]) {
	        String str = "takeUforwardriddhi";
	        System.out.println("The length of the longest substring without repeating characters is " + solve(str));
	    }
}
Approach 3: using hashmap
public static int lengthOfLongestSubstring(String S) {
	        if(S.length()==0)return 0;
	        
	        int r=0,l=0;
	        int max_len=1;
	        
	        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
	        
	        while(r<S.length()&&l<S.length())
	        {
	            if(map.containsKey(S.charAt(r))&&map.get(S.charAt(r))>=l)
	            {
	                l=map.get(S.charAt(r))+1;
	                map.put(S.charAt(r),r);
	            }
	            else
	            {		
	                map.put(S.charAt(r),r);
	            }
	            
	            max_len=Math.max(max_len,r-l+1);
	           // System.out.println(max_len+" "+r);
	            r++;
	        }
	        return max_len;
	    }
Exception : Input : geeksforgeeks (at second occurrence of ‘g’---l<map.getvalue(r))
