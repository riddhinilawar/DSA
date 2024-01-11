Given a non-negative integer S represented as a string, remove K digits from the number so that the new number is the smallest possible.
Note : The given num does not contain any leading zero.

Example 1:

Input:
S = "149811", K = 3
Output: 
111
Explanation: 
Remove the three digits 
4, 9, and 8 to form the new number 111
which is smallest.
Example 2:

Input:
S = "1002991", K = 3
Output: 
21
Explanation: 
Remove the three digits 1(leading
one), 9, and 9 to form the new number 21(Note
that the output must not contain leading
zeroes) which is the smallest.
Your Task:
You don't need to read input or print anything. Your task is to complete the function removeKdigits() which takes the string S and an integer K as input and returns the new number which is the smallest possible.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).

Constraints:
1<= K <= |S|<=106


class Solution {
    public String removeKdigits(String S, int k) {
        
        Stack<Character> st=new Stack<>();
        for(int i=0;i<S.length();i++){
            while(!st.isEmpty() && st.peek()>S.charAt(i) && k>0){
                st.pop();
                k--;
            }
            st.add(S.charAt(i));
           
        }
        
        while(k-->0){
            st.pop();
        }
        
        if(st.isEmpty())
        return "0";
        
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop()+"");
        }
        
        ans=ans.reverse();
        
        int index=0;
        while(index<ans.length()-1 && ans.charAt(index)=='0'){
            index++;
        }
        return ans.substring(index);
    }
}
