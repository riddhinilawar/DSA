Custom Sort String- gfg                                                       LC-791
You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
Return any permutation of s that satisfies this property.
 
Example 1:
Input: order = "cba", s = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
Example 2:
Input: order = "cbafg", s = "abcd"
Output: "cbad"
 
Constraints:
•	1 <= order.length <= 26
•	1 <= s.length <= 200
•	order and s consist of lowercase English letters.
•	All the characters of order are unique.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)



class Solution {
    public String customSortString(String order, String s) {
        
        char[] S=s.toCharArray();
        char[] O=order.toCharArray();
        
       
        int N=S.length;
        int M=O.length;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++)
        {
            if(map.containsKey(S[i])==false)
                map.put(S[i],1);
            else
                map.put(S[i],map.get(S[i])+1);
        }
        
        List<Character> a = new ArrayList<Character>();
        
        for(int i=0;i<M;i++)
        {
            while(map.containsKey(O[i])==true&&map.get(O[i])!=0)
            {
                    map.put(O[i],map.get(O[i])-1);
                    a.add(O[i]);
            }
        }
        
        for(int i=0;i<N;i++)
        {
            while(map.containsKey(S[i])==true&&map.get(S[i])!=0)
            {
                    map.put(S[i],map.get(S[i])-1);
                    a.add(S[i]);
            }
        }
        
        //System.out.println(a);
        
        String ans="";
        for(int i=0;i<a.size();i++)
        {
            ans+=a.get(i);
        }
        
        return ans;  
    }
}
