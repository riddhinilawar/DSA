Group Anagrams, gfg                                                                 LC-49

Time Complexity :  O(N x M x logM + N). 
Auxiliary space: O(M x N). 
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map=new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        if (strs.length == 1) {
            result.add(Arrays.asList(strs));
            return result;
        }

        for(int i=0;i<strs.length;i++)
        {
            char arr[]=strs[i].toCharArray();
            Arrays.sort(arr);
            String temp= new String(arr);

            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}

Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 
Example 1: Input: strs = ["eat","tea","tan","ate","nat","bat"]  
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2: Input: strs = [""]  
Output: [[""]]
Example 3: Input: strs = ["a"] 
Output: [["a"]]
 
Constraints:
•	1 <= strs.length <= 104
•	0 <= strs[i].length <= 100
•	strs[i] consists of lowercase English letters.
